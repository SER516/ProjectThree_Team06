package server.services;

import server.listener.ClockListenerInterface;
import server.view.ServerView;

public class ClockListenerService implements ClockListenerInterface {
	ServerView serverView;
	
	public ClockListenerService() {

	}

	@Override
	public void changeCounter(double counter) {
		serverView.changeClockCounter(counter);	
	}

	public void attachViewToListener(ServerView serverView) {
		this.serverView = serverView;
		
	}

}
