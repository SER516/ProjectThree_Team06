package client.view;

import client.model.SingleTonData;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;


class AffectivePerformanceMetricPanel extends JPanel{
	
	public AffectivePerformanceMetricPanel() {
		BuildPanel();
	}
	
	public JPanel BuildPanel() {
		
		// set up jpanel2
		Font metric_font= new Font("Papyrus", Font.BOLD, 21);
		setLayout(new BorderLayout());
		setBackground(new Color(169, 204, 227));
		JLabel PerformanceMetric= new JLabel("Performance Metrics",JLabel.CENTER);
		PerformanceMetric.setFont(new Font("Papyrus", Font.BOLD, 15));
		add(PerformanceMetric, BorderLayout.NORTH);

		JPanel panelTwo_center = new JPanel(new GridLayout(4, 2));
		panelTwo_center.setBackground(new Color(220,220,220));
		// add Focus.
		JPanel panel1= new JPanel();
		panel1.setBackground(new Color(255,99,71));
		JButton button1 = new JButton("Focus");
		button1.setFont(new Font("Papyrus", Font.BOLD, 25));
		button1.setPreferredSize(new Dimension(110,50));
		button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
                panel1.setBackground(newColor);
               
            }
        });
		panel1.add(button1);
		panelTwo_center.add(panel1);
		
		
		// add Stress
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(128, 191, 255));
		JButton button2 = new JButton("Stress");
		button2.setFont(metric_font);
		button2.setPreferredSize(new Dimension(110,50));
		button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
                panel2.setBackground(newColor);
               
            }
        });
		panel2.add(button2);
		panelTwo_center.add(panel2);
		
		
		// add interest
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(204, 204, 255));
		JButton button3 = new JButton("Interest");
		button3.setFont(metric_font);
		button3.setPreferredSize(new Dimension(110,50));
		button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
                panel3 .setBackground(newColor);
               
            }
        });
		panel3.add(button3);
		panelTwo_center.add(panel3);

		// add Engagement
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(77, 255, 166));
		// panel_excitementshort.setBackground(new Color(189, 195, 199));
		JButton button4 = new JButton("Engagement");
		button4.setFont(metric_font);
		button4.setPreferredSize(new Dimension(135,50));
		button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
                panel4.setBackground(newColor);
               
            }
        });
		panel4.add(button4);
		panelTwo_center.add(panel4);

		// add Relaxation 
		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(184, 102, 20));
		JButton button5 = new JButton("Relaxation");
		button5.setFont(metric_font);
		button5.setPreferredSize(new Dimension(120,50));
		button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
                panel5.setBackground(newColor);
               
            }
        });
		panel5.add(button5);
		panelTwo_center.add(panel5);
		
		
		// add Excitement 
		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(255, 255, 102));
		// panel_excitementlong.setBackground(new Color(189, 195, 199));
		JButton button6 = new JButton("Excitement");
		button6.setFont(metric_font);
		button6.setPreferredSize(new Dimension(120,50));
		button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
                panel6.setBackground(newColor);
               
            }
        });
		panel6.add(button6);
		panelTwo_center.add(panel6);
		
		// add the display length of x axis. 
		JPanel panel7 = new JPanel(new GridBagLayout());
		panel7.setBackground(new Color(220,220,220));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		JLabel DisplayLength = new JLabel("Display Length  ");
		DisplayLength.setFont(new Font("Papyrus", Font.BOLD, 15));
		panel7.add(DisplayLength, c);
		c.gridx = 1;
		c.gridy = 0;
		panel7.add(new JTextField(10), c);
		panelTwo_center.add(panel7);
		
		panelTwo_center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelTwo_center.setBorder(BorderFactory.createEtchedBorder());
		add(panelTwo_center, BorderLayout.CENTER);
		
		return this;
		
	}
}