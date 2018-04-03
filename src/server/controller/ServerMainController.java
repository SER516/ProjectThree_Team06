package server.controller;

import server.listener.LogListener;
import server.services.ServerSocketService;
import server.view.ServerUI;


import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class ServerMainController {
	
	private static ServerUI serverUI;
	
	public static void main(String args[]) {
		initializeUI();
		ServerSocketEndpoint.setLogListener(new LogListener() {
			@Override
			public void logMessage(String message) {
				System.out.println("Hello" + message);
				serverUI.logMessage(message);
			}
		});
		ServerSocketService serverSocketService = new ServerSocketService();
		serverSocketService.startServer();
	
	}


	private static void initializeUI() {
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            		serverUI = new ServerUI();
            		serverUI.setVisible(true);
            }
        });
		
	}
}
