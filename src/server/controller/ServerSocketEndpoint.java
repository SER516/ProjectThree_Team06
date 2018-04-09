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
import server.listener.LogListenerInterface;
import server.model.FaceData;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;

@ServerEndpoint("/server")
public class ServerSocketEndpoint {
	
	private static Gson gson = new Gson();
	public static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
	private static Thread rateThread; // Child thread for sending random number
	private static LogListenerInterface logListener;
	private static DetectionListenerService detectionListenerService;
	

	static {
		rateThread = new Thread() {
			public void run() {
				while (true) {
					if (queue != null)
						if(ServerModelSingleton.getInstance().isAutoReset()) {
							sendAndUpdateCounter();	
						}
						if(ServerModelSingleton.getInstance().isOneTimeSend()) {
							sendAndUpdateCounter();
							ServerModelSingleton.getInstance().setOneTimeSend(false);
						}
					try {
						Double clock = ServerModelSingleton.getInstance().getStateInterval();
						Long sleepValue = (long) (clock * 1000);
						sleep(sleepValue);
					} catch (InterruptedException e) {
						System.out.print("Inside exception");
					}
				}
			}

			private void sendAndUpdateCounter() {
				double interval = ServerModelSingleton.getInstance().getStateInterval();
				double counter = ServerModelSingleton.getInstance().getFaceData().getCounter();
				double newCounter = counter + interval;
				ServerModelSingleton.getInstance().getFaceData().setCounter(newCounter);
				String data = gson.toJson(ServerModelSingleton.getInstance().getFaceData());
				logListener.logMessage(data);
				detectionListenerService.changeCounter(newCounter);
				sendAll(data);
				
			};
		};
		rateThread.start();
	}

	@OnMessage
	public void onMessage(Session session, String msg) {
		// provided for completeness, in out scenario clients don't send any msg.
		try {
			logListener.logMessage("received msg " + msg + " from " + session.getId());
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
		logListener.logMessage("Error on session " + session.getId());
	}

	@OnClose
	public void closedConnection(Session session) {
		queue.remove(session);
		logListener.logMessage("session closed: " + session.getId());
	}

	private static void sendAll(String msg) {
		try {
			/* Sends data to all open WebSocket sessions */
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
			logListener.logMessage("Sending " + msg + " to " + queue.size() + " clients");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void setLogListener(LogListenerInterface logListenerObject) {
		logListener = logListenerObject;
		
	}

	public static void setDetectionListenerService(DetectionListenerService detectionListenerServiceObject) {
		detectionListenerService = detectionListenerServiceObject;
		
	}

}
