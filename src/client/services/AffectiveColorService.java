package client.services;

import client.view.ClientFrame;
import client.listener.AffectiveColorListener;
import java.awt.Color;
import java.util.ArrayList;



/**
 *
 */
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
    public void changedisplayLengthLabel(String text) {

        clientWindow.changedisplayLengthLabel(text);
    }
}
