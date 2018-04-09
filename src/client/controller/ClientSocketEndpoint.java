package client.controller;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import client.listener.ClockListener;
import client.model.AffectivePlotData;
import client.model.ExpressivePlotData;
import client.model.FaceData;
import client.model.SingleTonData;
import com.google.gson.Gson;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;

import client.helper.ClientDataSingleton;

@ClientEndpoint
public class ClientSocketEndpoint {
    static WebSocketClientMain webSocketClientMain;
    static ClockListener clockListener;
    private static Object waitLock = new Object();
    private static Gson gson = new Gson();
    private FaceData faceData;

    public static void setMainClientWebSocket(WebSocketClientMain webSocketClientMainVal) {
        webSocketClientMain = webSocketClientMainVal;

    }

    public static void setClockListener(ClockListener clockListenerObj) {
        clockListener = clockListenerObj;
    }

    @OnMessage
    public void onMessage(String message) {
        // Face data json.

        faceData = gson.fromJson(message, FaceData.class);
        ClientDataSingleton.getInstance().setFaceData(faceData);
        ExpressivePlotData.getInstance().setDataToList(faceData.getExpressiveData());
        SingleTonData.getInstance().getExpressplot().plotExpressionGraph();
        AffectivePlotData.getInstance().setDataToList(faceData.getAffectiveData(), faceData);

        SingleTonData.getInstance().getAffectivePlot().plotAffectiveGraph1(AffectivePlotData.getInstance().getDataset());
        SingleTonData.getInstance().setFaceExpressionController(new ClientFaceController());
        String fileName = SingleTonData.getInstance().getFaceExpressionController().
                getFaceFileName(faceData.getExpressiveData());
        SingleTonData.getInstance().getFaceExpressions().drawImage(fileName);
        clockListener.updateTime(faceData.getCounter());

    }

    @OnClose
    public void closedConnection(Session session) {
        ClientDataSingleton.getInstance().setSessionMaintained(false);
        try {
            session.close();
            webSocketClientMain.clientThread.interrupt();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}