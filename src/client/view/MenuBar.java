package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * MenuBar handles the menu options given on main frame
 *
 * @author Abhishek
 */
public class MenuBar extends JMenuBar implements ActionListener {
    JMenuItem launchServer;
    JMenuItem connect;
    JMenuItem reconnect;

    public MenuBar(){
        URL menu_url = getClass().getResource("menu.jpg");
        URL menubck_url = getClass().getResource("MENU_BACKGROUND.png");
        JMenu menu = new JMenu("Menu");
        BufferedImage menuImage, menuBckImage;
        BufferedImage resizeMenuImg = null, resizeMenuBckImg = null;
        Graphics2D g1 = null;
        try{
            menuImage = ImageIO.read(menu_url);
            menuBckImage = ImageIO.read(menubck_url);
            resizeMenuImg= new BufferedImage(30, 20, BufferedImage.TYPE_INT_ARGB);
            resizeMenuBckImg= new BufferedImage(30, 20, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = setGraphics(resizeMenuImg,menuImage);
            g1 = setGraphics(resizeMenuBckImg, menuBckImage);

        }catch (IOException e){
            menuImage = null;
        }
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setIcon(new ImageIcon(resizeMenuImg));
        menu.setMnemonic(KeyEvent.VK_M);
        launchServer = new JMenuItem("Launch Server"){
            private Image  i= new ImageIcon(getClass().getResource("MENU_BACKGROUND.png")).getImage() ;

            @Override
            public void paintComponents(Graphics g) {
                g.drawImage(i, 20, 20, this);
                super.paintComponent(g);
            }

            @Override
            public void setMnemonic(int mnemonic) {
                super.setMnemonic(KeyEvent.VK_L);
            }
        };
        launchServer.setAccelerator(KeyStroke.getKeyStroke("control L"));
        launchServer.setBorder(new BorderUIResource.MatteBorderUIResource(new ImageIcon(resizeMenuBckImg)));
        launchServer.setOpaque(false);
        menu.add(launchServer);
        menu.add(new JPopupMenu.Separator());
        JMenu connectMenu = new JMenu("Connect");
        connectMenu.setBorder(new BorderUIResource.MatteBorderUIResource(new ImageIcon(resizeMenuBckImg)));
        connect = new JMenuItem("Connect");
        reconnect = new JMenuItem("Reconnect");
        connectMenu.add(connect);
        connectMenu.add(reconnect);
        menu.add(connectMenu);
        launchServer.addActionListener(this);
        connect.addActionListener(this);
        reconnect.addActionListener(this);

        add(menu);
    }

    public Graphics2D setGraphics(BufferedImage resizeImg, BufferedImage menuImage){
        Graphics2D g2 = resizeImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(menuImage, 0, 0, 30, 24, null);
        g2.dispose();
        return g2;
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension size = this.getSize();
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("MENU_BACKGROUND.png")), 0, 0, size.width, size.height, this);
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
