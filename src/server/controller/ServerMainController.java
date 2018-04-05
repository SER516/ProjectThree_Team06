package server.controller;

import server.listener.ClockListener;
import server.listener.LogListener;
import server.model.ServerModelSingleton;
import server.services.ServerSocketService;
import server.view.ServerView;


import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class ServerMainController {
	
	public ServerMainController(ServerView serverView, ServerModelSingleton 
			serverDataSingleton, ServerSocketService serverSocketService) {
		
		addViewToController(serverView);
		setListeners(serverView);
		serverSocketService.startServer();
	}


	private static void setListeners(ServerView serverView) {
		setLogListener(serverView);
		setClockListener(serverView);
		
	}


	private static void setClockListener(ServerView serverView) {
		ServerSocketEndpoint.setClockListener(new ClockListener() {
			@Override
			public void changeCounter(double counter) {
				serverView.changeClockCounter(counter);	
			}	
		});
	}


	private static void setLogListener(ServerView serverView) {
		ServerSocketEndpoint.setLogListener(new LogListener() {
			@Override
			public void logMessage(String message) {
				System.out.println("Hello" + message);
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
