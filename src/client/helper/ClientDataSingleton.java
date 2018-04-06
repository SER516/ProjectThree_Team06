package client.helper;

import client.model.FaceData;

public class ClientDataSingleton {
	private static volatile ClientDataSingleton clientDataSingleton;
	private static Object mutex = new Object();
	boolean sessionMaintained = false;
	private FaceData faceData;

	public boolean isSessionMaintained() {
		return sessionMaintained;
	}

	public void setSessionMaintained(boolean sessionMaintained) {
		this.sessionMaintained = sessionMaintained;
	}

	public static ClientDataSingleton getInstance() {
		ClientDataSingleton result = clientDataSingleton;
		if (result == null) {
			synchronized (mutex) {
				result = clientDataSingleton;
				if (result == null)
					result = new ClientDataSingleton();
				clientDataSingleton = result;
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
