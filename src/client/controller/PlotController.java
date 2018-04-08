package client.controller;

import java.util.ArrayList;

import client.model.ExpressivePlotData;

public class PlotController {
	
	ExpressivePlotData expressivePlotData;
	ArrayList<ArrayList<Float>> expressData = new ArrayList<>();
	
	public ArrayList getExpressivePlotData() {
		expressivePlotData = ExpressivePlotData.getInstance();
		
		expressData.add(expressivePlotData.getBlinkList());
		expressData.add(expressivePlotData.getClenchList());
		expressData.add(expressivePlotData.getFurrowBrowList());
		expressData.add(expressivePlotData.getLaughList());
		expressData.add(expressivePlotData.getLookLeftList());
		expressData.add(expressivePlotData.getLookRightList());
		expressData.add(expressivePlotData.getRaiseBrowList());
		expressData.add(expressivePlotData.getSmileList());
		expressData.add(expressivePlotData.getSmirkLeftList());
		expressData.add(expressivePlotData.getSmirkRightList());
		expressData.add(expressivePlotData.getWinkLeftList());
		expressData.add(expressivePlotData.getWinkRightList());
		return expressData;
		
	}

}