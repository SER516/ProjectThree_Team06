package client.view;

import javax.swing.*;

import client.model.SingleTonData;

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
        Dimension df = this.getSize();
        faceExpressions = new FaceExpressions();
        expressionPlots = new ExpressionPlots();
        SingleTonData.getInstance().setExpressplot(expressionPlots);
        SingleTonData.getInstance().setFaceExpressions(faceExpressions);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.3);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        splitPane.add(faceExpressions);
        splitPane.add(expressionPlots);
        add(splitPane, BorderLayout.CENTER);
    }
}
