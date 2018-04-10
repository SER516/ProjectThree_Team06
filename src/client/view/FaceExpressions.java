package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import constants.ClientConstants;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 */
public class FaceExpressions extends JPanel {

	private BufferedImage image;

	public FaceExpressions() {
		String fileName = "000000000000.png";
		setBackground(new Color(175, 175, 175));
		try {
			StringBuilder finalFileName = new StringBuilder(new java.io.File(".").getCanonicalPath());
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
			JOptionPane.showMessageDialog(null, ClientConstants.DRAW_IMAGE_EXCEPTION);
		}
	}
}
