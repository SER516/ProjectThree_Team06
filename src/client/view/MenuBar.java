package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import client.constants.ClientConstants;
import client.services.ClientServerConnectionService;

/**
 * MenuBar handles the menu options given on main frame.
 *
 * @author Abhishek
 */
public class MenuBar extends JMenuBar implements ActionListener {

	private JMenuItem launchServer;
	private JMenuItem connect;
	private JMenuItem reconnect;
	private JMenuItem stopWatch;
	private JMenuItem connectionLabel;
	private ClientServerConnectionService clientServerConnectionService;
	private BufferedImage greenIcon, redIcon;

	public MenuBar() {
		JMenu menu = new JMenu("Menu");
		Font metricFont = new Font("Papyrus", Font.BOLD, 13);
		Border blackBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY);
		BufferedImage stopImage, redImage, greenImage;
		BufferedImage resizeStopImg = null;
		greenIcon = null;
		redIcon = null;
		try {
			redImage = ImageIO.read(getClass().getClassLoader().getResource("client/Images/redDot.png"));
			greenImage = ImageIO.read(getClass().getClassLoader().getResource("client/Images/greenDot.png"));
			stopImage = ImageIO.read(getClass().getClassLoader().getResource("client/Images/StopWatch.png"));
			resizeStopImg = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			redIcon = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			greenIcon = new BufferedImage(30, 25, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g3 = setGraphics(resizeStopImg, stopImage);
			Graphics2D g4 = setGraphics(redIcon, redImage);
			Graphics2D g5 = setGraphics(greenIcon, greenImage);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.IMAGE_PATH_EXCEPTION_MESSAGE);
		}
		menu.setHorizontalTextPosition(SwingConstants.CENTER);
		menu.setVerticalTextPosition(SwingConstants.BOTTOM);
		menu.setFont(metricFont);
		launchServer = new JMenuItem("Launch Server");
		setForegroundBackground(launchServer, blackBorder, metricFont);
		JMenu connectMenu = new JMenu("Connect");
		setForegroundBackground(connectMenu, blackBorder, metricFont);
		connect = new JMenuItem("Connect");
		reconnect = new JMenuItem("Reconnect");
		setForegroundBackground(connect, blackBorder, metricFont);
		setForegroundBackground(reconnect, blackBorder, metricFont);
		connectMenu.add(connect);
		connectMenu.add(new JPopupMenu.Separator());
		connectMenu.add(reconnect);
		stopWatch = new JMenuItem(ClientConstants.STOP_WATCH, new ImageIcon(resizeStopImg));
		connectionLabel = new JMenuItem();
		connect_state(false);
		launchServer.addActionListener(this);
		connect.addActionListener(this);
		reconnect.addActionListener(this);
		menu.add(launchServer);
		menu.add(new JPopupMenu.Separator());
		menu.add(connectMenu);
		setForegroundBackground(menu, blackBorder, metricFont);
		add(menu);
		setForegroundBackground(stopWatch, metricFont);
		add(stopWatch);
		setForegroundBackground(connectionLabel, metricFont);
		add(connectionLabel);
	}

	/**
	 * connect_state method changes the label and icon on menubar.
	 *
	 * @param flag
	 */
	public void connect_state(boolean flag) {
		if (flag) {
			connectionLabel.setIcon(new ImageIcon(greenIcon));
			connectionLabel.setText("Connected");
		} else {
			connectionLabel.setIcon(new ImageIcon(redIcon));
			connectionLabel.setText("Not Connected");
		}
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 *
	 * @param item
	 * @param blackBorder
	 * @param font
	 */
	public void setForegroundBackground(JMenu item, Border blackBorder, Font font) {
		item.setBackground(Color.DARK_GRAY);
		item.setForeground(Color.WHITE);
		item.setFont(font);
		item.setBorder(blackBorder);
		item.setOpaque(true);
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 *
	 * @param item
	 * @param blackBorder
	 * @param font
	 */
	public void setForegroundBackground(JMenuItem item, Border blackBorder, Font font) {
		item.setBackground(Color.DARK_GRAY);
		item.setForeground(Color.WHITE);
		item.setBorder(blackBorder);
		item.setFont(font);
		item.setOpaque(true);
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 *
	 * @param item
	 * @param font
	 */
	public void setForegroundBackground(JMenuItem item, Font font) {
		item.setBackground(Color.DARK_GRAY);
		item.setForeground(Color.WHITE);
		item.setFont(font);
		item.setOpaque(true);
	}

	/**
	 * setGraphics method creates a rendered image
	 * 
	 * @param resizeImg
	 * @param menuImage
	 * @return
	 */
	public Graphics2D setGraphics(BufferedImage resizeImg, BufferedImage menuImage) {
		Graphics2D g2 = resizeImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(menuImage, 0, 0, 30, 24, null);
		g2.dispose();
		return g2;
	}

	/**
	 * actionPerformed method handles the on click event from menu.
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == launchServer) {
			clientServerConnectionService.initializeServer();
		} else if (e.getSource() == connect) {
			if (clientServerConnectionService != null) {
				connect_state(true);
				launchDialogBox();
			}
		} else if (e.getSource() == reconnect) {
			connect_state(true);
			clientServerConnectionService.reconnectServer(null);
		}
	}

	/**
	 * setServerClientListener method connects client server connection lister
	 * 
	 * @param clientServerConnectionService
	 */
	public void setServerClientListener(ClientServerConnectionService clientServerConnectionService) {
		this.clientServerConnectionService = clientServerConnectionService;
	}

	/**
	 * launchDialogBox method provides a dialogue box for IP and port user inputs
	 */
	private void launchDialogBox() {
		JTextField ipField = new JTextField(15);
		JTextField ipPort = new JTextField(15);
		ipField.setText("localhost");
		ipPort.setText("8080");
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("IP:"));
		myPanel.add(ipField);
		myPanel.add(Box.createHorizontalStrut(15));
		myPanel.add(new JLabel("Port:"));
		myPanel.add(ipPort);
		int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter IP" + "and Port",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			clientServerConnectionService.startServer(ipField.getText(), ipPort.getText());
		}
	}

	/**
	 * updateTimeValue method updates stop watch timer on menubar.
	 * 
	 * @param time
	 */
	public void updateTimeValue(double time) {
		stopWatch.setText(String.valueOf(time));
	}
}
