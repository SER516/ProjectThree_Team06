package client.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IpPort extends JPanel{
	
	

	JTextField ip;
	JTextField port;

	public IpPort() {
		JPanel panel = new JPanel(new GridBagLayout());
		JTextField ip = new JTextField(20);
		ip.setText("localhost");
		JTextField port  = new JTextField(20);
		port.setText("8080");
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		panel.add(new JLabel("IP: "), c);
		c.gridx = 1;
		c.gridy = 0;
		
		panel.add(ip, c);
		c.gridx = 0;
		c.gridy = 1;
		
		panel.add(new JLabel("Port: "), c);
		c.gridx = 1;
		c.gridy = 1;
		
		panel.add(port, c);
		
		panel.setBorder(BorderFactory.createEtchedBorder());
		this.add(panel);
		
	}
	
	public JTextField getIp() {
		return ip;
	}

	public JTextField getPort() {
		return port;
	}
}
