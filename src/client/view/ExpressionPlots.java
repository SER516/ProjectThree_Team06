package client.view;

import javax.swing.*;
import java.awt.*;

/**
 * ExpressionPlots class plots the graph of expressions received from server
 *
 * @author Abhishek
 */
public class ExpressionPlots extends JPanel {
    JLabel expression1 = new JLabel("Expression: 1");
    JLabel expression2 = new JLabel("Expression: 2");
    JLabel expression3 = new JLabel("Expression: 3");
    JLabel expression4 = new JLabel("Expression: 4");
    JLabel expression5 = new JLabel("Expression: 5");
    JLabel expression6 = new JLabel("Expression: 6");
    JLabel expression7 = new JLabel("Expression: 7");
    JLabel expression8 = new JLabel("Expression: 8");
    JLabel expression9 = new JLabel("Expression: 9");
    JLabel expression10 = new JLabel("Expression: 10");
    JLabel expression11 = new JLabel("Expression: 11");
    JLabel expression12 = new JLabel("Expression: 12");
    public ExpressionPlots(){
        setLayout(new GridLayout(3,4,1,1));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
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
