/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.view;

/**
 *
 * @author mspranav
 * @author rishabmantri
 */


    /**
     * Creates new form DetectionPanel
     */
    
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import server.model.ServerDataSingleton;



public class DetectionPanel extends JPanel{
	
	JTextField timeTxtField;
	JComboBox<String> UpperfaceComboBox;
	JSpinner upperfaceSpinner;
	JComboBox<String> LowerfaceComboBox;
	JComboBox<String> EyeComboBox;
	JCheckBox EyeAutoResetCheckBox;
	JCheckBox ActivateCheckBox;
    JRadioButton EyeActivateRadioButton;
	JComboBox<String> PerformanceMetricsComboBox;
	JSpinner PerformanceMetricsSpinner;
	
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
        
        String[] upperfaceItems = new String[] {"Raise Brow", "Furrow Brow"};
        UpperfaceComboBox = new JComboBox<>(upperfaceItems);
        UpperfaceComboBox.setBounds(14, 98, 139, 25);
        this.add(UpperfaceComboBox);
        
        upperfaceSpinner = new JSpinner();
        upperfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        upperfaceSpinner.setBackground(Color.WHITE);
        upperfaceSpinner.setBounds(161, 97, 55, 25);
        this.add(upperfaceSpinner);
        
        JLabel lblLowerface = new JLabel("Lowerface:");
        lblLowerface.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLowerface.setForeground(Color.WHITE);
        lblLowerface.setBounds(250, 68, 139, 33);
        this.add(lblLowerface);
        
        String[] lowerfaceItems = new String[] {"Smile", "Clench","Smirk Left",
                                                "Smirk Right","Laugh"};
        LowerfaceComboBox = new JComboBox<>(lowerfaceItems);
        LowerfaceComboBox.setBounds(250, 98, 123, 25);
        this.add(LowerfaceComboBox);
        
        JSpinner lowerfaceSpinner = new JSpinner();
        lowerfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        lowerfaceSpinner.setForeground(Color.WHITE);
        lowerfaceSpinner.setBounds(383, 97, 52, 25);
        this.add(lowerfaceSpinner);
        
        JLabel lblEye = new JLabel("Eye:");
        lblEye.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEye.setForeground(Color.WHITE);
        lblEye.setBounds(14, 134, 115, 33);
        this.add(lblEye);
        
        String[] eyeItems = new String[] {"Blink", "Wink Left", 
                                            "Wink Right","Look Left","Look Right"};
        EyeComboBox = new JComboBox<>(eyeItems);
        EyeComboBox.setBounds(14, 163, 139, 25);
        this.add(EyeComboBox);
        
        EyeActivateRadioButton = new JRadioButton("Activate");
        EyeActivateRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        EyeActivateRadioButton.setBackground(Color.GRAY);
        EyeActivateRadioButton.setForeground(Color.WHITE);
        EyeActivateRadioButton.setBounds(185, 164, 95, 25);
        this.add(EyeActivateRadioButton);
        
        EyeAutoResetCheckBox = new JCheckBox("Auto Reset");
        EyeAutoResetCheckBox.setForeground(Color.WHITE);
        EyeAutoResetCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        EyeAutoResetCheckBox.setBackground(Color.GRAY);
        EyeAutoResetCheckBox.setBounds(294, 164, 95, 25);
        this.add(EyeAutoResetCheckBox);
        
        JLabel lblPerformanceMetrics = new JLabel("Performance Metrics:");
        lblPerformanceMetrics.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPerformanceMetrics.setForeground(Color.WHITE);
        lblPerformanceMetrics.setBounds(14, 199, 131, 33);
        this.add(lblPerformanceMetrics);
        
        String[] pfMetricItems = new String[] {"Meditation", "Engagement Boredom", 
                                                "Excitement ShortTerm","Frustration","Excitement LongTerm"};
        
        PerformanceMetricsComboBox = new JComboBox<>(pfMetricItems);
        PerformanceMetricsComboBox.setBounds(14, 229, 139, 25);
        this.add(PerformanceMetricsComboBox);
        
        PerformanceMetricsSpinner = new JSpinner();
        PerformanceMetricsSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        PerformanceMetricsSpinner.setBounds(161, 229, 55, 25);
        this.add(PerformanceMetricsSpinner);
        
        upperfaceSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float upperfaceValue = (float)((double) upperfaceSpinner.getValue());
                String upperfaceExp = (String)UpperfaceComboBox.getSelectedItem();
                if(upperfaceExp=="Raise Brow")
                {
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(upperfaceValue);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(0);
                }
                if(upperfaceExp=="Furrow Brow")
                {
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(upperfaceValue);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(0);
                }

            }
        });
         
        UpperfaceComboBox.addActionListener(
                 new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                 float upperfaceValue = (float)((double) upperfaceSpinner.getValue());
                 String upperfaceExp = (String)UpperfaceComboBox.getSelectedItem();
                 if(upperfaceExp=="Raise Brow")
                 {
                	 ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(upperfaceValue);
                     ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(0);
                 }
                 if(upperfaceExp=="Furrow Brow")
                 {
                	 ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(upperfaceValue);
                     ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(0);
                 }
            }
         });
   
        lowerfaceSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float lowerfaceValue = (float)((double) lowerfaceSpinner.getValue());
                String lowerfaceExp = (String)LowerfaceComboBox.getSelectedItem();
                if(lowerfaceExp=="Smile")
                {
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(lowerfaceValue);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
                }
                if( lowerfaceExp=="Clench")
                {
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(lowerfaceValue);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
                }
                if(lowerfaceExp=="Smirk Left")
                {
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(lowerfaceValue);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
                }
                if(lowerfaceExp=="Smirk Right")
                {
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(lowerfaceValue);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
                }
                if(lowerfaceExp=="Laugh")
                {
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
                    ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(lowerfaceValue);
                 }

            }
        });

        LowerfaceComboBox.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        float lowerfaceValue = (float)((double) lowerfaceSpinner.getValue());
                        String lowerfaceExp = (String)LowerfaceComboBox.getSelectedItem();
                        if(lowerfaceExp=="Smile")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(lowerfaceValue);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
                        }
                        if(lowerfaceExp=="Clench")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(lowerfaceValue);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
                        }
                        if(lowerfaceExp=="Smirk Left")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(lowerfaceValue);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
                        }
                        if(lowerfaceExp=="Smirk Right")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(lowerfaceValue);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
                        }
                        if(lowerfaceExp=="Laugh")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
                            ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(lowerfaceValue);
                         }
                        
                    }
                }
        );
        
        
        PerformanceMetricsSpinner.addChangeListener(new ChangeListener() {
        	@Override
            public void stateChanged(ChangeEvent e) {
                float performanceMetricsValue = (float)((double) PerformanceMetricsSpinner.getValue());
                String performanceMetricsExp = (String)PerformanceMetricsComboBox.getSelectedItem();
                if(performanceMetricsExp=="Meditation")
                {
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(performanceMetricsValue);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                }
                if(performanceMetricsExp=="Engagement Boredom")
                {
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(performanceMetricsValue);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                }
                if(performanceMetricsExp=="Excitement ShortTerm")
                {
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(performanceMetricsValue);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                }
                if(performanceMetricsExp=="Frustration")
                {
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(performanceMetricsValue);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                }
                if(performanceMetricsExp=="Excitement LongTerm")
                {
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(0);
                    ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(performanceMetricsValue);
                }
                
            }
        });

        PerformanceMetricsComboBox.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        float performanceMetricsValue = (float)((double) PerformanceMetricsSpinner.getValue());
                        String performanceMetricsExp = (String)PerformanceMetricsComboBox.getSelectedItem();
                        if(performanceMetricsExp=="Meditation")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(performanceMetricsValue);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                        }
                        if(performanceMetricsExp=="Engagement Boredom")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(performanceMetricsValue);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                        }
                        if(performanceMetricsExp=="Excitement ShortTerm")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(performanceMetricsValue);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                        }
                        if(performanceMetricsExp=="Frustration")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(performanceMetricsValue);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                        }
                        if(performanceMetricsExp=="Excitement LongTerm")
                        {
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setMeditation(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setEngagementBoredom(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setFrustation(0);
                            ServerDataSingleton.getInstance().getFaceData().getAffectiveData().setExcitementShortTerm(performanceMetricsValue);
                        }
                    }
                }
        );
        
        ActionListener eyeListener = new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
                  String eye = (String)EyeComboBox.getSelectedItem();
                  if(EyeActivateRadioButton.isSelected())
                  {
                  	if(eye=="Blink")
                  	{
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setBlink(true);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(false);
                  	}
                  	if(eye=="Wink Left")
                  	{
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setBlink(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(true);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(false);
                  	}
                  	if(eye=="Wink Right")
                  	{
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setBlink(true);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(true);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(false);
                  	}
                  	if(eye=="Look Left")
                  	{
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setBlink(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(true);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(false);
                  	}
                  	if(eye=="Look Right")
                  	{
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setBlink(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(false);
                      ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(true);
                  	}
                  }
                  else
                  { 
                  	ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setBlink(false);
                  	ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(false);
                  	ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(false);
                  	ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(false);
                  	ServerDataSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(false);
                  }
        	  }
        	};

        EyeActivateRadioButton.addActionListener(eyeListener);
        EyeComboBox.addActionListener(eyeListener);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
