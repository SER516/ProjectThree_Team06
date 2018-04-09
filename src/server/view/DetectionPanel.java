/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.view;

/**
 * @author mspranav
 * <p>
 * Creates new form DetectionPanel
 */


/**
 * Creates new form DetectionPanel
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import server.services.DetectionListenerService;
import server.services.InteractiveListenerService;


public class DetectionPanel extends JPanel implements ChangeListener, ActionListener {

    JTextField timeTxtField;
    JComboBox<String> upperfaceComboBox;
    JSpinner upperfaceSpinner;
    JComboBox<String> lowerfaceComboBox;
    JComboBox<String> eyeComboBox;
    JCheckBox eyeAutoResetCheckBox;
    JCheckBox activateCheckBox;
    JRadioButton eyeActivateRadioButton;
    JComboBox<String> performanceMetricsComboBox;
    JSpinner performanceMetricsSpinner;
    DetectionListenerService detectionListenerService;
    JSpinner lowerfaceSpinner;

    public DetectionPanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(new TitledBorder(null, "Detection", TitledBorder.LEADING,
                TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), null));
        this.setBounds(11, 130, 474, 267);
        this.setLayout(null);

        JLabel lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTime.setForeground(Color.WHITE);
        lblTime.setBounds(14, 24, 41, 33);
        this.add(lblTime);

        timeTxtField = new JTextField();
        timeTxtField.setForeground(Color.WHITE);
        timeTxtField.setBackground(Color.DARK_GRAY);
        timeTxtField.setEditable(false);
        timeTxtField.setText("0");
        timeTxtField.setBounds(53, 29, 50, 25);
        this.add(timeTxtField);
        timeTxtField.setColumns(10);

        JLabel lblSeconds = new JLabel("Seconds");
        lblSeconds.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSeconds.setForeground(Color.WHITE);
        lblSeconds.setBounds(113, 24, 64, 33);
        this.add(lblSeconds);

        JLabel lblUpperface = new JLabel("Upperface:");
        lblUpperface.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblUpperface.setForeground(Color.WHITE);
        lblUpperface.setBounds(14, 68, 139, 33);
        this.add(lblUpperface);


        String[] upperfaceItems = new String[]{"Raise Brow", "Furrow Brow"};
        upperfaceComboBox = new JComboBox<>(upperfaceItems);
        upperfaceComboBox.setBounds(14, 98, 139, 25);
        upperfaceComboBox.addActionListener(this);
        this.add(upperfaceComboBox);

        upperfaceSpinner = new JSpinner();
        upperfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        upperfaceSpinner.setBackground(Color.WHITE);
        upperfaceSpinner.setBounds(161, 97, 55, 25);
        upperfaceSpinner.addChangeListener(this);
        this.add(upperfaceSpinner);

        JLabel lblLowerface = new JLabel("Lowerface:");
        lblLowerface.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLowerface.setForeground(Color.WHITE);
        lblLowerface.setBounds(250, 68, 139, 33);
        this.add(lblLowerface);

        String[] lowerfaceItems = new String[]{"Laugh", "Clench", "Smirk Left",
                "Smirk Right", "Smile"};
        lowerfaceComboBox = new JComboBox<>(lowerfaceItems);
        lowerfaceComboBox.setBounds(250, 98, 123, 25);
        lowerfaceComboBox.addActionListener(this);
        this.add(lowerfaceComboBox);

        lowerfaceSpinner = new JSpinner();
        lowerfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        lowerfaceSpinner.setForeground(Color.WHITE);
        lowerfaceSpinner.setBounds(383, 97, 52, 25);
        lowerfaceSpinner.addChangeListener(this);
        this.add(lowerfaceSpinner);

        JLabel lblEye = new JLabel("Eye:");
        lblEye.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEye.setForeground(Color.WHITE);
        lblEye.setBounds(14, 134, 115, 33);
        this.add(lblEye);

        String[] eyeItems = new String[]{"Blink", "Wink Left",
                "Wink Right", "Look Left", "Look Right"};
        eyeComboBox = new JComboBox<>(eyeItems);
        eyeComboBox.setBounds(14, 163, 139, 25);
        eyeComboBox.addActionListener(this);
        this.add(eyeComboBox);

        eyeActivateRadioButton = new JRadioButton("Activate");
        eyeActivateRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        eyeActivateRadioButton.setBackground(Color.GRAY);
        eyeActivateRadioButton.setForeground(Color.WHITE);
        eyeActivateRadioButton.setBounds(185, 164, 95, 25);
        eyeActivateRadioButton.addActionListener(this);
        this.add(eyeActivateRadioButton);

        eyeAutoResetCheckBox = new JCheckBox("Auto Reset");
        eyeAutoResetCheckBox.setForeground(Color.WHITE);
        eyeAutoResetCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        eyeAutoResetCheckBox.setBackground(Color.GRAY);
        eyeAutoResetCheckBox.setBounds(294, 164, 95, 25);
        eyeAutoResetCheckBox.addActionListener(this);
        eyeAutoResetCheckBox.addActionListener(this);
        this.add(eyeAutoResetCheckBox);

        JLabel lblPerformanceMetrics = new JLabel("Performance Metrics:");
        lblPerformanceMetrics.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPerformanceMetrics.setForeground(Color.WHITE);
        lblPerformanceMetrics.setBounds(14, 199, 131, 33);
        this.add(lblPerformanceMetrics);

        String[] pfMetricItems = new String[]{"Interest", "Engagement",
                "Stress", "Relaxation", "Excitement", "Focus"};
        performanceMetricsComboBox = new JComboBox<>(pfMetricItems);
        performanceMetricsComboBox.setBounds(14, 229, 139, 25);
        performanceMetricsComboBox.addActionListener(this);
        this.add(performanceMetricsComboBox);

        performanceMetricsSpinner = new JSpinner();
        performanceMetricsSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        performanceMetricsSpinner.setBounds(161, 229, 55, 25);
        performanceMetricsSpinner.addChangeListener(this);
        this.add(performanceMetricsSpinner);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void changeClockCounter(double counter) {
        timeTxtField.setText(String.valueOf(counter));
    }

    public void setDetectionListenerService(DetectionListenerService detectionListenerService) {
        this.detectionListenerService = detectionListenerService;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == lowerfaceSpinner) {
            float lowerfaceValue = (float) ((double) lowerfaceSpinner.getValue());
            String lowerfaceExp = (String) lowerfaceComboBox.getSelectedItem();
            detectionListenerService.changeLowerface(lowerfaceExp, lowerfaceValue);
        } else if (e.getSource() == upperfaceSpinner) {
            float upperfaceValue = (float) ((double) upperfaceSpinner.getValue());
            String upperfaceExp = (String) upperfaceComboBox.getSelectedItem();
            detectionListenerService.changeUpperface(upperfaceExp, upperfaceValue);
        } else if (e.getSource() == performanceMetricsSpinner) {
            float metricsValue = (float) ((double) performanceMetricsSpinner.getValue());
            String metricsExp = (String) performanceMetricsComboBox.getSelectedItem();
            detectionListenerService.changePerformanceMatrics(metricsExp, metricsValue);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == upperfaceComboBox) {
            float upperfaceValue = (float) ((double) upperfaceSpinner.getValue());
            String upperfaceExp = (String) upperfaceComboBox.getSelectedItem();
            detectionListenerService.changeUpperface(upperfaceExp, upperfaceValue);
        } else if (e.getSource() == lowerfaceComboBox) {
            float lowerfaceValue = (float) ((double) lowerfaceSpinner.getValue());
            String lowerfaceExp = (String) lowerfaceComboBox.getSelectedItem();
            detectionListenerService.changeLowerface(lowerfaceExp, lowerfaceValue);
        } else if (e.getSource() == performanceMetricsComboBox) {
            float metricsValue = (float) ((double) performanceMetricsSpinner.getValue());
            String metricsExp = (String) performanceMetricsComboBox.getSelectedItem();
            detectionListenerService.changePerformanceMatrics(metricsExp, metricsValue);
        } else if (e.getSource() == eyeComboBox) {
            String eye = (String) eyeComboBox.getSelectedItem();
            if (eyeActivateRadioButton.isSelected()) {
                detectionListenerService.changeEye(eye);
            }

        } else if (e.getSource() == eyeActivateRadioButton) {
            String eye = (String) eyeComboBox.getSelectedItem();
            if (eyeActivateRadioButton.isSelected()) {
                detectionListenerService.changeEye(eye);
            }
        } else if (e.getSource() == eyeAutoResetCheckBox) {
            if (eyeAutoResetCheckBox.isSelected()) {
                detectionListenerService.setEyeAutoResetCheckBox(true);
            }
        }
    }

    public void disableActive() {
        eyeActivateRadioButton.setSelected(false);
        eyeAutoResetCheckBox.setSelected(false);
    }
}
