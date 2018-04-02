package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;

import client.listener.ConnectionListener;

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
    private ConnectionListener connectionListener;

    public MenuBar(){
        URL menu_url = getClass().getResource("MENU_BACKGROUND.png");
        URL menuBack_url = getClass().getResource("BlackBackground.jpg");
        JMenu menu = new JMenu("Menu");
        BufferedImage menuImage, menuBorder;
        BufferedImage resizeMenuImg = null, resizeMBorder = null;
        try{
            menuImage = ImageIO.read(menu_url);
            menuBorder = ImageIO.read(menuBack_url);
            resizeMenuImg= new BufferedImage(30, 20, BufferedImage.TYPE_INT_ARGB);
            resizeMBorder = new BufferedImage(20, 10, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = setGraphics(resizeMenuImg,menuImage);
            Graphics2D g1 = setGraphics(resizeMBorder, menuBorder);
        }catch (IOException e) {
            System.out.println("Please specify image path");
        }
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setIcon(new ImageIcon(resizeMenuImg));
        menu.setMnemonic(KeyEvent.VK_M);
        launchServer = new JMenuItem("Launch Server");
        launchServer.setMnemonic(KeyEvent.VK_L);
        launchServer.setAccelerator(KeyStroke.getKeyStroke("control L"));
        launchServer.setBorder(new BorderUIResource.MatteBorderUIResource(new ImageIcon(resizeMBorder)));
        launchServer.setOpaque(true);
        launchServer.setBackground(Color.BLACK);
        launchServer.setForeground(Color.WHITE);

        JMenu connectMenu = new JMenu("Connect");
        connectMenu.setOpaque(true);
        connectMenu.setBackground(Color.BLACK);
        connectMenu.setForeground(Color.WHITE);
        connectMenu.setBorder(new BorderUIResource.MatteBorderUIResource(new ImageIcon(resizeMBorder)));
        connect = new JMenuItem("Connect");
        reconnect = new JMenuItem("Reconnect");
        connect.setOpaque(true);
        connect.setForeground(Color.WHITE);
        connect.setBackground(Color.BLACK);
        connect.setBorder(new BorderUIResource.MatteBorderUIResource(new ImageIcon(resizeMBorder)));
        reconnect.setOpaque(true);
        reconnect.setForeground(Color.WHITE);
        reconnect.setBackground(Color.BLACK);
        reconnect.setBorder(new BorderUIResource.MatteBorderUIResource(new ImageIcon(resizeMBorder)));
        connectMenu.add(connect);
        connectMenu.add(new JPopupMenu.Separator());
        connectMenu.add(reconnect);

        launchServer.addActionListener(this);
        connect.addActionListener(this);
        reconnect.addActionListener(this);
        menu.add(launchServer);
        menu.add(new JPopupMenu.Separator());
        menu.add(connectMenu);
        menu.setOpaque(true);
        menu.setBackground(Color.BLACK);
        menu.setForeground(Color.WHITE);
        add(menu);
    }
    
    public void setConnectionListener(ConnectionListener connectionListener) {
    		this.connectionListener = connectionListener;
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
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("BlackBackground.jpg")), 0,
                0, size.width, size.height, this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == launchServer)
        {
            // Server Launching code
        }
        else if (e.getSource() == connect)
        {
            if(connectionListener!=null) {
            		connectionListener.startServer();
            }
        }
        else if (e.getSource() == reconnect)
        {
        		connectionListener.reconnectServer(null);
        }
    }

}
