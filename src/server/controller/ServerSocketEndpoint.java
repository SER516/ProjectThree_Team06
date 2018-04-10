package server.controller;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JOptionPane;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import com.google.gson.Gson;
import server.listener.LogListenerInterface;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;

/**
 *Server Socket Connection class that establishes connection threads for clock setting with client.
 */
@ServerEndpoint("/server")
public class ServerSocketEndpoint {

    public static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
    private static Gson gson = new Gson();
    private static Thread rateThread; // Child thread for sending random number
    private static LogListenerInterface logListener;
    private static DetectionListenerService detectionListenerService;

    static {
        rateThread = new Thread() {
            public void run() {
                while (true) {
                    if (queue != null) {
                        if (ServerModelSingleton.getInstance().isAutoReset()) {
                            sendAndUpdateCounter();
                        }
                        if (ServerModelSingleton.getInstance().isOneTimeSend()) {
                            sendAndUpdateCounter();
                            ServerModelSingleton.getInstance().setOneTimeSend(false);
                        }
                        try {
                            Double clock = ServerModelSingleton.getInstance().getStateInterval();
                            Long sleepValue = (long) (clock * 1000);
                            sleep(sleepValue);
                        } catch (InterruptedException e) {
                            System.out.print("Inside exception");
                        }
                    }
                }
            }

            private void sendAndUpdateCounter() {
                double interval = ServerModelSingleton.getInstance().getStateInterval();
                double counter = ServerModelSingleton.getInstance().getFaceData().getCounter();
                double newCounter = counter + interval;
                ServerModelSingleton.getInstance().getFaceData().setCounter(newCounter);
                String data = gson.toJson(ServerModelSingleton.getInstance().getFaceData());
                logListener.logMessage(data);
                detectionListenerService.changeCounter(newCounter);
                sendAll(data);
                if (ServerModelSingleton.getInstance().getFaceData().getExpressiveData().isAutoReset()) {
                    ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setAutoReset(false);
                    ServerModelSingleton.getInstance().getFaceData().getExpressiveData().resetValues();
                    detectionListenerService.disableActive();
                }
            }

            ;
        };
        rateThread.start();
    }

    private static void sendAll(String msg) {
        try {
            /* Sends data to all open WebSocket sessions */
            ArrayList<Session> closedSessions = new ArrayList<>();
            for (Session session : queue) {
                if (!session.isOpen()) {
                    System.err.println("Closed session: " + session.getId());
                    closedSessions.add(session);
                } else {
                    session.getBasicRemote().sendText(msg);
                }
            }
            queue.removeAll(closedSessions);
            logListener.logMessage("Sending " + msg + " to " + queue.size() + " clients");
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "An Exception has occurred while sending messages");
        }
    }

    public static void setLogListener(LogListenerInterface logListenerObject) {
        logListener = logListenerObject;
    }

    public static void setDetectionListenerService(DetectionListenerService detectionListenerServiceObject) {
        detectionListenerService = detectionListenerServiceObject;
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        // provided for completeness, in out scenario clients don't send any msg.
        try {
            logListener.logMessage("received msg " + msg + " from " + session.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An Exception has occurred while receiving messages");
        }
    }

    @OnOpen
    public void open(Session session) {
        queue.add(session);
        logListener.logMessage("New session opened: " + session.getId());

    }

    @OnError
    public void error(Session session, Throwable t) {
        queue.remove(session);
        logListener.logMessage("Error on session " + session.getId());
    }

    @OnClose
    public void closedConnection(Session session) {
        queue.remove(session);
        logListener.logMessage("session closed: " + session.getId());
    }
}