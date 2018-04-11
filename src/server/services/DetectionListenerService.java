package server.services;

import server.listener.DetectionListenerInterface;
import server.model.ServerModelSingleton;

import server.view.ServerView;

/**
 * The DetectionListenerService class
 * 
 * @author Team 06
 * @version 1.0
 */
public class DetectionListenerService implements DetectionListenerInterface {
	ServerView serverView;

	/**
	 * changes counter value on serverview
	 * @param counter for clock value
	 */
	@Override
	public void changeCounter(double counter) {
		serverView.changeClockCounter(counter);
	}

	public void setServerView(ServerView serverView) {
		this.serverView = serverView;
	}

	/**
	 * Updates the lowerface expression data based on the selected combobox and
	 * spinner values.
	 * @param exp, val exp
	 */
	
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

	/**
	 * Updates the upperface expression data based on the selected combobox and
	 * spinner values.
	 * @param exp, float
	 */
	public void changeUpperface(String exp, float val) {
		resetUpperface();
		if (exp.equals("Raise Brow")) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(val);
		} else if (exp.equals("Furrow Brow")) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(val);
		}
	}

	/**
	 * Updates the performance Matrics affective data based on the selected combobox
	 * and spinner values.
	 * @param exp,val
	 */
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

	/**
	 * Updates the eye expression data based on the selected combobox values.
	 * @param eye the current eye value
	 */
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

	/**
	 * resets all eye expression data to false
	 */
	public void resetEye() {
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setBlink(false);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(false);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(false);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(false);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(false);
	}

	/**
	 * resets all upperface expression data to 0
	 */
	public void resetUpperface() {
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(0);
	}

	/**
	 * resets all lowerface expression data to 0
	 */
	public void resetLowerface() {
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
	}

	/**
	 * resets all performance Metrics expression data to 0
	 */
	public void resetPerformanceMetrics() {
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setInterest(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setEngagement(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setStress(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setExcitement(0);
	}

	/**
	 * disables eye checkbox and radio button
	 */
	@Override
	public void disableActive() {
		serverView.disableActive();
	}

	/**
	 * resets Eye checkbox
	 */
	@Override
	public void setEyeAutoResetCheckBox(boolean flag) {
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setAutoReset(flag);
	}
}
