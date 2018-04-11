package server.controller;

import server.model.FaceData;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;
import server.view.ServerView;

/**
 * The ServerApplicationController class sets singleton face data, connection
 * and listener services for the server.
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerApplicationController {

	/**
	 * Inject dependency of view model and services
	 */
	public ServerApplicationController() {
		ServerView serverView = new ServerView();
		ServerModelSingleton serverDataSingleton = ServerModelSingleton.getInstance();
		serverDataSingleton.setFaceData(new FaceData());
		ServerSocketService serverSocketService = new ServerSocketService();
		InteractiveListenerService interactiveListenerService = new InteractiveListenerService();
		DetectionListenerService detectionListenerService = new DetectionListenerService();
		new ServerMainController(serverView, serverDataSingleton, serverSocketService, interactiveListenerService,
				detectionListenerService);
	}
}