package client.controller;

import javax.websocket.Session;

import client.helper.ClientDataSingleton;
import client.listener.ConnectionListener;
import client.view.ClientFrame;

public class ClientMainController {

	public static void main(String args[]) {
		ClientDataSingleton.getInstance();
		ClientFrame clientFrame = new ClientFrame();
		setClientServerConnection(clientFrame);
		
		
	}

	private static void setClientServerConnection(ClientFrame clientFrame) {
		clientFrame.setConnectionListener(new ConnectionListener() {
			
			
			@Override
			public void startServer() {
				WebSocketClientMain webSocketClientMain = new WebSocketClientMain();
				if(!ClientDataSingleton.getInstance().isSessionMaintained()) {
					webSocketClientMain.connectToServer();
				}	
			}

			@Override
			public void reconnectServer(String url) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
