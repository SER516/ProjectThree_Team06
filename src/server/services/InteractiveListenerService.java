package server.services;

import server.listener.InteractiveListener;
import server.model.ServerModelSingleton;

/**
 * The DetectionListenerService class
 * 
 * @author Team 06
 * @version 1.0
 */
public class InteractiveListenerService implements InteractiveListener {
	
	/*
	 * (non-Javadoc)
	 * @see server.listener.InteractiveListener#autoResetChange(java.lang.String)
	 */
	@Override
	public void autoResetChange(String stateValue) {
		Double stateInterval = Double.parseDouble(stateValue);
		ServerModelSingleton.getInstance().setStateInterval(stateInterval);
	}
	
	/*
	 * (non-Javadoc)
	 * @see server.listener.InteractiveListener#stateSpinnerChange(boolean)
	 */
	@Override
	public void stateSpinnerChange(boolean isSelected) {
		if (isSelected) {
			ServerModelSingleton.getInstance().setAutoReset(true);
			ServerModelSingleton.getInstance().setOneTimeSend(false);
		} else {
			ServerModelSingleton.getInstance().setAutoReset(false);
			ServerModelSingleton.getInstance().setOneTimeSend(true);
		}
	}
}
