package client.controller;

import java.io.IOException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;

import javax.websocket.*;

import client.constants.ClientConstants;
import client.helper.ClientDataSingleton;
import client.listener.MenuBarListener;
import client.model.AffectivePlotData;
import client.model.ExpressivePlotData;
import client.model.FaceData;
import client.model.SingleTonData;
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
		ClientDataSingleton.getInstance().setFaceData(faceData);
		ExpressivePlotData.getInstance().setDataToList(faceData.getExpressiveData());
		SingleTonData.getInstance().getExpressplot().plotExpressionGraph();
		AffectivePlotData.getInstance().setDataToList(faceData.getAffectiveData(), faceData);
		SingleTonData.getInstance().getAffectivePlot()
				.plotAffectiveGraph1(AffectivePlotData.getInstance().getDataset());
		SingleTonData.getInstance().setFaceExpressionController(new ClientFaceController());
		String fileName = SingleTonData.getInstance().getFaceExpressionController()
				.getFaceFileName(faceData.getExpressiveData());
		SingleTonData.getInstance().getFaceExpressions().drawImage(fileName);
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
		try {
			session.close();
			webSocketClientMain.clientThread.interrupt();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.CLOSING_CONNECTION_EXCEPTION_MESSAGE);
		}
	}
}