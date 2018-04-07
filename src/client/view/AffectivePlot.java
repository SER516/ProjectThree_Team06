package client.view;

import client.model.AffectiveData;
import client.model.ClientModelSingleton;

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
        this.setPreferredSize(new Dimension(1000, 1000));
        setRandomColors(1);
        //this.setLayout(new BorderLayout());
        this.add(affectivePanel);
    }
    public void plotAffectiveGraph(){
        System.out.println("plotAffectiveGraph");
        affectivePanel.add(getAffectiveGraph());
        affectivePanel.repaint();
        affectivePanel.revalidate();
    }

    public GraphPlot getAffectiveGraph() {
        ArrayList<Float> affectiveDataList = new ArrayList<Float>();
        affectiveData = ClientModelSingleton.getInstance().getFaceData().getAffectiveData();
        affectiveDataList.add(affectiveData.getEngagement());
        affectiveDataList.add(affectiveData.getFocus());
        affectiveDataList.add(affectiveData.getExcitement());
        affectiveDataList.add(affectiveData.getRelaxation());
        affectiveDataList.add(affectiveData.getInterest());
        affectiveDataList.add(affectiveData.getStress());
        inputData.add(affectiveDataList);
        graphPlot = new GraphPlot(inputData, colors);
        graphPlot.setBackground(Color.BLUE);
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
