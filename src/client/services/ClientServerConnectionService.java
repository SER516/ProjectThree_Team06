package client.services;

import javax.swing.JOptionPane;

import client.constants.ClientConstants;
import client.controller.WebSocketClientMain;
import client.listener.ConnectionListener;
import client.model.ClientConfigurationSingleton;
import client.model.ClientDataSingleton;
import server.controller.ServerApplicationController;

/**
 *
 */
public class ClientServerConnectionService implements ConnectionListener {
	WebSocketClientMain webSocketClientMain = new WebSocketClientMain();

	@Override
	public void startServer(String ip, String port) {
		establishServerClientConnection(ip, port);
	}

	/**
	 *
	 * @param url
	 */
	@Override
	public void reconnectServer(String url) {
		String ip = ClientConfigurationSingleton.getInstance().getIp();
		String port = ClientConfigurationSingleton.getInstance().getPort();
		if (ip == null || port == null) {
			JOptionPane.showMessageDialog(null, ClientConstants.CONNECT_TO_SERVER);
		} else {
			establishServerClientConnection(ip, port);
		}

	}

	@Override
	public void initializeServer() {
		new ServerApplicationController();

	}

	/**
	 *
	 * @param ip
	 * @param port
	 */
	private void establishServerClientConnection(String ip, String port) {

		if (!ClientDataSingleton.getInstance().isSessionMaintained()) {
			ClientConfigurationSingleton.getInstance().setIp(ip);
			ClientConfigurationSingleton.getInstance().setPort(port);
			webSocketClientMain.connectToServer(ip, port);
		} else {
			JOptionPane.showMessageDialog(null, ClientConstants.CLIENT_ALREADY_CONNECTED);
		}

	}

}
