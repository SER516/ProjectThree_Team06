package client.view;

import client.helper.ClientDataSingleton;
import client.model.AffectiveData;
import client.model.AffectivePlotData;
import client.model.FaceData;
import client.model.SingleTonData;
import client.services.AffectiveColorService;
import client.view.GraphPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AffectivePlot extends JPanel {

    JPanel affectivePanel = new JPanel();
    AffectiveColorService affectiveColorService;
    private AffectiveData affectiveData;
    private ArrayList<ArrayList<Float>> inputData = new ArrayList<>();
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
        graphPlot = new GraphPlot(affectivePlotData.getMainDataList(),
                colors, length);

        graphPlot.setBackground(Color.LIGHT_GRAY);
        graphPlot.setBorder(new EmptyBorder(5, 5, 5, 5));

        return graphPlot;
    }

    public void setAffectiveListener(AffectiveColorService affectiveColorService) {
        this.affectiveColorService = affectiveColorService;
    }

    public void changeDisplayLength(String length) {
        try {
            this.length = Integer.parseInt(length);
            plotAffectiveGraph1(AffectivePlotData.getInstance().getDataset());
        } catch (Exception e) {
            System.out.print("Invalid data");
        }

    }


    public void plotAffectiveGraph1(XYSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart("", "",
                "", dataset, PlotOrientation.VERTICAL, false, true,
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
