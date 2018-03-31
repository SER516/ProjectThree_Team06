package client.controller;

import client.view.ViewMain;
import server.controller.ServerSocketMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController extends JFrame{
    public ClientController() {

        setTitle("My Gui");
        setSize(400, 400);

        // Create JButton and JPanel
//        JLabel label = new JLabel("Start")
        JButton button = new JButton("Start");
        JLabel label = new JLabel("The Server connection status appears here");
        JPanel panel = new JPanel();

        // Add button to JPanel
        panel.add(button);
        panel.add(label);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ServerSocketMain servconn = new ServerSocketMain();

                WebSocketClientMain conn = new WebSocketClientMain();
                label.setText("Connection Set");
                button.setText("Stop");

            }
        });
    }

    public static void main(String[] args) {

        ClientController view = new ClientController();
    }
}
