package client.controller;

import java.io.IOException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;

import javax.websocket.*;

import client.constants.ClientConstants;
import client.model.ClientDataSingleton;
import client.listener.MenuBarListener;
import client.model.AffectivePlotData;
import client.model.ExpressivePlotData;
import client.model.FaceData;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;

/**
 *
 */
@ClientEndpoint
public class ClientSocketEndpoint {
	static WebSocketClientMain webSocketClientMain;
	static MenuBarListener clockListener;
	private static Gson gson = new Gson();
	private FaceData faceData;

	public static void setMainClientWebSocket(WebSocketClientMain webSocketClientMainVal) {
		webSocketClientMain = webSocketClientMainVal;

	}

	public static void setClockListener(MenuBarListener clockListenerObj) {
		clockListener = clockListenerObj;
	}


	@OnOpen
	public void open(Session session) {
		clockListener.setConnectionLabel(true);
	}


	/**
	 *
	 * @param message
	 */
	@OnMessage
	public void onMessage(String message) {
		faceData = gson.fromJson(message, FaceData.class);
		faceData = gson.fromJson(message, FaceData.class);
		ClientDataSingleton.getInstance().setFaceData(faceData);
		ExpressivePlotData.getInstance().setDataToList(faceData.getExpressiveData());
		ClientDataSingleton.getInstance().getExpressplot().plotExpressionGraph();
		AffectivePlotData.getInstance().setDataToList(faceData.getAffectiveData(), faceData);
		ClientDataSingleton.getInstance().getAffectivePlot()
				.plotAffectiveGraph1(AffectivePlotData.getInstance().getDataset());
		ClientDataSingleton.getInstance().setFaceExpressionController(new ClientFaceController());
		String fileName = ClientDataSingleton.getInstance().getFaceExpressionController()
				.getFaceFileName(faceData.getExpressiveData());
		ClientDataSingleton.getInstance().getFaceExpressions().drawImage(fileName);
		clockListener.updateTime(faceData.getCounter());
	}

	/**
	 *
	 * @param session
	 */
	@OnClose
	public void closedConnection(Session session) {
		ClientDataSingleton.getInstance().setSessionMaintained(false);
		clockListener.setConnectionLabel(false);
		clockListener.setConnectionLabel(false);
		try {
			session.close();
			webSocketClientMain.clientThread.interrupt();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.CLOSING_CONNECTION_EXCEPTION_MESSAGE);
		}
	}
}