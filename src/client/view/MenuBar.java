package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * MenuBar handles the menu options given on main frame
 *
 * @author Abhishek
 */
public class MenuBar extends JMenuBar implements ActionListener {
    JMenuItem launchServer = new JMenuItem("Launch Server");
    JMenuItem connect = new JMenuItem("Connect");
    JMenuItem reconnect = new JMenuItem("Reconnect");

    public MenuBar(){
        URL url = getClass().getResource("menu.jpg");
        JMenu menu = new JMenu("Menu");
        BufferedImage menuImage;
        BufferedImage resizeImg = null;
        try{
            menuImage = ImageIO.read(url);

            resizeImg= new BufferedImage(30, 24, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = resizeImg.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(menuImage, 0, 0, 30, 24, null);
            g2.dispose();
        }catch (IOException e){
            menuImage = null;
        }
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setIcon(new ImageIcon(resizeImg));
        menu.add(launchServer);
        JMenu connectMenu = new JMenu("Connect");
        connectMenu.add(connect);
        connectMenu.add(reconnect);
        menu.add(connectMenu);
        launchServer.addActionListener(this);
        add(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == launchServer)
        {
            // Server Launching code
        }
        else if (e.getSource() == connect)
        {
            // connect to server code
        }
        else if (e.getSource() == reconnect)
        {
            // reconnect to server code
        }
    }

}
