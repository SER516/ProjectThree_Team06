package client.controller;

import java.net.URI;
import javax.swing.JOptionPane;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import client.constants.ClientConstants;
import client.helper.ClientDataSingleton;

/**
 *
 */
public class WebSocketClientMain {
	private static Object waitLock = new Object();
	Thread clientThread;
	Session session = null;

	/**
	 *
	 */
	private static void wait4TerminateSignal() {
		synchronized (waitLock) {
			try {
				waitLock.wait();
			} catch (InterruptedException e) {
				waitLock.notifyAll();

			}
		}
	}

	/**
	 *
	 * @param ip
	 * @param port
	 */
	public void connectToServer(String ip, String port) {
		ClientSocketEndpoint.setMainClientWebSocket(this);
		String url = "ws://" + ip + ":" + port + "/server";
		Runnable serverTask = new Runnable() {

			@Override
			public void run() {
				WebSocketContainer container = null;
				try {
					container = ContainerProvider.getWebSocketContainer();
					session = container.connectToServer(ClientSocketEndpoint.class, URI.create(url));
					ClientDataSingleton.getInstance().setSessionMaintained(true);
					wait4TerminateSignal();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, ClientConstants.SERVER_NOT_RUNNING);
				} finally {
					if (session != null) {
						try {
							session.close();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, ClientConstants.CLOSING_SESSION_EXCEPTION_MESSAGE);
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
