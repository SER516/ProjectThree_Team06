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

    AffectiveGraphPanel panelGraph;
    AffectivePerformanceMetricPanel panelMetric;

    public AffectivePanel() {
        panelGraph = new AffectiveGraphPanel();
        panelMetric = new AffectivePerformanceMetricPanel();
        setLayout(new BorderLayout());
        add(panelGraph, BorderLayout.CENTER);
        add(panelMetric, BorderLayout.EAST);
    }

    public void setAffectiveListener(AffectiveColorService affectiveColorService) {
        panelGraph.setAffectiveListener(affectiveColorService);
        panelMetric.setAffectiveListener(affectiveColorService);
    }

    public ArrayList<Color> getColors() {
        return panelMetric.getColors();

    }

    public void changeDisplayLength(String text) {
        panelGraph.changeDisplayLength(text);
    }
}