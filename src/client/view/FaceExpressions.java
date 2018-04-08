package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FaceExpressions extends JPanel{

	private BufferedImage image;

    public FaceExpressions(String fileName) {
    	add(new JLabel("Face Expression", JLabel.CENTER), BorderLayout.NORTH);
    	setBackground(new Color(175, 175, 175));
       try {   
    	   StringBuilder current = new StringBuilder(new java.io.File( "." ).getCanonicalPath());
           System.out.println("Current dir:"+current);
           current.append("\\Images\\");
           current.append(fileName);
          image = ImageIO.read(new File(current.toString()));
       } catch (IOException ex) {
            System.out.println("Exception in Adding IMage: ");
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 25, 50, 250, 350, this);           
    }
}
