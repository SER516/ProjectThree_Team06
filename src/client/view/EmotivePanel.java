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
        //facePart.setSize(new Dimension((int)(df.getWidth()*0.3),df.height));
        facePart.setBackground(Color.BLUE);

        //graphPart.setSize(new Dimension((int)(df.getWidth()*0.7),df.height));

        graphPart.setBackground(Color.green);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.5);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);

        splitPane.add(facePart);
        splitPane.add(graphPart);
        add(splitPane, BorderLayout.CENTER);
    }
}
