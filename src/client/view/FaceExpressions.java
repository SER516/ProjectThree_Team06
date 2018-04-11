package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import client.constants.ClientConstants;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The FaceExpressions class
 * 
 * @author Team06
 * @version 1.0
 */
public class FaceExpressions extends JPanel {

	private BufferedImage image;

	public FaceExpressions() {
		String fileName = "000000000000.png";
		setBackground(ClientConstants.GREY);
		try {
			StringBuilder finalFileName = new StringBuilder(
					new java.io.File(ClientConstants.CURRENT_DIR).getCanonicalPath());
			finalFileName.append(File.separator);
			finalFileName.append(ClientConstants.IMAGES);
			finalFileName.append(File.separator);
			finalFileName.append(fileName);
			image = ImageIO.read(new File(finalFileName.toString()));
		} catch (IOException ex) {
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * painComponent method configures the Panel
	 * @param g Graphics to be configured
	 */
	@Override
	protected void paintComponent(Graphics g) {
		setBackground(ClientConstants.GREY);
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 250, 350, this);
	}

	/**
	 * drawImage method sets image on the faceExpression panel
	 * @param fileName String name of file containing image
	 */
	public void drawImage(String fileName) {
		BufferedImage image;
		try {
			image = ImageIO.read(new File(fileName.toString()));
			this.setImage(image);
			this.removeAll();
			this.repaint();
			this.revalidate();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.DRAW_IMAGE_EXCEPTION_MESSAGE);
		}
	}
}