package client.model;

import client.controller.ClientFaceController;
import client.view.AffectivePlot;
import client.view.ExpressionPlots;
import client.view.FaceExpressions;

/**
 *Class that sets up all the required singleton objects on client side.
 */
public class SingleTonData {
    private static volatile SingleTonData singletondata;
    private static Object mutex = new Object();
    private ExpressionPlots expressplot;
    private AffectivePlot affectivePlot;
    private ClientFaceController faceExpressionController;
    private FaceExpressions faceExpressions;

    /**
     *
     * @return
     */
    public static SingleTonData getInstance() {
        SingleTonData result = singletondata;
        if (result == null) {
            synchronized (mutex) {
                result = singletondata;
                if (result == null) {
                    result = new SingleTonData();

                }
                singletondata = result;
            }
        }
        return result;
    }

    public FaceExpressions getFaceExpressions() {
        return faceExpressions;
    }

    public void setFaceExpressions(FaceExpressions faceExpressions) {
        this.faceExpressions = faceExpressions;
    }

    public ClientFaceController getFaceExpressionController() {
        return faceExpressionController;
    }

    public void setFaceExpressionController(ClientFaceController faceExpressionController) {
        this.faceExpressionController = faceExpressionController;
    }

    public ExpressionPlots getExpressplot() {
        return expressplot;
    }

    public void setExpressplot(ExpressionPlots expressplot) {
        this.expressplot = expressplot;
    }

    public AffectivePlot getAffectivePlot() {
        return affectivePlot;
    }

    public void setAffectivePlot(AffectivePlot affectivePlot) {
        this.affectivePlot = affectivePlot;
    }
}