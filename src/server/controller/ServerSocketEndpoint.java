package server.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


import com.google.gson.Gson;

import server.model.FaceData;
import server.model.ServerDataSingleton;

@ServerEndpoint("/server")
public class ServerSocketEndpoint {
	
	private static Gson gson = new Gson();
	private static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
	private static Thread rateThread; // Child thread for sending random number
	static boolean flag= true;
	

	static {
		flag = true;

		rateThread = new Thread() {
			public void run() {
				Random rand = new Random();
				while (flag) {
					if (queue != null)
						if(ServerDataSingleton.getInstance().isAutoReset()) {
							try {
								long interval = ServerDataSingleton.getInstance().getStateInterval();
								long counter = ServerDataSingleton.getInstance().getFaceData().getCounter();
								long newCounter = counter + (interval/1000);
								ServerDataSingleton.getInstance().getFaceData().setCounter(newCounter);
								sendAll(gson.toJson(ServerDataSingleton.getInstance().getFaceData()));
							}
							catch(Exception e) {
								
							}
							
						}
					try {
						System.out.println(ServerDataSingleton.getInstance().getStateInterval());
						sleep(ServerDataSingleton.getInstance().getStateInterval());
					} catch (InterruptedException e) {
						System.out.print("Inside exception");
						
					}
					finally {
						
					}
				}
			};
		};
		rateThread.start();
	}

	@OnMessage
	public void onMessage(Session session, String msg) {
		// provided for completeness, in out scenario clients don't send any msg.
		try {
			System.out.println("received msg " + msg + " from " + session.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnOpen
	public void open(Session session) {
		queue.add(session);
		System.out.println("New session opened: " + session.getId());
	}

	@OnError
	public void error(Session session, Throwable t) {
		queue.remove(session);
		System.err.println("Error on session " + session.getId());
	}

	@OnClose
	public void closedConnection(Session session) {
		queue.remove(session);
		System.out.println("session closed: " + session.getId());
	}

	private static void sendAll(String msg) {
		try {
			/* Sends a random number all open WebSocket sessions */
			ArrayList<Session> closedSessions = new ArrayList<>();
			for (Session session : queue) {
				if (!session.isOpen()) {
					System.err.println("Closed session: " + session.getId());
					closedSessions.add(session);
				} else {
					session.getBasicRemote().sendText(msg);
				}
			}
			queue.removeAll(closedSessions);
			System.out.println("Sending " + msg + " to " + queue.size() + " clients");
		} catch (Throwable e) {
			flag = false;
			e.printStackTrace();
		}
	}

}
