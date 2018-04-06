package client.view;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import client.listener.ConnectionListener;

import java.awt.*;

/**
 * ClientFrame Class creates a JFrame object
 *
 * @author Abhishek
 */
public class ClientFrame extends JFrame {

	JPanel emotivePanel;
	JPanel affectivePanel;
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
		setVisible(true);
		setResizable(false);
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

	public void setConnectionListener(ConnectionListener connectionListener) {
		menuBar.setConnectionListener(connectionListener);
		
	}

}
