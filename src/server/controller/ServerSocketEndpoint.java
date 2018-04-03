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

import server.listener.ClockListener;
import server.listener.LogListener;
import server.model.FaceData;
import server.model.ServerDataSingleton;

@ServerEndpoint("/server")
public class ServerSocketEndpoint {
	
	private static Gson gson = new Gson();
	private static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
	private static Thread rateThread; // Child thread for sending random number
	private static LogListener logListener;
	private static ClockListener clockListener;
	

	static {
		rateThread = new Thread() {
			public void run() {
				while (true) {
					if (queue != null)
						if(ServerDataSingleton.getInstance().isAutoReset()) {
							sendAndUpdateCounter();	
						}
						if(ServerDataSingleton.getInstance().isOneTimeSend()) {
							sendAndUpdateCounter();
							ServerDataSingleton.getInstance().setOneTimeSend(false);
						}
					try {
						Double clock = ServerDataSingleton.getInstance().getStateInterval();
						Long sleepValue = (long) (clock * 1000);
						System.out.println(sleepValue);
						sleep(sleepValue);
					} catch (InterruptedException e) {
						System.out.print("Inside exception");
					}
				}
			}

			private void sendAndUpdateCounter() {
				double interval = ServerDataSingleton.getInstance().getStateInterval();
				double counter = ServerDataSingleton.getInstance().getFaceData().getCounter();
				double newCounter = counter + interval;
				ServerDataSingleton.getInstance().getFaceData().setCounter(newCounter);
				String data = gson.toJson(ServerDataSingleton.getInstance().getFaceData());
				logListener.logMessage(data);
				clockListener.changeCounter(newCounter);
				sendAll(data);
				
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
		logListener.logMessage("New session opened: " + session.getId());
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
			e.printStackTrace();
		}
	}

	public static void setLogListener(LogListener logListenerObject) {
		logListener = logListenerObject;
		
	}

	public static void setClockListener(ClockListener clockListenerObject) {
		clockListener = clockListenerObject;
		
	}

}
