package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import client.model.SingleTonData;
import client.services.AffectiveColorService;
import constants.ClientConstants;

/**
 * This is a part of AffectivePanel UI. This panel is for Graph plot.
 *
 * @author avinash
 */

class AffectiveGraphPanel extends JPanel {

	AffectivePlot graphPart;

	public AffectiveGraphPanel() {
		buildPanel();
	}

	/**
	 * This function constructs a JPanel at the center for graph plot.
	 * 
	 * @return
	 */
	public JPanel buildPanel() {
		setLayout(new BorderLayout());
		setBackground(ClientConstants.LIGHT_YELLOW);
		JLabel GraphPlot = new JLabel(ClientConstants.GRAPH_PLOT, JLabel.CENTER);
		GraphPlot.setFont(ClientConstants.TEXT_FONT);
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

	public void changedisplayLengthLabel(String text) {
		graphPart.changedisplayLengthLabel(text);
	}
}