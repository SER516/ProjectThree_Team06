package client.view;

import javax.swing.*;
import java.awt.*;

/**
 * EmotivePanel class is a emotive tab on the GUI
 *
 * @author Abhishek
 */
public class EmotivePanel extends JPanel {
    public static final String TABNAME = "Emotive";
    JPanel facePart;
    JPanel graphPart;

    public EmotivePanel(){
        setLayout(new BorderLayout());
        Dimension df = this.getSize();
        facePart = new FaceExpressions();
        graphPart = new ExpressionPlots();
        facePart.setBackground(Color.LIGHT_GRAY);
        graphPart.setBackground(Color.WHITE);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.3);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        splitPane.add(facePart);
        splitPane.add(graphPart);
        add(splitPane, BorderLayout.CENTER);
    }
}
