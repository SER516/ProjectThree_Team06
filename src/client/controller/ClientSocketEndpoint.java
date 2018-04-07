package client.controller;

import client.model.ClientModelSingleton;
import client.model.ExpressivePlotData;
import client.model.FaceData;
import client.model.SingleTonData;
import com.google.gson.Gson;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;

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
		try {
			ClientModelSingleton.getInstance().setFaceData(faceData);
			ExpressivePlotData.getInstance().setDataToList(faceData.getExpressiveData());
			SingleTonData.getInstance().getExpressplot().plotExpressionGraph();
			SingleTonData.getInstance().getAffectivePlot().plotAffectiveGraph();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@OnClose
	public void closedConnection(Session session) {
		ClientModelSingleton.getInstance().setSessionMaintained(false);
		System.out.println("session closed: " + session.getId());
	}
}