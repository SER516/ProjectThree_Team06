package client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * EmotivePanel class is a emotive tab on the GUI
 *
 * @author Abhishek
 */
public class EmotivePanel extends JPanel {
    public static final String TABNAME = "Emotive";
    JPanel facePart;
    JPanel graphPart;
    JScrollBar vBar ;
    JScrollPane vPane;

    public EmotivePanel(){
        vBar = new JScrollBar(JScrollBar.VERTICAL,10,20,0,50);

        class MyAdjustmentListener implements AdjustmentListener {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                repaint();
            }
        }
        vBar.addAdjustmentListener(new MyAdjustmentListener());

        setLayout(new BorderLayout());
        Dimension df = this.getSize();
        facePart = new FaceExpressions();
        graphPart = new ExpressionPlots();
        facePart.setBackground(Color.LIGHT_GRAY);
        graphPart.setBackground(Color.WHITE);
        graphPart.setSize(this.getWidth(),this.getHeight()*2);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.3);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        splitPane.add(facePart);
        splitPane.add(graphPart);
        add(splitPane, BorderLayout.CENTER);

        //vPane = new JScrollPane(this, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(vBar, BorderLayout.EAST);
    }
}
