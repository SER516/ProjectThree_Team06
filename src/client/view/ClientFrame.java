package client.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * ClientFrame Class creates a JFrame object
 *
 * @author Abhishek
 */
public class ClientFrame extends JFrame {

    JPanel emotivePanel;
    JPanel affectivePanel;

    public ClientFrame(){
        setTitle("Client (Lab 3, Team 6)");
        //add(createMainPanel());
        JTabbedPane tabbedPane = new JTabbedPane();
        emotivePanel = new EmotivePanel();
        affectivePanel = new AffectivePanel();
        tabbedPane.addTab(EmotivePanel.TABNAME, emotivePanel);
        tabbedPane.addTab(AffectivePanel.TABNAME, affectivePanel);
        tabbedPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        centerGUI(this);
        setJMenuBar(new MenuBar());
        setVisible(true);
        add(tabbedPane, BorderLayout.CENTER);
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
