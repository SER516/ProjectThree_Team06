package server.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class ViewMainWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMainWindow window = new ViewMainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panelTop = new JPanel();
		frame.getContentPane().add(panelTop);
		
		JLabel lblNewLabel = new JLabel("New label");
		panelTop.add(lblNewLabel);
		
		textField = new JTextField();
		panelTop.add(textField);
		textField.setColumns(10);
		
		JPanel panelControl = new JPanel();
		frame.getContentPane().add(panelControl);
		panelControl.setLayout(new BoxLayout(panelControl, BoxLayout.X_AXIS));
		
		JPanel panelConsole = new JPanel();
		frame.getContentPane().add(panelConsole);
	}
}
