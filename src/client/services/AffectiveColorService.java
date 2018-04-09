package client.services;

import java.awt.Color;
import java.util.ArrayList;

import client.listener.AffectiveColorListener;
import client.view.ClientFrame;

public class AffectiveColorService implements AffectiveColorListener {

	ClientFrame clientWindow;
	
    public AffectiveColorService(ClientFrame clientWindow) {
		this.clientWindow = clientWindow;
	}

	@Override
    public void setColor() {

    }

	@Override
	public ArrayList<Color> getColors() {
		return clientWindow.getColors();

	}

	@Override
	public void changeDisplayLength(String text) {

		clientWindow.changeDisplayLength(text);
	}
}
