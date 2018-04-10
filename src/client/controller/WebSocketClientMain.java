package client.controller;

import client.helper.ClientDataSingleton;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

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
        final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
        String url = "ws://" + ip + ":" + port + "/server";
        Runnable serverTask = new Runnable() {

            @Override
            public void run() {
                WebSocketContainer container = null;
                try {
                    container = ContainerProvider.getWebSocketContainer();
                    session = container.connectToServer(ClientSocketEndpoint.class,
                            URI.create(url));
                    ClientDataSingleton.getInstance().setSessionMaintained(true);
                    wait4TerminateSignal();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Server is not running");
                } finally {
                    if (session != null) {
                        try {
                            session.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Exception on session close");
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
