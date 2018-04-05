package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 * This is a UI for Affective panel which plots the graph of
 * parameters in performance metrics.
 *
 * @author avinash
 */

public class AffectivePanel extends JPanel {
	public static final String TABNAME = "Affective";

	/*public static void main(String[] args) {
		new AffectivePanel();
	}*/
	
	public void BuildPalette(JPanel J) {
		JFrame colorframe = new JFrame();
		colorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorframe.setBounds(0, 0, 210, 145);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		colorframe.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//setPreferredSize(new Dimension(400,40));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		Color color1=new Color(255,0,0);
		panel_1.setBackground(color1);
		panel_1.setBounds(10, 10, 20, 20);
		panel.add(panel_1);
		//adding onclick mouse event. 
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color1);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_2 = new JPanel();
		Color color2=new Color(244, 164, 96);
		panel_2.setBackground(color2);
		panel_2.setBounds(40, 10, 20, 20);
		panel.add(panel_2);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color2);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_3 = new JPanel();
		Color color3=new Color(255, 69, 0);
		panel_3.setBackground(color3);
		panel_3.setBounds(70, 10, 20, 20);
		panel.add(panel_3);
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color3);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.YELLOW);
		panel_4.setBounds(100, 10, 20, 20);
		panel.add(panel_4);
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(Color.YELLOW);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.CYAN);
		panel_5.setBounds(130, 10, 20, 20);
		panel.add(panel_5);
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(Color.CYAN);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLUE);
		panel_6.setBounds(160, 10, 20, 20);
		panel.add(panel_6);
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(Color.BLUE);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_7 = new JPanel();
		Color color7=new Color(135, 206, 250);
		panel_7.setBackground(color7);
		panel_7.setBounds(10, 40, 20, 20);
		panel.add(panel_7);
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color7);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_8 = new JPanel();
		Color color8=new Color(0, 191, 255);
		panel_8.setBackground(color8);
		panel_8.setBounds(40, 40, 20, 20);
		panel.add(panel_8);
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color8);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_9 = new JPanel();
		Color color9=new Color(0, 0, 128);
		panel_9.setBackground(color9);
		panel_9.setBounds(70, 40, 20, 20);
		panel.add(panel_9);
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color9);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_10 = new JPanel();
		Color color10=new Color(204, 204, 255);
		panel_10.setBackground(color10);
		panel_10.setBounds(100, 40, 20, 20);
		panel.add(panel_10);
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color10);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_11 = new JPanel();
		Color color11=new Color(255, 20, 147);
		panel_11.setBackground(new Color(255, 20, 147));
		panel_11.setBounds(130, 40, 20, 20);
		panel.add(panel_11);
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color11);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_12 = new JPanel();
		Color color12=new Color(165, 42, 42);
		panel_12.setBackground(color12);
		panel_12.setBounds(160, 40, 20, 20);
		panel.add(panel_12);
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color12);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_13 = new JPanel();
		Color color13=new Color(154, 205, 50);
		panel_13.setBackground(color13);
		panel_13.setBounds(10, 70, 20, 20);
		panel.add(panel_13);
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color13);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_14 = new JPanel();
		Color color14=new Color(34, 139, 34);
		panel_14.setBackground(color14);
		panel_14.setBounds(40, 70, 20, 20);
		panel.add(panel_14);
		panel_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color14);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_15 = new JPanel();
		Color color15=new Color(210, 180, 140);
		panel_15.setBackground(color15);
		panel_15.setBounds(70, 70, 20, 20);
		panel.add(panel_15);
		panel_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color15);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_16 = new JPanel();
		Color color16= new Color(255, 255, 240);
		panel_16.setBackground(color16);
		panel_16.setBounds(100, 70, 20, 20);
		panel.add(panel_16);
		panel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color16);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_17 = new JPanel();
		Color color17=new Color(255, 228, 225);
		panel_17.setBackground(new Color(255, 228, 225));
		panel_17.setBounds(130, 70, 20, 20);
		panel.add(panel_17);
		panel_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color17);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		
		JPanel panel_18 = new JPanel();
		Color color18=new Color(169, 169, 169);
		panel_18.setBackground(color18);
		panel_18.setBounds(160, 70, 20, 20);
		panel.add(panel_18);
		panel_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				J.setBackground(color18);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		panel_18.setLayout(new BorderLayout(0, 0));
		
		
		JLabel lblX = new JLabel("  X");
		lblX.setBackground(new Color(0, 0, 0));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				J.setBackground(Color.GRAY);
				colorframe.setVisible(false);
				colorframe.dispose();
			}
		});
		panel_18.add(lblX, BorderLayout.CENTER);
		colorframe.setVisible(true);
	
	}

	public AffectivePanel() {
		/*
		 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); this.setSize(950, 890);
		 * this.setLayout(new BorderLayout());
		 */

		// JPanel container = new JPanel();
		JPanel panelOne = new JPanel();
		JPanel panelTwo = new JPanel();

		// set up jpanel 1
		panelOne.setLayout(new BorderLayout());
		panelOne.setBackground(new Color(253, 235, 208));
		panelOne.add(new JLabel("Graph Plot", JLabel.CENTER), BorderLayout.NORTH);

		// set up jpanel2
		panelTwo.setLayout(new BorderLayout());
		panelTwo.setBackground(new Color(169, 204, 227));
		panelTwo.add(new JLabel("Performance Metrics", JLabel.CENTER), BorderLayout.NORTH);

		JPanel panelTwo_center = new JPanel(new GridLayout(0, 1));
		// panelTwo_center.setBackground(new Color(169, 204, 227));

		// add Focus.
		JPanel panel1= new JPanel();
		JLabel metric1 = new JLabel("Focus");
		JButton button1 = new JButton("choose color");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuildPalette(panel1);
				
			}
		});
		panel1.add(metric1);
		panel1.add(button1);
		panelTwo_center.add(panel1);
		
		
		// add Stress
		JPanel panel2 = new JPanel();
		JLabel metric2 = new JLabel("Stress");
		JButton button2 = new JButton("choose color");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuildPalette(panel2);
				
			}
		});
		panel2.add(metric2);
		panel2.add(button2);
		panelTwo_center.add(panel2);
		
		
		// add interest
		JPanel panel3 = new JPanel();
		JLabel metric3 = new JLabel("Interest");
		JButton button3 = new JButton("choose color");
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuildPalette(panel3);
				
			}
		});
		panel3.add(metric3);
		panel3.add(button3);
		panelTwo_center.add(panel3);

		// add Engagement
		JPanel panel4 = new JPanel();
		// panel_excitementshort.setBackground(new Color(189, 195, 199));
		JLabel metric4 = new JLabel("Engagement");
		JButton button4 = new JButton("choose color");
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuildPalette(panel4);
				
			}
		});
		panel4.add(metric4);
		panel4.add(button4);
		panelTwo_center.add(panel4);

		// add Relaxation 
		JPanel panel5 = new JPanel();
		// panel_excitementlong.setBackground(new Color(189, 195, 199));
		JLabel metric5 = new JLabel("Relaxation");
		JButton button5 = new JButton("choose color");
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuildPalette(panel5);
				
			}
		});
		panel5.add(metric5);
		panel5.add(button5);
		panelTwo_center.add(panel5);
		
		
		// add Excitement 
		JPanel panel6 = new JPanel();
		// panel_excitementlong.setBackground(new Color(189, 195, 199));
		JLabel metric6 = new JLabel("Excitement");
		JButton button6 = new JButton("choose color");
		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuildPalette(panel6);
				
			}
		});
		panel6.add(metric6);
		panel6.add(button6);
		panelTwo_center.add(panel6);
		
		// add the display length of x axis. 
		JPanel panel7 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panel7.add(new JLabel("Display Length"), c);
		c.gridx = 1;
		c.gridy = 0;
		panel7.add(new JTextField(10), c);
		panelTwo_center.add(panel7);
		
		panelTwo_center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelTwo_center.setBorder(BorderFactory.createEtchedBorder());
		panelTwo.add(panelTwo_center, BorderLayout.CENTER);
		/*
		 * container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		 * container.add(panelOne); container.add(panelTwo);
		 */

		setLayout(new BorderLayout());
		add(panelOne, BorderLayout.CENTER);
		add(panelTwo, BorderLayout.EAST);

		/*
		 * this.add(container); this.setVisible(true);
		 */
	}

}