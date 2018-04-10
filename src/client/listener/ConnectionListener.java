package client.listener;

/**
 *
 */
public interface ConnectionListener {

	public void startServer(String ip, String port);

	public void reconnectServer(String url);

	public void initializeServer();

}
