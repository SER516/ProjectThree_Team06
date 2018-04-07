package client.controller;

import client.model.ClientModelSingleton;
import client.view.ClientView;
import server.view.ServerView;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientMainController {
    public ClientMainController(ClientView clientView, ClientModelSingleton clientModelSingleton) {
        addViewToController(clientView);
        //setListeners();
    }

    private static void addViewToController(ClientView clientView) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
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
                clientView.setVisible(true);
            }
        });

    }
}
