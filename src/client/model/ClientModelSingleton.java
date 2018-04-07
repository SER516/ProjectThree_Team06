package client.model;

import client.view.AffectivePlot;
import client.view.ExpressionPlots;

public class ClientModelSingleton {
	private static volatile ClientModelSingleton clientModelSingleton;
	private static Object mutex = new Object();
	boolean sessionMaintained = false;
	private FaceData faceData;
	private AffectivePlot affectivePlot;
	private ExpressionPlots expressplot;

	public AffectivePlot getAffectivePlot() {
		return affectivePlot;
	}

	public void setAffectivePlot(AffectivePlot affectivePlot) {
		this.affectivePlot = affectivePlot;
	}

	public ExpressionPlots getExpressplot() {
		return expressplot;
	}

	public void setExpressplot(ExpressionPlots expressplot) {
		this.expressplot = expressplot;
	}

	public boolean isSessionMaintained() {
		return sessionMaintained;
	}

	public void setSessionMaintained(boolean sessionMaintained) {
		this.sessionMaintained = sessionMaintained;
	}

	public static ClientModelSingleton getInstance() {
		ClientModelSingleton result = clientModelSingleton;
		if (result == null) {
			synchronized (mutex) {
				result = clientModelSingleton;
				if (result == null)
					result = new ClientModelSingleton();
				clientModelSingleton = result;
			}
		}
		return result;
	}

	public FaceData getFaceData() {
		return faceData;
	}

	public void setFaceData(FaceData faceData) {
		this.faceData = faceData;
	}
}
