package client.controller;

import client.helper.ClientDataSingleton;
import client.listener.ClockListener;
import client.services.ClientServerConnectionService;
import client.view.ClientFrame;

/**
 * Controller class to handle web socket connection between the client and the server
 **/
public class ClientMainController {

    public static void main(String args[]) {
        ClientDataSingleton.getInstance();
        ClientFrame clientFrame = new ClientFrame();
        setClockListener();
        setClientServerConnection(clientFrame);
    }

    private static void setClockListener() {
        ClientSocketEndpoint.setClockListener(new ClockListener() {
            @Override
            public void updateTime(double time) {

            }
        });
    }

    private static void setClientServerConnection(ClientFrame clientFrame) {
    	clientFrame.setServerClientListener(new ClientServerConnectionService());
    }
}
