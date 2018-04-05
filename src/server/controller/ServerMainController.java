package server.controller;

import server.listener.ClockListenerInterface;
import server.listener.LogListenerInterface;
import server.model.ServerModelSingleton;
import server.services.ClockListenerService;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;
import server.view.ServerView;


import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class ServerMainController {
	
	public ServerMainController(ServerView serverView, ServerModelSingleton 
			serverDataSingleton, ServerSocketService serverSocketService,
			ClockListenerService clockListenerService, InteractiveListenerService interactiveListenerService) {
		
		addViewToController(serverView);
		setListeners(serverView,clockListenerService,interactiveListenerService);
		serverSocketService.startServer();
	}


	private void setListeners(ServerView serverView, 
			ClockListenerService clockListenerService, 
			InteractiveListenerService interactiveListenerService) {
		
		setLogListener(serverView);
		setClockListener(serverView, clockListenerService);
		setInteractiveListener(serverView,interactiveListenerService);
		
	}



	private void setInteractiveListener(ServerView serverView,
			InteractiveListenerService interactiveListenerService) {
		serverView.setInteractiveListener(interactiveListenerService);
	}




	private void setClockListener(ServerView serverView, 
			ClockListenerService clockListenerService) {
		
		clockListenerService.attachViewToListener(serverView);
		ServerSocketEndpoint.setClockListener(clockListenerService);
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
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
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
