package client.view;

import client.helper.ClientDataSingleton;
import client.model.AffectiveData;
import client.model.AffectivePlotData;
import client.view.GraphPlot;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AffectivePlot extends JPanel {

    private AffectiveData affectiveData;
    private ArrayList<ArrayList<Float>> inputData = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();
    private GraphPlot graphPlot;
    JPanel affectivePanel = new JPanel();

    public AffectivePlot() {
        this.setPreferredSize(new Dimension(500, 500));
        setRandomColors(5);
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
        graphPlot = new GraphPlot(affectivePlotData.getMainDataList(), colors);
        graphPlot.setBackground(Color.LIGHT_GRAY);
        graphPlot.setBorder(new EmptyBorder(5, 5, 5, 5));
        System.out.println("getAffectiveGraph end");
        return graphPlot;
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
}
