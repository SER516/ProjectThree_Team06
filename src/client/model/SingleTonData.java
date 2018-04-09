package client.model;

import client.view.AffectivePlot;
import client.view.ExpressionPlots;
import client.view.FaceExpressions;

public class SingleTonData {
	private ExpressionPlots expressplot;
	private AffectivePlot affectivePlot;
	private FaceExpressions faceExpression;
	
	public FaceExpressions getFaceExpression() {
		return faceExpression;
	}

	public void setFaceExpression(FaceExpressions faceExpression) {
		this.faceExpression = faceExpression;
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

	private static volatile SingleTonData singletondata;
	private static Object mutex = new Object();
	
	public static SingleTonData getInstance() {
		SingleTonData result = singletondata;
	if (result == null) {
		synchronized (mutex) {
			result = singletondata;
			if (result == null)
			{
				result = new SingleTonData();
				
			}
			singletondata = result;
		}
	}
	return result;
	}
}