package client.model;

public class AffectivePlotData {

    private static volatile AffectivePlotData affectivePlotData;
    private static Object mutex = new Object();

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
