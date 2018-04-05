package server.controller;

import server.listener.InteractiveListener;
import server.model.ServerModelSingleton;
import server.services.ClockListenerService;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;
import server.view.ServerView;

public class ServerApplicationController {
	
	public ServerApplicationController() {
		ServerView serverView = new ServerView();
		ServerModelSingleton serverDataSingleton = ServerModelSingleton.getInstance();
		ServerSocketService serverSocketService = new ServerSocketService();
		ClockListenerService clockListenerService = new ClockListenerService();
		InteractiveListenerService interactiveListenerService = new InteractiveListenerService();
		
		ServerMainController serverMainController = new ServerMainController(serverView,
				serverDataSingleton,serverSocketService,clockListenerService,
				interactiveListenerService);
		
	}
	
	public static void main(String args[]) {
		new ServerApplicationController();
	}

}
