package server.model;

public class ServerDataSingleton {
	private static volatile ServerDataSingleton serverDataSingleton;
	private static Object mutex = new Object();
	private static FaceData faceData = new FaceData();
	
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
