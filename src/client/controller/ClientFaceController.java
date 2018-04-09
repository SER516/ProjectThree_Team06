package client.controller;

import java.io.IOException;
import client.model.ExpressiveData;
import javax.swing.*;

public class ClientFaceController {

	 public String getFaceFileName(ExpressiveData expressivedata){
		 	StringBuilder fileName = new StringBuilder();
		 	JPanel facePanel = new JPanel();
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
		 	System.out.println("FileName: "+fileName);
		 	StringBuilder finalFileName = new StringBuilder();
			 try {   
				 finalFileName.append(new java.io.File( "." ).getCanonicalPath());
				 finalFileName.append("\\Images\\");
				 finalFileName.append(fileName);
				 finalFileName.append(".png");
				 System.out.print(finalFileName);
		        } catch (IOException ex) {
		             System.out.println("Exception in Adding IMage: ");
		        }
			
			return finalFileName.toString();
		 
	 }
}
