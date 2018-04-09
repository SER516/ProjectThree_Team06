package client.view;

import client.model.SingleTonData;
import client.services.AffectiveColorService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is a part of AffectivePanel UI.
 * This panel is for Graph plot.
 *
 * @author avinash
 */

class AffectiveGraphPanel extends JPanel {

    AffectivePlot graphPart;

    public AffectiveGraphPanel() {
        BuildPanel();
    }

    public JPanel BuildPanel() {


        setLayout(new BorderLayout());
        setBackground(new Color(253, 235, 208));
        JLabel GraphPlot = new JLabel("Graph Plot", JLabel.CENTER);
        GraphPlot.setFont(new Font("Papyrus", Font.BOLD, 15));
        add(GraphPlot, BorderLayout.NORTH);

        setLayout(new BorderLayout());
        graphPart = new AffectivePlot();
        SingleTonData.getInstance().setAffectivePlot(graphPart);
        graphPart.setBackground(Color.WHITE);
        add(graphPart);
        return this;


    }

    public void setAffectiveListener(AffectiveColorService affectiveColorService) {
        graphPart.setAffectiveListener(affectiveColorService);

    }


    public void changeDisplayLength(String text) {
        graphPart.changeDisplayLength(text);
    }
}
