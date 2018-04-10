package client.view;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import client.constants.ClientConstants;
import client.services.AffectiveColorService;
import client.services.ClientServerConnectionService;

import java.awt.*;
import java.util.ArrayList;

/**
 * ClientFrame creates client main window.
 *
 * @author Abhishek
 */
public class ClientFrame extends JFrame {

	EmotivePanel emotivePanel;
	AffectivePanel affectivePanel;
	MenuBar menuBar;

	public ClientFrame() {
		setTitle(ClientConstants.TITLE);
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

	/**
	 * centerGUI method setup the client window dimensions
	 * 
	 * @param frame
	 */
	private void centerGUI(JFrame frame) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (d.width - w) / 2;
		int y = (d.height - h) / 2;
		frame.setLocation(x, y);
	}

	/**
	 * setServerClientListener method sets client server connection listeners
	 * 
	 * @param clientServerConnectionService
	 */
	public void setServerClientListener(ClientServerConnectionService clientServerConnectionService) {
		menuBar.setServerClientListener(clientServerConnectionService);
	}

	/**
	 * updateTime method updates stop watch timer on menubar
	 * 
	 * @param time
	 */
	public void updateTime(double time) {
		menuBar.updateTimeValue(time);
	}

	/**
	 * setAffectiveListener method sets color change service for affective panel
	 * 
	 * @param affectiveColorService
	 */
	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		affectivePanel.setAffectiveListener(affectiveColorService);
	}

	/**
	 * getColors method extracts colors on affective tab
	 * 
	 * @return
	 */
	public ArrayList<Color> getColors() {
		return affectivePanel.getColors();
	}

	/**
	 * changedisplayLengthLabel method updates length of affective panel
	 * 
	 * @param text
	 */
	public void changedisplayLengthLabel(String text) {
		affectivePanel.changedisplayLengthLabel(text);
	}
}