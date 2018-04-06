package server.services;

import server.listener.DetectionListenerInterface;
import server.view.ServerView;

public class DetectionListenerService implements DetectionListenerInterface{
	ServerView serverView;
	@Override
	public void changeCounter(double counter) {
		serverView.changeClockCounter(counter);
		
	}
	
	public void setServerView(ServerView serverView) {
		this.serverView = serverView;
	}

	@Override
	public void changeLowerfaceSpinner(double val) {
		// TODO Auto-generated method stub
		
	}

}
