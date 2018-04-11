package client.services;

import java.awt.Color;
import java.util.ArrayList;
import client.listener.AffectiveColorListener;
import client.model.AffectivePlotData;
import client.view.ClientFrame;

/**
 * The AffectiveColorService class
 * 
 * @author Team06
 * @version 1.0
 */
public class AffectiveColorService implements AffectiveColorListener {

	private ClientFrame clientWindow;

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

	/**
	 * 
	 */
	@Override
	public void changedisplayLengthLabel(String text) {
		try {
			AffectivePlotData.getInstance().setGraphLength(Integer.parseInt(text));
			clientWindow.changedisplayLengthLabel();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}