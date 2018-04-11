package client.controller;

import client.model.ClientDataSingleton;
import client.listener.MenuBarListener;
import client.services.AffectiveColorService;
import client.services.ClientServerConnectionService;
import client.view.ClientFrame;

/**
 * The ClientMainController class handles web socket connection between the
 * client and the server.
 * 
 * @author Team06
 * @version 1.0
 */
public class ClientMainController {

	/**
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		ClientDataSingleton.getInstance();
		ClientFrame clientWindow = new ClientFrame();
		setClientServerConnection(clientWindow);
		setClockListener(clientWindow);
		setAffectiveListener(clientWindow);
	}

	/**
	 * @param clientWindow
	 */
	private static void setAffectiveListener(ClientFrame clientWindow) {
		clientWindow.setAffectiveListener(new AffectiveColorService(clientWindow));

	}

	/**
	 * @ param clientWindow
	 */
	private static void setClockListener(ClientFrame clientWindow) {
		ClientSocketEndpoint.setClockListener(new MenuBarListener() {
			@Override
			public void updateTime(double time) {
				clientWindow.updateTime(time);
			}

			@Override
			public void setConnectionLabel(boolean flag) {
				clientWindow.setConnectionLabel(flag);
			}

		});
	}

	/**
	 * @ param clientWindow
	 */
	private static void setClientServerConnection(ClientFrame clientWindow) {
		clientWindow.setServerClientListener(new ClientServerConnectionService());
	}
}