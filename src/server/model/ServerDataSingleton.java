package server.model;

import server.helper.ServerConstants;

public class ServerDataSingleton {
	private static volatile ServerDataSingleton serverDataSingleton;
	private static Object mutex = new Object();
	private static FaceData faceData = new FaceData();
	private static boolean autoReset = ServerConstants.AUTO_RESET;
	private static long stateInterval= ServerConstants.STATE_INTERVAL;
	
	public static long getStateInterval() {
		return stateInterval;
	}

	public static void setStateInterval(long stateInterval) {
		ServerDataSingleton.stateInterval = stateInterval;
	}

	public static boolean isAutoReset() {
		return autoReset;
	}

	public static void setAutoReset(boolean autoReset) {
		ServerDataSingleton.autoReset = autoReset;
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

	public static FaceData getFaceData() {
		return faceData;
	}

	public static void setFaceData(FaceData faceData) {
		ServerDataSingleton.faceData = faceData;
	}


}
