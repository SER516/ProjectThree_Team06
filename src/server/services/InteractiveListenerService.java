package server.services;

import server.listener.InteractiveListener;
import server.model.ServerModelSingleton;

/**
 *
 */
public class InteractiveListenerService implements InteractiveListener {

	@Override
	public void autoResetChange(String stateValue) {
		Double stateInterval = Double.parseDouble(stateValue);
		ServerModelSingleton.getInstance().setStateInterval(stateInterval);
	}

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
