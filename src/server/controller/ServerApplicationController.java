package server.controller;

import server.model.ServerModelSingleton;
import server.services.ServerSocketService;
import server.view.ServerView;

public class ServerApplicationController {
	
	public ServerApplicationController() {
		ServerView serverView = new ServerView();
		ServerModelSingleton serverDataSingleton = ServerModelSingleton.getInstance();
		ServerSocketService serverSocketService = new ServerSocketService();
		ServerMainController serverMainController = new ServerMainController(serverView,
				serverDataSingleton,serverSocketService);
		
	}
	
	public static void main(String args[]) {
		new ServerApplicationController();
	}

}
