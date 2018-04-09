package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FaceExpressions extends JPanel{

	private BufferedImage image;
    public FaceExpressions() {
    	String fileName = "000000000000.png";
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

    public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
    @Override
    protected void paintComponent(Graphics g) {
    	setBackground(new Color(175, 175, 175));
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 250, 350, this);           
    }

    public void drawImage(String fileName) {
    	BufferedImage image;
		try {
			image = ImageIO.read(new File(fileName.toString()));
	    	this.setImage(image);
	    	this.removeAll();
	    	this.repaint();
	    	this.revalidate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
