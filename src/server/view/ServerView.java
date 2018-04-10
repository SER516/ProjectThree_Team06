/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import server.listener.ServerListenerInterface;
import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;

/**
 * @author mspranav
 */
public class ServerView extends JFrame {
    ConsolePanel consolePanel;
    DetectionPanel detectionPanel;
    InteractivePanel interactivePanel;
    ServerListenerInterface serverListenerInterface;

    /**
     * Creates new form ServerUI.
     */
    public ServerView() {
        this.setTitle("Emotiv Xavier Composer");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setResizable(true);
        this.setBounds(100, 100, 500, 600);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                serverListenerInterface.stopServer();
            }
        });
        interactivePanel = new InteractivePanel();
        this.getContentPane().add(interactivePanel);

        detectionPanel = new DetectionPanel();
        this.getContentPane().add(detectionPanel);

        consolePanel = new ConsolePanel();
        this.getContentPane().add(consolePanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void logMessage(String message) {
        consolePanel.appendLogMessage(message);
    }

    public void changeClockCounter(double counter) {
        detectionPanel.changeClockCounter(counter);
    }

    public void setInteractiveListener(InteractiveListenerService interactiveListenerService) {
        interactivePanel.setInteractiveListener(interactiveListenerService);
    }

    public void setDetectionListenerService(DetectionListenerService detectionListenerService) {
        detectionPanel.setDetectionListenerService(detectionListenerService);
    }

    public void setServerListener(ServerListenerInterface serverListenerInterface) {
        this.serverListenerInterface = serverListenerInterface;
    }

    public void disableActive() {
        detectionPanel.disableActive();
    }
}
