package client.controller;

import client.model.ClientModelSingleton;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebSocketClientMain {
	Thread clientThread;
	private static Object waitLock = new Object();
	Session session = null;
	
	private static void wait4TerminateSignal() {
		synchronized (waitLock) {
			try {
				waitLock.wait();
			} catch (InterruptedException e) {
				System.out.println(e.getStackTrace());
			}
		}
	}

	public void connectToServer() {
		final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
		Runnable serverTask = new Runnable() {
			
			@Override
			public void run() {
				WebSocketContainer container = null;
				try {
					container = ContainerProvider.getWebSocketContainer();
					session = container.connectToServer(ClientSocketEndpoint.class,
							URI.create("ws://localhost:8080/server"));
					ClientModelSingleton.getInstance().setSessionMaintained(true);
					wait4TerminateSignal();
				} catch (Exception e) {
					System.out.println("Server Not Running");
					e.printStackTrace();
				} finally {
					if (session != null) {
						try {
							session.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} 
				
			}
		};
		clientThread = new Thread(serverTask);
		clientThread.start();
		
	}


	public Session getSession() {
		return session;
		
	}
}
