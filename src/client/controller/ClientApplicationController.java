package client.controller;

import client.listener.ConnectionListener;
import client.model.ClientModelSingleton;
import client.view.ClientView;
import server.controller.ServerApplicationController;

/**
 * Controller class to handle web socket connection between the client and the server
 **/
public class ClientApplicationController {

    public static void main(String args[]) {
        ClientView clientView = new ClientView();
        setClientServerConnection(clientView);
        new ClientApplicationController(clientView);
    }

    public ClientApplicationController(ClientView clientView ) {
        ClientModelSingleton clientModelSingleton = ClientModelSingleton.getInstance();
        // Add Client Services

        ClientMainController clientMainController = new ClientMainController(clientView, clientModelSingleton);
    }

    private static void setClientServerConnection(ClientView clientView) {
        clientView.setConnectionListener(new ConnectionListener() {
            @Override
            public void startServer() {
                WebSocketClientMain webSocketClientMain = new WebSocketClientMain();
                if (!ClientModelSingleton.getInstance().isSessionMaintained()) {
                    webSocketClientMain.connectToServer();
                }
            }

            @Override
            public void reconnectServer(String url) {
            }

            @Override
            public void initializeServer() {
                new ServerApplicationController();
            }
        });
    }
}
