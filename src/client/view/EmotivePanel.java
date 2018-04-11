package client.view;

import javax.swing.*;
import client.model.ClientDataSingleton;
import java.awt.*;

/**
 * EmotivePanel class is a emotive tab on the GUI.
 *
 * @author Abhishek
 */
public class EmotivePanel extends JPanel {
	public static final String TABNAME = "Expressive";
	FaceExpressions faceExpressions;
	ExpressionPlots expressionPlots;

	public EmotivePanel() {
		setLayout(new BorderLayout());
		faceExpressions = new FaceExpressions();
		expressionPlots = new ExpressionPlots();
		ClientDataSingleton.getInstance().setExpressplot(expressionPlots);
		ClientDataSingleton.getInstance().setFaceExpressions(faceExpressions);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setResizeWeight(0.3);
		splitPane.setEnabled(false);
		splitPane.setDividerSize(0);
		splitPane.add(faceExpressions);
		splitPane.add(expressionPlots);
		add(splitPane, BorderLayout.CENTER);
	}
}
