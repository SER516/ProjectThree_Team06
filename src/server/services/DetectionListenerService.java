package server.services;

import server.listener.DetectionListenerInterface;
import server.model.ServerModelSingleton;

import server.view.ServerView;

/**
 *
 */
public class DetectionListenerService implements DetectionListenerInterface {
    ServerView serverView;

    @Override
    public void changeCounter(double counter) {
        serverView.changeClockCounter(counter);
    }

    public void setServerView(ServerView serverView) {
        this.serverView = serverView;
    }

    public void changeLowerface(String exp, float val) {
        resetLowerface();
        if (exp.equals("Smile")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmile(val);
        } else if (exp.equals("Clench")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setClench(val);
        } else if (exp.equals("Smirk Left")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(val);
        } else if (exp.equals("Smirk Right")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(val);
        } else if (exp.equals("Laugh")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(val);
        }
    }

    public void changeUpperface(String exp, float val) {
        resetUpperface();
        if (exp.equals("Raise Brow")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(val);
        } else if (exp.equals("Furrow Brow")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(val);
        }
    }

    public void changePerformanceMatrics(String exp, float val) {
        resetPerformanceMetrics();
        if (exp.equals("Interest")) {
            ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setInterest(val);
        } else if (exp.equals("Engagement")) {
            ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setEngagement(val);
        } else if (exp.equals("Stress")) {
            ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setStress(val);
        } else if (exp.equals("Relaxation")) {
            ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(val);
        } else if (exp.equals("Excitement")) {
            ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setExcitement(val);
        } else if (exp.equals("Focus")) {
            ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setFocus(val);
        }
    }

    public void changeEye(String eye) {
        resetEye();
        if (eye.equals("Blink")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setBlink(true);
        } else if (eye.equals("Wink Left")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(true);
        } else if (eye.equals("Wink Right")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(true);
        } else if (eye.equals("Look Left")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(true);
        } else if (eye.equals("Look Right")) {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(true);
        }
    }

    public void resetEye() {
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setBlink(false);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(false);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(false);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(false);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(false);
    }

    public void resetUpperface() {
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(0);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(0);
    }

    public void resetLowerface() {
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
    }

    public void resetPerformanceMetrics() {
        ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setInterest(0);
        ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setEngagement(0);
        ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setStress(0);
        ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(0);
        ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(0);
        ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setExcitement(0);
    }

    @Override
    public void disableActive() {
        serverView.disableActive();
    }

    @Override
    public void setEyeAutoResetCheckBox(boolean flag) {
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setAutoReset(flag);
    }
}
