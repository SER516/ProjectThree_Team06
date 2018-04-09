package client.view;

import client.model.SingleTonData;
import client.services.AffectiveColorService;

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
import java.util.ArrayList;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This is part of AffectivePanel UI. This panel has performance metrics.
 *
 * @author avinash
 */

class AffectivePerformanceMetricPanel extends JPanel implements ActionListener, ChangeListener {

	AffectiveColorService affectiveColorService;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JTextField displayLength;
	private ArrayList<Color> colors = new ArrayList<>();

	public AffectivePerformanceMetricPanel() {
		BuildPanel();
	}

	public JPanel BuildPanel() {

		// set up jpanel2
		Font metric_font = new Font("Papyrus", Font.BOLD, 21);
		setLayout(new BorderLayout());
		setBackground(new Color(169, 204, 227));
		JLabel PerformanceMetric = new JLabel("Performance Metrics", JLabel.CENTER);
		PerformanceMetric.setFont(new Font("Papyrus", Font.BOLD, 15));
		add(PerformanceMetric, BorderLayout.NORTH);

		JPanel panelTwo_center = new JPanel(new GridLayout(4, 2));
		panelTwo_center.setBackground(new Color(220, 220, 220));
		
		
		
		// add Focus.
		panel1 = new JPanel();
		Color color1 = new Color(255, 99, 71);
		colors.add(color1);
		panel1.setBackground(color1);
		
		button1 = new JButton("Focus");
		button1.setFont(new Font("Papyrus", Font.BOLD, 25));
		button1.setPreferredSize(new Dimension(110, 50));
		button1.addActionListener(this);
		panel1.add(button1);
		panelTwo_center.add(panel1);

		// add Stress
		panel2 = new JPanel();
		Color color2 = new Color(128, 191, 255);
		colors.add(color2);
		panel2.setBackground(color2);
		button2 = new JButton("Stress");
		button2.setFont(metric_font);
		button2.setPreferredSize(new Dimension(110, 50));
		button2.addActionListener(this);
		panel2.add(button2);
		panelTwo_center.add(panel2);

		// add interest
		panel3 = new JPanel();
		Color color3 = new Color(204, 204, 255);
		colors.add(color3);
		panel3.setBackground(color3);

		button3 = new JButton("Interest");
		button3.setFont(metric_font);
		button3.setPreferredSize(new Dimension(110, 50));
		button3.addActionListener(this);
		panel3.add(button3);
		panelTwo_center.add(panel3);

		// add Engagement
		panel4 = new JPanel();
		Color color4 = new Color(77, 255, 166);
		colors.add(color4);
		panel4.setBackground(color4);
		// panel_excitementshort.setBackground(new Color(189, 195, 199));
		button4 = new JButton("Engagement");
		button4.setFont(metric_font);
		button4.setPreferredSize(new Dimension(135, 50));
		button4.addActionListener(this);
		panel4.add(button4);
		panelTwo_center.add(panel4);

		// add Relaxation
		panel5 = new JPanel();
		Color color5 = new Color(184, 102, 20);
		colors.add(color5);
		panel5.setBackground(color5);
		button5 = new JButton("Relaxation");
		button5.setFont(metric_font);
		button5.setPreferredSize(new Dimension(120, 50));
		button5.addActionListener(this);
		panel5.add(button5);
		panelTwo_center.add(panel5);

		// add Excitement
		panel6 = new JPanel();
		Color color6 = new Color(255, 255, 102);
		colors.add(color6);
		panel6.setBackground(color6);
		// panel_excitementlong.setBackground(new Color(189, 195, 199));
		button6 = new JButton("Excitement");
		button6.setFont(metric_font);
		button6.setPreferredSize(new Dimension(120, 50));
		button6.addActionListener(this);
		panel6.add(button6);
		panelTwo_center.add(panel6);

		// add the display length of x axis.
		JPanel panel7 = new JPanel(new GridBagLayout());
		panel7.setBackground(new Color(220, 220, 220));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		JLabel DisplayLength = new JLabel("Display Length  ");
		DisplayLength.setFont(new Font("Papyrus", Font.BOLD, 15));
		panel7.add(DisplayLength, c);
		c.gridx = 1;
		c.gridy = 0;

		displayLength = new JTextField(10);
		displayLength.setText(String.valueOf(500));

		panel7.add(displayLength, c);
		panelTwo_center.add(panel7);

		panelTwo_center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelTwo_center.setBorder(BorderFactory.createEtchedBorder());
		add(panelTwo_center, BorderLayout.CENTER);

		return this;

	}

	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		this.affectiveColorService = affectiveColorService;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button1) {
			setColor(panel1,0);

		} else if (e.getSource() == button2) {
			setColor(panel2,1);
		}

		else if (e.getSource() == button3) {
			setColor(panel3,2);
		}

		else if (e.getSource() == button4) {
			setColor(panel4,3);
		}

		else if (e.getSource() == button5) {
			setColor(panel5,4);
		}

		else if (e.getSource() == button6) {
			setColor(panel6,5);
		}

	}
	
	

	public ArrayList<Color> getColors() {
		return colors;
	}

	public void setColors(ArrayList<Color> colors) {
		this.colors = colors;
	}

	private void setColor(JPanel panel, int index) {
		Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
		if(newColor == null) {
			return;
		}
		else {
			panel.setBackground(newColor);
			colors.set(index,newColor);
		}
		

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == displayLength){

			affectiveColorService.changeDisplayLength(displayLength.getText());
		}
	}
}
