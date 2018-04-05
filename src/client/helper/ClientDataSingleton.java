package client.helper;

import server.model.ServerModelSingleton;

public class ClientDataSingleton {
	private static volatile ClientDataSingleton clientDataSingleton;
	private static Object mutex = new Object();
	boolean sessionMaintained = false;
	
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
	
}
