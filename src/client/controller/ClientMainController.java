package client.controller;

import client.helper.ClientDataSingleton;
import client.services.ClientServerConnectionService;
import client.view.ClientFrame;

/**
 * Controller class to handle web socket connection between the client and the server
 **/
public class ClientMainController {

    public static void main(String args[]) {
        ClientDataSingleton.getInstance();
        ClientFrame clientWindow = new ClientFrame();
        setClientServerConnection(clientWindow);
    }

    private static void setClientServerConnection(ClientFrame clientWindow) {
    	clientWindow.setServerClientListener(new ClientServerConnectionService());
    }
}
