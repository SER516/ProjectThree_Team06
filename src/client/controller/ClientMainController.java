package client.controller;

import javax.swing.JOptionPane;
import javax.websocket.Session;

import client.helper.ClientDataSingleton;
import client.listener.ConnectionListener;
import client.services.ClientServerConnectionService;
import client.view.ClientFrame;
import server.controller.ServerApplicationController;
import server.controller.ServerMainController;

/**
 * Controller class to handle web socket connection between the client and the server
 **/
public class ClientMainController {

    public static void main(String args[]) {
        ClientDataSingleton.getInstance();
        ClientFrame clientFrame = new ClientFrame();
        setClientServerConnection(clientFrame);
    }

    private static void setClientServerConnection(ClientFrame clientFrame) {
    	clientFrame.setServerClientListener(new ClientServerConnectionService());
    }
}
