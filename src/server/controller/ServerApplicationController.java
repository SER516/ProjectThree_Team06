package server.controller;

import server.listener.InteractiveListener;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;
import server.view.ServerView;

public class ServerApplicationController {
	
	public ServerApplicationController() {
		ServerView serverView = new ServerView();
		ServerModelSingleton serverDataSingleton = ServerModelSingleton.getInstance();
		ServerSocketService serverSocketService = new ServerSocketService();
		InteractiveListenerService interactiveListenerService = new InteractiveListenerService();
		DetectionListenerService detectionListenerService = new DetectionListenerService();
		
		ServerMainController serverMainController = new ServerMainController(serverView,
				serverDataSingleton,serverSocketService,
				interactiveListenerService, detectionListenerService);
		
	}
	
	public static void main(String args[]) {
		new ServerApplicationController();
	}

}
