package client.view;

import client.helper.ClientDataSingleton;
import client.model.AffectiveData;
import client.view.GraphPlot;

import javax.swing.*;
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
        setRandomColors(1);
        this.setLayout(new BorderLayout());
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
        ArrayList<Float> affectiveDataList = new ArrayList<Float>();
        //AffectiveData affectiveData = ClientDataSingleton.getInstance().getFaceData().getAffectiveData();
        // Testing Data
        affectiveDataList.add(0.6f);
        affectiveDataList.add(0.1f);
        affectiveDataList.add(0.4f);
        affectiveDataList.add(0.3f);
        affectiveDataList.add(0.2f);
        inputData.add(affectiveDataList);
        graphPlot = new GraphPlot(inputData, colors);
        graphPlot.setBackground(Color.BLUE);
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
