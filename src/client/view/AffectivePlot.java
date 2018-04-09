package client.view;

import client.helper.ClientDataSingleton;
import client.model.AffectiveData;
import client.model.AffectivePlotData;
import client.services.AffectiveColorService;
import client.view.GraphPlot;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AffectivePlot extends JPanel {

    private AffectiveData affectiveData;
    private ArrayList<ArrayList<Float>> inputData = new ArrayList<>();
    private GraphPlot graphPlot;
    JPanel affectivePanel = new JPanel();
    AffectiveColorService affectiveColorService;
    private Integer length = 500;


    public AffectivePlot() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setLayout(new BorderLayout());
        affectivePanel.setLayout(new GridLayout(1,1,1,1));
        affectivePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.add(affectivePanel);
    }
    public void plotAffectiveGraph(){
    	
        affectivePanel.removeAll();
        affectivePanel.add(getAffectiveGraph());
        affectivePanel.repaint();
        affectivePanel.revalidate();
    }

    public GraphPlot getAffectiveGraph() {
        System.out.println("getAffectiveGraph started");
        AffectivePlotData affectivePlotData = AffectivePlotData.getInstance();
        System.out.println(affectivePlotData.getMainDataList());

        ArrayList<Color> colors =  affectiveColorService.getColors();
        graphPlot = new GraphPlot(affectivePlotData.getMainDataList(), 
        		colors,length);
        
        graphPlot.setBackground(Color.LIGHT_GRAY);
        graphPlot.setBorder(new EmptyBorder(5, 5, 5, 5));
        System.out.println("getAffectiveGraph end");
        return graphPlot;
    }

	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		this.affectiveColorService = affectiveColorService;
	}

    public void changeDisplayLength(String length) {
        this.length = Integer.parseInt(length);
        plotAffectiveGraph();
    }


}
