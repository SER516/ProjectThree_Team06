package client.view;

import javax.swing.*;
import java.awt.*;

/**
 * ClientFrame Class creates a JFrame object
 *
 * @author Abhishek
 */
public class ClientFrame extends JFrame {

    /**
     *
     */
    public ClientFrame(){
        setTitle("Client (Lab 3, Team 6)");
        //add(createMainPanel());
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        centerGUI(this);
        setJMenuBar(new MenuBar());
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

    public static void main(String[] args) {
        JFrame client = new ClientFrame();
    }

}
