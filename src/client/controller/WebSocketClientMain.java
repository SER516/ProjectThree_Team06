package client.controller;

import client.controller.ClientSocketEndpoint;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class WebSocketClientMain {
	private static Object waitLock = new Object();

	public static void main(String[] args) {
		
		WebSocketContainer container = null;
		Session session = null;
		try {
			container = ContainerProvider.getWebSocketContainer();
			session = container.connectToServer(ClientSocketEndpoint.class,
					URI.create("ws://localhost:8080/server"));
			wait4TerminateSignal();
		} catch (Exception e) {
			System.out.println("Add to console log");
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
	
	private static void wait4TerminateSignal() {
		synchronized (waitLock) {
			try {
				waitLock.wait();
			} catch (InterruptedException e) {
			}
		}
	}
}
