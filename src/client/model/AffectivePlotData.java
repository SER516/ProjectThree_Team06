package client.model;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class AffectivePlotData {

    private static volatile AffectivePlotData affectivePlotData;
    private static Object mutex = new Object();
    XYSeriesCollection dataset;
    XYSeries interestSeries = new XYSeries("interest");
    XYSeries engagementSeries = new XYSeries("engagementSeries");
    XYSeries relaxSeries = new XYSeries("relaxSeries");
    XYSeries stressSeries = new XYSeries("stressSeries");
    XYSeries excitmentSeries = new XYSeries("excitmentSeries");
    XYSeries focusSeries = new XYSeries("focusSeries");
    private ArrayList<Float> interestList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> engagementList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> relaxList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> stressList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> excitmentList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> focusList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<ArrayList<Float>> mainDataList = new ArrayList<>();

    public static AffectivePlotData getAffectivePlotData() {
        return affectivePlotData;
    }

    /**
     * @return
     */
    public static AffectivePlotData getInstance() {
        AffectivePlotData result = affectivePlotData;
        if (result == null) {
            synchronized (mutex) {
                result = affectivePlotData;
                if (result == null) {
                    result = new AffectivePlotData();
                }
                affectivePlotData = result;
            }
        }
        return result;
    }

    public XYSeriesCollection getDataset() {
        return dataset;
    }

    public ArrayList<Float> getFocusList() {
        return focusList;
    }

    public void setFocusList(ArrayList<Float> focusList) {
        this.focusList = focusList;
    }

    public ArrayList<ArrayList<Float>> getMainDataList() {
        return mainDataList;
    }

    public ArrayList<Float> getInterestList() {
        return interestList;
    }

    public void setInterestList(ArrayList<Float> interestList) {
        this.interestList = interestList;
    }

    public ArrayList<Float> getEngagementList() {
        return engagementList;
    }

    public void setEngagementList(ArrayList<Float> engagementList) {
        this.engagementList = engagementList;
    }

    public ArrayList<Float> getRelaxList() {
        return relaxList;
    }

    public void setRelaxList(ArrayList<Float> relaxList) {
        this.relaxList = relaxList;
    }

    public ArrayList<Float> getStressList() {
        return stressList;
    }

    public void setStressList(ArrayList<Float> stressList) {
        this.stressList = stressList;
    }

    public ArrayList<Float> getExcitmentList() {
        return excitmentList;
    }

    public void setExcitmentList(ArrayList<Float> excitmentList) {
        this.excitmentList = excitmentList;
    }

    /**
     * @param affectivedata
     * @param faceData
     */
    public void setDataToList(AffectiveData affectivedata, FaceData faceData) {


        double counter = faceData.getCounter();
        dataset = new XYSeriesCollection();
        interestSeries.add(faceData.getCounter(), affectivedata.getInterest());
        engagementSeries.add(faceData.getCounter(), affectivedata.getEngagement());
        relaxSeries.add(faceData.getCounter(), affectivedata.getRelaxation());
        stressSeries.add(faceData.getCounter(), affectivedata.getStress());
        excitmentSeries.add(faceData.getCounter(), affectivedata.getExcitement());
        focusSeries.add(faceData.getCounter(), affectivedata.getFocus());
        dataset.addSeries(focusSeries);
        dataset.addSeries(stressSeries);
        dataset.addSeries(interestSeries);
        dataset.addSeries(engagementSeries);
        dataset.addSeries(relaxSeries);
        dataset.addSeries(excitmentSeries);


    }

    public void setDataForJChart() {

    }
}
