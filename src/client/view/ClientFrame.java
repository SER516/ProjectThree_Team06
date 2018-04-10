package client.view;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import client.listener.ConnectionListener;
import client.services.AffectiveColorService;
import client.services.ClientServerConnectionService;

import java.awt.*;
import java.util.ArrayList;

/**
 * ClientFrame Class creates a JFrame object
 *
 * @author Abhishek
 */
public class ClientFrame extends JFrame {

    EmotivePanel emotivePanel;
    AffectivePanel affectivePanel;
    MenuBar menuBar;

    public ClientFrame() {
        setTitle("Client (Lab 3, Team 6)");
        // add(createMainPanel());
        menuBar = new MenuBar();
        JTabbedPane tabbedPane = new JTabbedPane();
        emotivePanel = new EmotivePanel();
        affectivePanel = new AffectivePanel();
        tabbedPane.addTab(EmotivePanel.TABNAME, emotivePanel);
        tabbedPane.addTab(AffectivePanel.TABNAME, affectivePanel);
        tabbedPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        centerGUI(this);
        setJMenuBar(menuBar);
        add(tabbedPane, BorderLayout.CENTER);
        setResizable(true);
        setVisible(true);
    }

    private void centerGUI(JFrame frame) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (d.width - w) / 2;
        int y = (d.height - h) / 2;
        frame.setLocation(x, y);
    }


    public void setServerClientListener(ClientServerConnectionService clientServerConnectionService) {
        menuBar.setServerClientListener(clientServerConnectionService);


    }

    public void updateTime(double time) {
        menuBar.updateTimeValue(time);
    }

    public void setAffectiveListener(AffectiveColorService affectiveColorService) {

        affectivePanel.setAffectiveListener(affectiveColorService);
    }

    public ArrayList<Color> getColors() {
        return affectivePanel.getColors();

    }

    public void changeDisplayLength(String text) {
        affectivePanel.changeDisplayLength(text);
    }
}
