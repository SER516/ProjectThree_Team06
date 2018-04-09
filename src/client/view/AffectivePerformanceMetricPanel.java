package client.view;

import client.model.SingleTonData;
import client.services.AffectiveColorService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.Component;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;

/**
 * This is part of AffectivePanel UI. This panel has performance metrics.
 *
 * @author avinash
 */

class AffectivePerformanceMetricPanel extends JPanel implements ActionListener, DocumentListener {

    AffectiveColorService affectiveColorService;
    JButton btnFocus;
    JButton btnStress;
    JButton btnInterest;
    JButton btnEngagement;
    JButton btnRelaxation;
    JButton btnExcitement;
    JPanel focusColorDisplay;
    JPanel stressColorDisplay;
    JPanel interestColorDisplay;
    JPanel engagementColorDisplay;
    JPanel relaxationColorDisplay;
    JPanel excitementColorDisplay;
    JPanel panel7;
    JTextField displayLength;
    private ArrayList<Color> colors = new ArrayList<>();

    public AffectivePerformanceMetricPanel() {
        BuildPanel();
    }

    public JPanel BuildPanel() {

        // set up PerformanceMetricPanel
        Font metric_font = new Font("Papyrus", Font.BOLD, 13);
        setLayout(new BorderLayout());
        setBackground(new Color(169, 204, 227));
        JLabel performanceMetricHead = new JLabel("Performance Metrics", JLabel.CENTER);
        performanceMetricHead.setFont(new Font("Papyrus", Font.BOLD, 15));
        add(performanceMetricHead, BorderLayout.NORTH);

        JPanel performanceMetricBody = new JPanel(new GridLayout(4, 2));
        performanceMetricBody.setBackground(new Color(220, 220, 220));


        // add Focus.
        focusColorDisplay = new JPanel();
        Color defaultColorFocus = new Color(255, 99, 71);
        colors.add(defaultColorFocus);
        focusColorDisplay.setBackground(defaultColorFocus);

        btnFocus = new JButton("Focus");
        btnFocus.setFont(metric_font);
        btnFocus.setPreferredSize(new Dimension(110, 50));
        btnFocus.addActionListener(this);
        focusColorDisplay.add(btnFocus);
        performanceMetricBody.add(focusColorDisplay);

        // add Stress
        stressColorDisplay = new JPanel();
        Color defaultColorStress = new Color(128, 191, 255);
        colors.add(defaultColorStress);
        stressColorDisplay.setBackground(defaultColorStress);
        btnStress = new JButton("Stress");
        btnStress.setFont(metric_font);
        btnStress.setPreferredSize(new Dimension(110, 50));
        btnStress.addActionListener(this);
        stressColorDisplay.add(btnStress);
        performanceMetricBody.add(stressColorDisplay);

        // add interest
        interestColorDisplay = new JPanel();
        Color defaultColorInterest = new Color(204, 204, 255);
        colors.add(defaultColorInterest);
        interestColorDisplay.setBackground(defaultColorInterest);

        btnInterest = new JButton("Interest");
        btnInterest.setFont(metric_font);
        btnInterest.setPreferredSize(new Dimension(110, 50));
        btnInterest.addActionListener(this);
        interestColorDisplay.add(btnInterest);
        performanceMetricBody.add(interestColorDisplay);

        // add Engagement
        engagementColorDisplay = new JPanel();
        Color defaultColorEngagement = new Color(77, 255, 166);
        colors.add(defaultColorEngagement);
        engagementColorDisplay.setBackground(defaultColorEngagement);
        // panel_excitementshort.setBackground(new Color(189, 195, 199));
        btnEngagement = new JButton("Engagement");
        btnEngagement.setFont(metric_font);
        btnEngagement.setPreferredSize(new Dimension(135, 50));
        btnEngagement.addActionListener(this);
        engagementColorDisplay.add(btnEngagement);
        performanceMetricBody.add(engagementColorDisplay);

        // add Relaxation
        relaxationColorDisplay = new JPanel();
        Color defaultColorRelaxation = new Color(184, 102, 20);
        colors.add(defaultColorRelaxation);
        relaxationColorDisplay.setBackground(defaultColorRelaxation);
        btnRelaxation = new JButton("Relaxation");
        btnRelaxation.setFont(metric_font);
        btnRelaxation.setPreferredSize(new Dimension(120, 50));
        btnRelaxation.addActionListener(this);
        relaxationColorDisplay.add(btnRelaxation);
        performanceMetricBody.add(relaxationColorDisplay);

        // add Excitement
        excitementColorDisplay = new JPanel();
        Color defaultColorExcitement = new Color(255, 255, 102);
        colors.add(defaultColorExcitement);
        excitementColorDisplay.setBackground(defaultColorExcitement);
        // panel_excitementlong.setBackground(new Color(189, 195, 199));
        btnExcitement = new JButton("Excitement");
        btnExcitement.setFont(metric_font);
        btnExcitement.setPreferredSize(new Dimension(120, 50));
        btnExcitement.addActionListener(this);
        excitementColorDisplay.add(btnExcitement);
        performanceMetricBody.add(excitementColorDisplay);

        // add the display length of x axis.
        JPanel panel7 = new JPanel(new GridBagLayout());
        panel7.setBackground(new Color(220, 220, 220));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        JLabel DisplayLength = new JLabel("Display Length  ");
        DisplayLength.setFont(new Font("Papyrus", Font.BOLD, 15));
        panel7.add(DisplayLength, c);
        c.gridx = 1;
        c.gridy = 0;


//		NumberFormat format = NumberFormat.getInstance();
//		NumberFormatter formatter = new NumberFormatter(format);
//		formatter.setValueClass(Integer.class);
//		formatter.setMinimum(0);
//		formatter.setMaximum(Integer.MAX_VALUE);
//		formatter.setAllowsInvalid(false);
        displayLength = new JTextField(10);
        displayLength.setText(String.valueOf(50));
        displayLength.getDocument().addDocumentListener(this);


        panel7.add(displayLength, c);
        performanceMetricBody.add(panel7);

        performanceMetricBody.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        performanceMetricBody.setBorder(BorderFactory.createEtchedBorder());
        add(performanceMetricBody, BorderLayout.CENTER);

        return this;

    }

    public void setAffectiveListener(AffectiveColorService affectiveColorService) {
        this.affectiveColorService = affectiveColorService;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnFocus) {
            setColor(focusColorDisplay, 0);

        } else if (e.getSource() == btnStress) {
            setColor(stressColorDisplay, 1);
        } else if (e.getSource() == btnInterest) {
            setColor(interestColorDisplay, 2);
        } else if (e.getSource() == btnEngagement) {
            setColor(engagementColorDisplay, 3);
        } else if (e.getSource() == btnRelaxation) {
            setColor(relaxationColorDisplay, 4);
        } else if (e.getSource() == btnExcitement) {
            setColor(excitementColorDisplay, 5);
        }

    }


    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    private void setColor(JPanel panel, int index) {
        Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
        if (newColor == null) {
            return;
        } else {
            panel.setBackground(newColor);
            colors.set(index, newColor);
        }


    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        affectiveColorService.changeDisplayLength(displayLength.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        affectiveColorService.changeDisplayLength(displayLength.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        affectiveColorService.changeDisplayLength(displayLength.getText());
    }
}
