package client.controller;

import client.controller.ClientSocketEndpoint;
import client.helper.ClientDataSingleton;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class WebSocketClientMain {
	Thread clientThread;
	private static Object waitLock = new Object();
	Session session = null;
	
	private static void wait4TerminateSignal() {
		synchronized (waitLock) {
			try {
				System.out.println("Waiting");
				waitLock.wait();
			} catch (InterruptedException e) {
				waitLock.notifyAll();
				System.out.println("Interrupted asfsafsafsaf");
				
			}
		}
	}

	public void connectToServer(String ip, String port) {
		ClientSocketEndpoint.setMainClientWebSocket(this);
		final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
		String url = "ws://"+ip +":"+ port + "/server";
		Runnable serverTask = new Runnable() {
			
			@Override
			public void run() {
				WebSocketContainer container = null;
				try {
					container = ContainerProvider.getWebSocketContainer();
					session = container.connectToServer(ClientSocketEndpoint.class,
							URI.create(url));
					ClientDataSingleton.getInstance().setSessionMaintained(true);
					wait4TerminateSignal();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Server is not running");
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
