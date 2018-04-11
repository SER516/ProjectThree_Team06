package server.services;

import server.constants.ServerConstants;
import server.listener.DetectionListenerInterface;
import server.model.ServerModelSingleton;

import server.view.ServerView;

/**
 * The DetectionListenerService class implements the Detection Listener that changes the nature of data being sent to
 * client for eg. the parameters for upper face , lower face, eye and performance metric values.
 * 
 * @author Team 06
 * @version 1.0
 */
public class DetectionListenerService implements DetectionListenerInterface {
	ServerView serverView;

	/**
	 * changes counter value on serverview
	 * 
	 * @param counter
	 *            for clock value
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
	 * 
	 * @param exp,
	 *            val exp
	 */

	public void changeLowerface(String exp, float val) {
		resetLowerface();
		if (exp.equals(ServerConstants.SMILE)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmile(val);
		} else if (exp.equals(ServerConstants.CLENCH)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setClench(val);
		} else if (exp.equals(ServerConstants.SMIRK_LEFT)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(val);
		} else if (exp.equals(ServerConstants.SMIRK_RIGHT)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(val);
		} else if (exp.equals(ServerConstants.LAUGH)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(val);
		}
	}

	/**
	 * Updates the upperface expression data based on the selected combobox and
	 * spinner values.
	 * 
	 * @param exp,
	 *            float
	 */
	public void changeUpperface(String exp, float val) {
		resetUpperface();
		if (exp.equals(ServerConstants.RAISE_BROW)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(val);
		} else if (exp.equals(ServerConstants.FURROW_BROW)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(val);
		}
	}

	/**
	 * Updates the performance Matrics affective data based on the selected combobox
	 * and spinner values.
	 * 
	 * @param exp,val
	 */
	public void changePerformanceMatrics(String exp, float val) {
		resetPerformanceMetrics();
		if (exp.equals(ServerConstants.INTEREST)) {
			ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setInterest(val);
		} else if (exp.equals(ServerConstants.ENGAGEMENT)) {
			ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setEngagement(val);
		} else if (exp.equals(ServerConstants.STRESS)) {
			ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setStress(val);
		} else if (exp.equals(ServerConstants.RELAXATION)) {
			ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(val);
		} else if (exp.equals(ServerConstants.EXCITEMENT)) {
			ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setExcitement(val);
		} else if (exp.equals(ServerConstants.FOCUS)) {
			ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setFocus(val);
		}
	}

	/**
	 * Updates the eye expression data based on the selected combobox values.
	 * 
	 * @param eye
	 *            the current eye value
	 */
	public void changeEye(String eye) {
		resetEye();
		if (eye.equals(ServerConstants.BLINK)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setBlink(true);
		} else if (eye.equals(ServerConstants.WINK_LEFT)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(true);
		} else if (eye.equals(ServerConstants.WINK_RIGHT)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(true);
		} else if (eye.equals(ServerConstants.LOOK_LEFT)) {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(true);
		} else if (eye.equals(ServerConstants.LOOK_RIGHT)) {
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
