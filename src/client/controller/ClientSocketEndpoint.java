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

import client.model.AffectivePlotData;
import client.model.ExpressivePlotData;
import client.model.FaceData;
import client.model.SingleTonData;
import com.google.gson.Gson;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;

import client.helper.ClientDataSingleton;

@ClientEndpoint
public class ClientSocketEndpoint {
	private static Object waitLock = new Object();
	private static Gson gson = new Gson();
	private FaceData faceData;
	

	@OnMessage
	public void onMessage(String message) {
		// Face data json.
		System.out.println("Received msg: " + message);
		faceData = gson.fromJson(message, FaceData.class);
		ClientDataSingleton.getInstance().setFaceData(faceData);
		ExpressivePlotData.getInstance().setDataToList(faceData.getExpressiveData());
		SingleTonData.getInstance().getExpressplot().plotExpressionGraph();
		AffectivePlotData.getInstance().setDataToList(faceData.getAffectiveData());
		SingleTonData.getInstance().getAffectivePlot().plotAffectiveGraph();
		SingleTonData.getInstance().getFaceExpression().PaintFace();
	}

	
	@OnClose
	public void closedConnection(Session session) {
		ClientDataSingleton.getInstance().setSessionMaintained(false);
		System.out.println("session closed: " + session.getId());
	}
	
}