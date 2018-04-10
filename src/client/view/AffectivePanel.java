package client.view;
import client.services.AffectiveColorService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class creates the affective panel in which graph plot is done based on 6 parameters.
 *
 * @author avinash
 */

public class AffectivePanel extends JPanel {


    public static final String TABNAME = "Affective";

    AffectiveGraphPanel panelGraph;
    AffectivePerformanceMetricPanel panelMetric;

    /**
     * constructor of affective panel.
     * calls two other classes -
     * AffectiveGraphPanel: for graph plot panel
     * AffectivePerformanceMetricPanel. - for performance metric panel.
     *
     */

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