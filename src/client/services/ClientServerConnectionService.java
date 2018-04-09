package client.services;

import javax.swing.JOptionPane;

import client.controller.WebSocketClientMain;
import client.helper.ClientDataSingleton;
import client.listener.ConnectionListener;
import client.model.ClientConfigurationSingleton;
import server.controller.ServerApplicationController;

public class ClientServerConnectionService implements ConnectionListener {
    WebSocketClientMain webSocketClientMain = new WebSocketClientMain();

    @Override
    public void startServer(String ip, String port) {
        establishServerClientConnection(ip, port);

    }


    @Override
    public void reconnectServer(String url) {
        String ip = ClientConfigurationSingleton.getInstance().getIp();
        String port = ClientConfigurationSingleton.getInstance().getPort();
        if (ip == null || port == null) {
            JOptionPane.showMessageDialog(null, "Please connect to the server first");
        } else {
            establishServerClientConnection(ip, port);
        }

    }

    @Override
    public void initializeServer() {
        new ServerApplicationController();

    }

    private void establishServerClientConnection(String ip, String port) {

        if (!ClientDataSingleton.getInstance().isSessionMaintained()) {
            ClientConfigurationSingleton.getInstance().setIp(ip);
            ClientConfigurationSingleton.getInstance().setPort(port);
            webSocketClientMain.connectToServer(ip, port);
        } else {
            JOptionPane.showMessageDialog(null, "Client is already connected");
        }

    }

}
