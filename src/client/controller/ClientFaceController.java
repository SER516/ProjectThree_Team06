package client.controller;

import java.io.File;
import java.io.IOException;
import client.model.ExpressiveData;
import constants.ClientConstants;
import javax.swing.JOptionPane;

/**
 *
 */
public class ClientFaceController {
	/**
	 *
	 * @param expressivedata
	 * @return
	 */
	public String getFaceFileName(ExpressiveData expressivedata) {
		StringBuilder fileName = new StringBuilder();
		fileName.append(expressivedata.getRaiseBrow() < 0.5 ? "0" : "1");
		fileName.append(expressivedata.getFurrowBrow() < 0.5 ? "0" : "1");
		fileName.append(expressivedata.getSmile() < 0.5 ? "0" : "1");
		fileName.append(expressivedata.getClench() < 0.5 ? "0" : "1");
		fileName.append(expressivedata.getSmirkLeft() < 0.5 ? "0" : "1");
		fileName.append(expressivedata.getSmirkRight() < 0.5 ? "0" : "1");
		fileName.append(expressivedata.getLaugh() < 0.5 ? "0" : "1");
		fileName.append(expressivedata.isBlink() ? "1" : "0");
		fileName.append(expressivedata.isWinkLeft() ? "1" : "0");
		fileName.append(expressivedata.isWinkRight() ? "1" : "0");
		fileName.append(expressivedata.isLookLeft() ? "1" : "0");
		fileName.append(expressivedata.isLookRight() ? "1" : "0");
		StringBuilder finalFileName = new StringBuilder();
		try {
			finalFileName.append(new java.io.File(".").getCanonicalPath());
			finalFileName.append(File.separator);
			finalFileName.append(ClientConstants.IMAGES);
			finalFileName.append(File.separator);
			finalFileName.append(fileName);
			finalFileName.append(ClientConstants.PNG);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ClientConstants.ADDING_IMAGE_EXCEPTION);
		}
		return finalFileName.toString();
	}
}
