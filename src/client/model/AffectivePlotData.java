package client.model;

import java.util.ArrayList;

public class AffectivePlotData {

    private static volatile AffectivePlotData affectivePlotData;
    private static Object mutex = new Object();
    private ArrayList<Float> interest = new ArrayList<>();
    private ArrayList<Float> engagement = new ArrayList<>();
    private ArrayList<Float> stress = new ArrayList<>();
    private ArrayList<Float> relaxation = new ArrayList<>();
    private ArrayList<Float> excitement = new ArrayList<>();
    private ArrayList<Float> focus = new ArrayList<>();
    public static AffectivePlotData getAffectivePlotData() {
        return affectivePlotData;
    }

    public static AffectivePlotData getInstance() {
        AffectivePlotData result = affectivePlotData;
        if (result == null) {
            synchronized (mutex) {
                result = affectivePlotData;
                if (result == null)
                    result = new AffectivePlotData();
                affectivePlotData = result;
            }
        }
        return result;
    }
}
