package server.listener;

/**
 *
 */
public interface DetectionListenerInterface {

    public void changeCounter(double counter);

    public void changeLowerface(String exp, float val);

    public void changeUpperface(String exp, float val);

    public void changePerformanceMatrics(String exp, float val);

    public void changeEye(String eye);

    public void resetEye();

    public void resetUpperface();

    public void resetLowerface();

    public void resetPerformanceMetrics();

    public void disableActive();

    void setEyeAutoResetCheckBox(boolean b);
}
