package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeriesCollection;
import client.model.AffectivePlotData;
import client.services.AffectiveColorService;

/**
 *
 */

public class AffectivePlot extends JPanel {

	JPanel affectivePanel = new JPanel();
	AffectiveColorService affectiveColorService;
	private GraphPlot graphPlot;
	private Integer length = 50;

	public AffectivePlot() {
		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(new BorderLayout());
		affectivePanel.setLayout(new GridLayout(1, 1, 1, 1));
		affectivePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.add(affectivePanel);
	}

	public void plotAffectiveGraph() {
		affectivePanel.removeAll();
		affectivePanel.add(getAffectiveGraph());
		affectivePanel.repaint();
		affectivePanel.revalidate();
	}

	public GraphPlot getAffectiveGraph() {
		AffectivePlotData affectivePlotData = AffectivePlotData.getInstance();
		ArrayList<Color> colors = affectiveColorService.getColors();
		graphPlot = new GraphPlot(affectivePlotData.getMainDataList(), colors, length);
		graphPlot.setBackground(Color.LIGHT_GRAY);
		graphPlot.setBorder(new EmptyBorder(5, 5, 5, 5));
		return graphPlot;
	}

	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		this.affectiveColorService = affectiveColorService;
	}

	public void changedisplayLengthLabel(String length) {
		try {
			this.length = Integer.parseInt(length);
			plotAffectiveGraph1(AffectivePlotData.getInstance().getDataset());
		} catch (Exception e) {
			System.out.print("Invalid data");
		}
	}

	public void plotAffectiveGraph1(XYSeriesCollection dataset) {
		JFreeChart chart = ChartFactory.createXYLineChart("", "", "", dataset, PlotOrientation.VERTICAL, false, true,
				false);
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		ValueAxis range = plot.getRangeAxis();
		range = plot.getDomainAxis();
		range.setRange(0, length);
		range = plot.getRangeAxis();
		range.setRange(0, 1);
		ArrayList<Color> colors = affectiveColorService.getColors();
		for (int i = 0; i < colors.size(); i++) {
			renderer.setSeriesPaint(i, colors.get(i));
			renderer.setSeriesShapesVisible(i, false);
		}
		plot.setRenderer(renderer);
		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);
		affectivePanel.removeAll();
		affectivePanel.add(new ChartPanel(chart));
		affectivePanel.repaint();
		affectivePanel.revalidate();
	}
}
