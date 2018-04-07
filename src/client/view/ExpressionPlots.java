package client.view;

import client.model.ClientModelSingleton;
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
    
    private ExpressivePlotData expressivePlotData;
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
    	setPanelsLayout(expression1, splitPane1, "RaiseBrow");
    	setPanelsLayout(expression2, splitPane2, "FurrowBrow");
    	setPanelsLayout(expression3, splitPane3, "Smile");
    	setPanelsLayout(expression4, splitPane4, "Clench");
    	setPanelsLayout(expression5, splitPane5, "SmirkLeft");
    	setPanelsLayout(expression6, splitPane6, "SmirkRight");
    	setPanelsLayout(expression7, splitPane7, "Laugh");
    	setPanelsLayout(expression8, splitPane8, "WinkLeft");
    	setPanelsLayout(expression9, splitPane9, "WinkRight");
    	setPanelsLayout(expression10, splitPane10, "LookLeft");
    	setPanelsLayout(expression11, splitPane11, "LookRight");
    	setPanelsLayout(expression12, splitPane12, "Blink");
    	
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
    	inputData.add(data);
    	graphPlot = new GraphPlot(inputData, colors);
    	graphPlot.setBackground(Color.BLUE);
    	return graphPlot;
    }
    
    public void plotExpressionGraph() {
            if(ClientModelSingleton.getInstance().getFaceData() != null) {
    	        expressivePlotData = ExpressivePlotData.getInstance();

    	        graphPlot1 = plotGraphForFeature(expressivePlotData.getBlinkList());
    	        addGraphsToPanel(expression1, splitPane1, graphPlot1);


    	        graphPlot2 = plotGraphForFeature(expressivePlotData.getClenchList());
    	        addGraphsToPanel(expression2, splitPane2, graphPlot2);

    	        graphPlot3 = plotGraphForFeature(expressivePlotData.getFurrowBrowList());
    	        addGraphsToPanel(expression3, splitPane3, graphPlot3);

    	        graphPlot4 = plotGraphForFeature(expressivePlotData.getLaughList());
    	        addGraphsToPanel(expression4, splitPane4, graphPlot4);

    	        graphPlot5 = plotGraphForFeature(expressivePlotData.getLookLeftList());
    	        addGraphsToPanel(expression5, splitPane5, graphPlot5);

    	        graphPlot6 = plotGraphForFeature(expressivePlotData.getLookRightList());
    	        addGraphsToPanel(expression6, splitPane6, graphPlot6);

    	        graphPlot7 = plotGraphForFeature(expressivePlotData.getRaiseBrowList());
    	        addGraphsToPanel(expression7, splitPane7, graphPlot7);

    	        graphPlot8 = plotGraphForFeature(expressivePlotData.getSmileList());
    	        addGraphsToPanel(expression8, splitPane8, graphPlot8);

    	        graphPlot9 = plotGraphForFeature(expressivePlotData.getSmirkLeftList());
    	        addGraphsToPanel(expression9, splitPane9, graphPlot9);

    	        graphPlot10 = plotGraphForFeature(expressivePlotData.getSmirkRightList());
    	        addGraphsToPanel(expression10, splitPane10, graphPlot10);

    	        graphPlot11 = plotGraphForFeature(expressivePlotData.getWinkLeftList());
    	        addGraphsToPanel(expression11, splitPane11, graphPlot11);

    	        graphPlot12 = plotGraphForFeature(expressivePlotData.getWinkRightList());
    	        addGraphsToPanel(expression12, splitPane12, graphPlot12);


            }


    }
    
    private void addGraphsToPanel(JPanel expression, JSplitPane splitPane, GraphPlot graphPlot) {
    	expression.removeAll();
    	splitPane.add(graphPlot);
        expression.add(splitPane);
        expression.repaint();
        expression.revalidate();
    	
    }
    
}
