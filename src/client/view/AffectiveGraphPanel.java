package client.view;

import client.model.SingleTonData;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is a part of AffectivePanel UI. 
 * This panel is for Graph plot.
 *
 * @author avinash
 */

class AffectiveGraphPanel extends JPanel{
	
	public AffectiveGraphPanel(){	
		BuildPanel();	
	}

	public JPanel BuildPanel() {
		AffectivePlot graphPart;
		
		/*setLayout(new BorderLayout());
		setBackground(new Color(253, 235, 208));
		JLabel GraphPlot = new JLabel("Graph Plot",JLabel.CENTER);
		GraphPlot.setFont(new Font("Papyrus", Font.BOLD, 15));
		add(GraphPlot, BorderLayout.NORTH);

		setLayout(new BorderLayout());
		graphPart = new AffectivePlot();
		SingleTonData.getInstance().setAffectivePlot(graphPart);
		graphPart.setBackground(Color.WHITE);
		add(graphPart);
		return this;*/
		
		JPanel panelOne = new JPanel();
		panelOne.setLayout(new BorderLayout());
		panelOne.setBackground(new Color(253, 235, 208));
		JLabel GraphPlot = new JLabel("Graph Plot",JLabel.CENTER);
		GraphPlot.setFont(new Font("Papyrus", Font.BOLD, 15));
		panelOne.add(GraphPlot, BorderLayout.NORTH);
		panelOne.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(new BorderLayout());
		this.add(panelOne,BorderLayout.CENTER);
		return this;

		
	}
	
}
