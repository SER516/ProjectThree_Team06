package client.view;

import javax.swing.*;
import java.awt.*;

/**
 * ExpressionPlots class plots the graph of expressions received from server
 *
 * @author Abhishek
 */
public class ExpressionPlots extends JPanel {
    JLabel expression1 = new JLabel("Raise Brow");
    JLabel expression2 = new JLabel("Furrow Brow");
    JLabel expression3 = new JLabel("Smile");
    JLabel expression4 = new JLabel("Clench");
    JLabel expression5 = new JLabel("Smirk Left");
    JLabel expression6 = new JLabel("Smirk Right");
    JLabel expression7 = new JLabel("Laugh");
    JLabel expression8 = new JLabel("Blink");
    JLabel expression9 = new JLabel("Wink Left");
    JLabel expression10 = new JLabel("Wink Right");
    JLabel expression11 = new JLabel("Look Left");
    JLabel expression12 = new JLabel("Look right");
    public ExpressionPlots(){
        setLayout(new GridLayout(12,1,1,1));
        //setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(new Color(253, 235, 208));
        //add(new JLabel("Graph", JLabel.CENTER), BorderLayout.NORTH);
        add(expression1);
        add(expression2);
        add(expression3);
        add(expression4);
        add(expression5);
        add(expression6);
        add(expression7);
        add(expression8);
        add(expression9);
        add(expression10);
        add(expression11);
        add(expression12);
    }
}
