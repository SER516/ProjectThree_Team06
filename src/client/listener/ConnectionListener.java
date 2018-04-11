package client.listener;

/**
 * The ConnectionListener interface.
 * 
 * @author Team06
 * @version 1.0
 */
public interface ConnectionListener {

	public void startServer(String ip, String port);

	public void reconnectServer(String url);

	public void initializeServer();

}
