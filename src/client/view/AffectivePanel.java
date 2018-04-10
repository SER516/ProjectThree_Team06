package client.view;


import client.services.AffectiveColorService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;


/**
 * This is a UI for Affective panel which plots the graph of parameters in performance metrics.
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

    public void changedisplayLengthLabel(String text) {
        panelGraph.changedisplayLengthLabel(text);
    }
}