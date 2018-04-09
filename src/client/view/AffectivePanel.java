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

/**
 * This is a UI for Affective panel which plots the graph of parameters in
 * performance metrics.
 *
 * @author avinash
 */

public class AffectivePanel extends JPanel {
	public static final String TABNAME = "Affective";

	AffectiveGraphPanel panelOne;
	AffectivePerformanceMetricPanel panelTwo;

	public AffectivePanel() {
		panelOne = new AffectiveGraphPanel();
		panelTwo = new AffectivePerformanceMetricPanel();
		setLayout(new BorderLayout());
		add(panelOne, BorderLayout.CENTER);
		add(panelTwo, BorderLayout.EAST);
	}

	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		panelOne.setAffectiveListener(affectiveColorService);
		panelTwo.setAffectiveListener(affectiveColorService);
	}

	public ArrayList<Color> getColors() {
		return panelTwo.getColors();

	}

	public void changeDisplayLength(String text) {
		panelOne.changeDisplayLength(text);
	}
}