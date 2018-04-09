package server.controller;

import server.listener.LogListenerInterface;
import server.listener.ServerListenerInterface;
import server.model.ServerModelSingleton;
import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;
import server.view.ServerView;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class ServerMainController {

	public ServerMainController(ServerView serverView, ServerModelSingleton serverDataSingleton,
			ServerSocketService serverSocketService, InteractiveListenerService interactiveListenerService,
			DetectionListenerService detectionListenerService) {

		addViewToController(serverView);
		setListeners(serverView, interactiveListenerService, detectionListenerService, serverSocketService);
		serverSocketService.startServer();
	}

	private void setListeners(ServerView serverView, InteractiveListenerService interactiveListenerService,
			DetectionListenerService detectionListenerService, ServerSocketService serverSocketService) {

		setDetectionListener(serverView, detectionListenerService);
		setLogListener(serverView);
		setInteractiveListener(serverView, interactiveListenerService);
		setServerStopListener(serverView,serverSocketService);

	}

	private void setServerStopListener(ServerView serverView, ServerSocketService serverSocketService) {
		serverView.setServerListener(new ServerListenerInterface() {
			@Override
			public void stopServer() {
				serverSocketService.stopServer();
			}
		});
		
	}

	private void setDetectionListener(ServerView serverView, DetectionListenerService detectionListenerService) {
		detectionListenerService.setServerView(serverView);
		ServerSocketEndpoint.setDetectionListenerService(detectionListenerService);
		serverView.setDetectionListenerService(detectionListenerService);

	}

	private void setInteractiveListener(ServerView serverView, InteractiveListenerService interactiveListenerService) {
		serverView.setInteractiveListener(interactiveListenerService);
	}

	private static void setLogListener(ServerView serverView) {
		ServerSocketEndpoint.setLogListener(new LogListenerInterface() {
			@Override
			public void logMessage(String message) {
				serverView.logMessage(message);
			}
		});

	}

	private static void addViewToController(ServerView serverView) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Aqua".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				serverView.setVisible(true);
			}
		});

	}
}
