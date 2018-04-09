package client.view;

import client.controller.PlotController;
import client.helper.ClientDataSingleton;
import client.model.ExpressivePlotData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * ExpressionPlots class plots the graph of expressions received from server
 *
 * @author Abhishek
 */
public class ExpressionPlots extends JPanel {
    JPanel expression1 = new JPanel();
    JPanel expression2 = new JPanel();
    JPanel expression3 = new JPanel();
    JPanel expression4 = new JPanel();
    JPanel expression5 = new JPanel();
    JPanel expression6 = new JPanel();
    JPanel expression7 = new JPanel();
    JPanel expression8 = new JPanel();
    JPanel expression9 = new JPanel();
    JPanel expression10 = new JPanel();
    JPanel expression11 = new JPanel();
    JPanel expression12 = new JPanel();
    
    private PlotController plotController = new PlotController();
    //private ExpressivePlotData expressivePlotData;
    private ArrayList<ArrayList<Float>> plotData = new ArrayList<>();
    private ArrayList<ArrayList<Float>> inputData = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();
    
    private GraphPlot graphPlot;
    private GraphPlot graphPlot1;
    private GraphPlot graphPlot2;
    private GraphPlot graphPlot3;
    private GraphPlot graphPlot4;
    private GraphPlot graphPlot5;
    private GraphPlot graphPlot6;
    private GraphPlot graphPlot7;
    private GraphPlot graphPlot8;
    private GraphPlot graphPlot9;
    private GraphPlot graphPlot10;
    private GraphPlot graphPlot11;
    private GraphPlot graphPlot12;
    
    JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane5 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane6 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane7 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane8 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane9 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane10 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane11 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane12 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    
	
	public ExpressionPlots() {
		this.setPreferredSize(new Dimension(500, 500));
		addPanels();
	}
	
	private void setRandomColors(int size) {
		for (int i = 0; i < size; i++) {
			Random rand = new Random();
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, g, b);
			colors.add(randomColor);
		}
    }
    
    public void addPanels() {
    	this.setLayout(new GridLayout(12,1,1,1));
    	setPanelsLayout(expression1, splitPane1, "Blink");
    	setPanelsLayout(expression2, splitPane2, "Clench");
    	setPanelsLayout(expression3, splitPane3, "FurrowBrow");
    	setPanelsLayout(expression4, splitPane4, "Laugh");
    	setPanelsLayout(expression5, splitPane5, "LookLeft");
    	setPanelsLayout(expression6, splitPane6, "LookRight");
    	setPanelsLayout(expression7, splitPane7, "RaiseBrow");
    	setPanelsLayout(expression12, splitPane12, "Smile");
    	setPanelsLayout(expression8, splitPane8, "SmirkLeft");
    	setPanelsLayout(expression9, splitPane9, "SmirkRight");
    	setPanelsLayout(expression10, splitPane10, "WinkLeft");
    	setPanelsLayout(expression11, splitPane11, "WinkRight");
    	
    	this.add(expression1);
    	this.add(expression2);
    	this.add(expression3);
    	this.add(expression4);
    	this.add(expression5);
    	this.add(expression6);
    	this.add(expression7);
    	this.add(expression8);
    	this.add(expression9);
    	this.add(expression10);
    	this.add(expression11);
    	this.add(expression12);
    	setRandomColors(12);
    }
    
    private void setPanelsLayout(JPanel expression, JSplitPane splitPane, String feature) {
    	expression.setLayout(new GridLayout(1,1,1,1));
    	splitPane.setResizeWeight(0.1);
    	
    	splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        splitPane.add(new JLabel(feature));
        expression.add(splitPane);
    }
    
    private GraphPlot plotGraphForFeature(ArrayList<Float> data) {
    	//graphPlot.removeAll();
    	System.out.println(data);
    	inputData.clear();
    	inputData.add(data);
    	graphPlot = new GraphPlot(inputData, colors);
    	graphPlot.setBackground(Color.LIGHT_GRAY);
    	return graphPlot;
    }
    
    public void plotExpressionGraph() {

            if(ClientDataSingleton.getInstance().getFaceData() != null) {
    	        //expressivePlotData = ExpressivePlotData.getInstance();
    	        plotData = plotController.getExpressivePlotData();
    	        
    	        System.out.println("Blink Array");
    	        graphPlot1 = plotGraphForFeature(plotData.get(0));
    	        addGraphsToPanel(expression1, splitPane1, graphPlot1, "Blink");

    	        System.out.println("Clench Array");
    	        graphPlot2 = plotGraphForFeature(plotData.get(1));
    	        addGraphsToPanel(expression2, splitPane2, graphPlot2, "Clench");

    	        System.out.println("FurrowBrow Array");
    	        graphPlot3 = plotGraphForFeature(plotData.get(2));
    	        addGraphsToPanel(expression3, splitPane3, graphPlot3, "FurrowBrow");

    	        System.out.println("Laugh Array");
    	        graphPlot4 = plotGraphForFeature(plotData.get(3));
    	        addGraphsToPanel(expression4, splitPane4, graphPlot4, "Laugh");

    	        System.out.println("LookLeft Array");
    	        graphPlot5 = plotGraphForFeature(plotData.get(4));
    	        addGraphsToPanel(expression5, splitPane5, graphPlot5, "LookLeft");

    	        System.out.println("LookRight Array");
    	        graphPlot6 = plotGraphForFeature(plotData.get(5));
    	        addGraphsToPanel(expression6, splitPane6, graphPlot6, "LookRight");

    	        System.out.println("RaiseBrow Array");
    	        graphPlot7 = plotGraphForFeature(plotData.get(6));
    	        addGraphsToPanel(expression7, splitPane7, graphPlot7, "RaiseBrow");

    	        System.out.println("Smile Array");
    	        graphPlot8 = plotGraphForFeature(plotData.get(7));
    	        addGraphsToPanel(expression8, splitPane8, graphPlot8, "Smile");

    	        System.out.println("SmirkLeft Array");
    	        graphPlot9 = plotGraphForFeature(plotData.get(8));
    	        addGraphsToPanel(expression9, splitPane9, graphPlot9, "SmirkLeft");

    	        System.out.println("SmirkRight Array");
    	        graphPlot10 = plotGraphForFeature(plotData.get(9));
    	        addGraphsToPanel(expression10, splitPane10, graphPlot10, "SmirkRight");

    	        System.out.println("WinkLeft Array");
    	        graphPlot11 = plotGraphForFeature(plotData.get(10));
    	        addGraphsToPanel(expression11, splitPane11, graphPlot11, "WinkLeft");

    	        System.out.println("WinkRight Array");
    	        graphPlot12 = plotGraphForFeature(plotData.get(11));
    	        addGraphsToPanel(expression12, splitPane12, graphPlot12, "WinkRight");


            }


    }
    
    private void addGraphsToPanel(JPanel expression, JSplitPane splitPane, GraphPlot graphPlotCurr, String feature) {
    	expression.removeAll();
    	splitPane.removeAll();
    	setPanelsLayout(expression, splitPane, feature);
    	splitPane.add(graphPlotCurr);
        expression.add(splitPane);
        expression.repaint();
        expression.revalidate();
    	
    }
    
}
