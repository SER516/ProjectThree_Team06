package server.model;

import server.helper.ServerConstants;

public class ServerDataSingleton {
	private static volatile ServerDataSingleton serverDataSingleton;
	private static Object mutex = new Object();
	private static FaceData faceData = new FaceData();
	private  boolean autoReset = ServerConstants.AUTO_RESET;
	private long stateInterval= ServerConstants.STATE_INTERVAL;
	
	public  long getStateInterval() {
		return stateInterval;
	}

	public  void setStateInterval(long stateInterval) {
		this.stateInterval = stateInterval;
	}

	public boolean isAutoReset() {
		return autoReset;
	}

	public  void setAutoReset(boolean autoReset) {
		this.autoReset = autoReset;
	}

	public static ServerDataSingleton getInstance() {
		ServerDataSingleton result = serverDataSingleton;
		if (result == null) {
			synchronized (mutex) {
				result = serverDataSingleton;
				if (result == null)
					result = new ServerDataSingleton();
				serverDataSingleton = result;
			}
		}
		return result;
	}

	public  FaceData getFaceData() {
		return faceData;
	}

	public  void setFaceData(FaceData faceData) {
		this.faceData = faceData;
	}


}