package client.view;

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
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


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
        buildPanel();
    }

    /**
     * This function builds a panel with 6 performance metrics.
     * They are Focus, Stress, Interest, Engagement, Relaxation.
     *
     * @return
     */

    public JPanel buildPanel() {

        // set up PerformanceMetricPanel
        Font metricFont = new Font("Papyrus", Font.BOLD, 13);
        setLayout(new BorderLayout());

        //new Color(..) is used for color or panel.
        setBackground(new Color(169, 204, 227));
        JLabel performanceMetricHead = new JLabel("Performance Metrics", JLabel.CENTER);
        performanceMetricHead.setFont(new Font("Papyrus", Font.BOLD, 15));
        add(performanceMetricHead, BorderLayout.NORTH);
        JPanel performanceMetricBody = new JPanel(new GridLayout(4, 2));
        performanceMetricBody.setBackground(new Color(220, 220, 220));


        // add Focus panel to performanceMetricBody panel.
        focusColorDisplay = new JPanel();
        Color defaultColorFocus = new Color(255, 99, 71);
        colors.add(defaultColorFocus);
        focusColorDisplay.setBackground(defaultColorFocus);
        btnFocus = new JButton("Focus");
        btnFocus.setFont(metricFont);
        btnFocus.setPreferredSize(new Dimension(110, 50));
        btnFocus.addActionListener(this);
        focusColorDisplay.add(btnFocus);
        performanceMetricBody.add(focusColorDisplay);

        // add Stress panel to performanceMetricBody panel.
        stressColorDisplay = new JPanel();
        Color defaultColorStress = new Color(128, 191, 255);
        colors.add(defaultColorStress);
        stressColorDisplay.setBackground(defaultColorStress);
        btnStress = new JButton("Stress");
        btnStress.setFont(metricFont);
        btnStress.setPreferredSize(new Dimension(110, 50));
        btnStress.addActionListener(this);
        stressColorDisplay.add(btnStress);
        performanceMetricBody.add(stressColorDisplay);

        // add Interest panel to performanceMetricBody panel.
        interestColorDisplay = new JPanel();
        Color defaultColorInterest = new Color(204, 204, 255);
        colors.add(defaultColorInterest);
        interestColorDisplay.setBackground(defaultColorInterest);
        btnInterest = new JButton("Interest");
        btnInterest.setFont(metricFont);
        btnInterest.setPreferredSize(new Dimension(110, 50));
        btnInterest.addActionListener(this);
        interestColorDisplay.add(btnInterest);
        performanceMetricBody.add(interestColorDisplay);

        // add Engagement panel to performanceMetricBody panel.
        engagementColorDisplay = new JPanel();
        Color defaultColorEngagement = new Color(77, 255, 166);
        colors.add(defaultColorEngagement);
        engagementColorDisplay.setBackground(defaultColorEngagement);
        btnEngagement = new JButton("Engagement");
        btnEngagement.setFont(metricFont);
        btnEngagement.setPreferredSize(new Dimension(135, 50));
        btnEngagement.addActionListener(this);
        engagementColorDisplay.add(btnEngagement);
        performanceMetricBody.add(engagementColorDisplay);

        // add Relaxation panel to performanceMetricBody panel.
        relaxationColorDisplay = new JPanel();
        Color defaultColorRelaxation = new Color(184, 102, 20);
        colors.add(defaultColorRelaxation);
        relaxationColorDisplay.setBackground(defaultColorRelaxation);
        btnRelaxation = new JButton("Relaxation");
        btnRelaxation.setFont(metricFont);
        btnRelaxation.setPreferredSize(new Dimension(120, 50));
        btnRelaxation.addActionListener(this);
        relaxationColorDisplay.add(btnRelaxation);
        performanceMetricBody.add(relaxationColorDisplay);

        // add Excitement panel to performanceMetricBody panel.
        excitementColorDisplay = new JPanel();
        Color defaultColorExcitement = new Color(255, 255, 102);
        colors.add(defaultColorExcitement);
        excitementColorDisplay.setBackground(defaultColorExcitement);
        btnExcitement = new JButton("Excitement");
        btnExcitement.setFont(metricFont);
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
        JLabel displayLengthLabel = new JLabel("Display Length  ");
        displayLengthLabel.setFont(new Font("Papyrus", Font.BOLD, 15));
        panel7.add(displayLengthLabel, c);
        c.gridx = 1;
        c.gridy = 0;
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
        affectiveColorService.changedisplayLengthLabel(displayLength.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        affectiveColorService.changedisplayLengthLabel(displayLength.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        affectiveColorService.changedisplayLengthLabel(displayLength.getText());
    }
}