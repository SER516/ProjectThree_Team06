package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class AffectivePanel extends JPanel{
    public static final String TABNAME = "Affectiva";

    public static void main(String[] args) {
        new AffectivePanel();
    }

    public AffectivePanel(){
        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(950, 890);
        this.setLayout(new BorderLayout());*/
       

        //JPanel container = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        
       
        //set up jpanel 1
        panelOne.setLayout(new BorderLayout());
        panelOne.setBackground(new Color(253, 235, 208));
        panelOne.add(new JLabel("Graph Plot",JLabel.CENTER),BorderLayout.NORTH);
        
        
        //set up jpanel2
        Color[] colors = {new Color(236, 112, 99  ), new Color(93, 173, 226), 
                          new Color(88, 214, 141), new Color(235, 152, 78 ),
                          new Color(255, 102, 255)};
        
        String[] strings= {"Red","Blue", "Green","Orange","Pink"};
        
        panelTwo.setLayout(new BorderLayout());
        panelTwo.setBackground(new Color(169, 204, 227));
        panelTwo.add(new JLabel("Performance Metrics", JLabel.CENTER), BorderLayout.NORTH);
        
        JPanel panelTwo_center= new JPanel(new GridLayout(5, 1));
        //panelTwo_center.setBackground(new Color(169, 204, 227));
        
        //add Meditation 
        JPanel panel_meditation = new JPanel();
        //panel_meditation.setBackground(new Color(189, 195, 199));
        JLabel meditation = new JLabel("Meditation");
        panel_meditation.add(meditation);
        JComboBox combo_meditation = new JComboBox(strings);
        ComboBoxRenderer renderer_meditation = new ComboBoxRenderer(combo_meditation);
        renderer_meditation.setColors(colors);
        renderer_meditation.setStrings(strings);
        combo_meditation.setRenderer(renderer_meditation);
        panel_meditation.add(combo_meditation);
        panelTwo_center.add(panel_meditation);
        
        
      //add Frustration
        JPanel panel_frustration = new JPanel();
       // panel_frustration.setBackground(new Color(148, 148, 184));
        JLabel label_frustration= new JLabel("Frustration");
        panel_frustration.add(label_frustration);
        JComboBox combo_frustration= new JComboBox(strings);
        ComboBoxRenderer renderer_frustration = new ComboBoxRenderer(combo_frustration);
        renderer_frustration.setColors(colors);
        renderer_frustration.setStrings(strings);
        combo_frustration.setRenderer(renderer_frustration);
        panel_frustration.add(combo_frustration);
        panelTwo_center.add(panel_frustration);
        
        
        //add Engagement Boredom
        JPanel panel_boredom = new JPanel();
        JLabel boredom= new JLabel("Engagement Boredom");
       // panel_boredom.setBackground(new Color(148, 148, 184));
        panel_boredom.add(boredom);
        JComboBox combo_boredom= new JComboBox(strings);
        ComboBoxRenderer renderer_boredom = new ComboBoxRenderer(combo_boredom);
        renderer_boredom.setColors(colors);
        renderer_boredom.setStrings(strings);
        combo_boredom.setRenderer(renderer_boredom);
        panel_boredom.add(combo_boredom);
        panelTwo_center.add(panel_boredom);
        panelTwo_center.add(panel_boredom);
        
        //add Excitement shortTerm
        JPanel panel_excitementshort = new JPanel();
        //panel_excitementshort.setBackground(new Color(189, 195, 199));
        JLabel label_excitementshort= new JLabel("Excitement ShortTerm");
        panel_excitementshort.add(label_excitementshort);
        JComboBox combo_excitementshort= new JComboBox(strings);
        ComboBoxRenderer renderer_excitementshort = new ComboBoxRenderer(combo_excitementshort);
        renderer_excitementshort.setColors(colors);
        renderer_excitementshort.setStrings(strings);
        combo_excitementshort.setRenderer(renderer_excitementshort);
        panel_excitementshort.add(combo_excitementshort);
        panelTwo_center.add(panel_excitementshort);
        panelTwo_center.add(panel_excitementshort);
        
      
        
       
      //add Excitement Longterm
        JPanel panel_excitementlong = new JPanel();
       // panel_excitementlong.setBackground(new Color(189, 195, 199));
        JLabel label_excitementlong = new JLabel("Excitement Longterm");
        panel_excitementlong.add(label_excitementlong);
        JComboBox combo_excitementlong= new JComboBox(strings);
        ComboBoxRenderer renderer_excitementlong = new ComboBoxRenderer(combo_excitementlong);
        renderer_excitementlong.setColors(colors);
        renderer_excitementlong.setStrings(strings);
        combo_excitementlong.setRenderer(renderer_excitementlong);
        panel_excitementlong.add(combo_excitementlong);
        panelTwo_center.add(panel_excitementlong);
        
        panelTwo_center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      
        panelTwo.add(panelTwo_center,BorderLayout.CENTER);

        /*container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(panelOne);
        container.add(panelTwo);*/
        
        setLayout(new BorderLayout());
        add(panelOne,BorderLayout.CENTER);
        add(panelTwo,BorderLayout.EAST);

        /*this.add(container);
        this.setVisible(true);*/
    }

 }




class ComboBoxRenderer extends JPanel implements ListCellRenderer
{

    private static final long serialVersionUID = -1L;
    private Color[] colors;
    private String[] strings;

    JPanel textPanel;
    JLabel text;

    public ComboBoxRenderer(JComboBox combo) {

        textPanel = new JPanel();
        textPanel.add(this);
        text = new JLabel();
        text.setOpaque(true);
        text.setFont(combo.getFont());
        textPanel.add(text);
    }

    public void setColors(Color[] col)
    {
        colors = col;
    }

    public void setStrings(String[] str)
    {
        strings = str;
    }

    public Color[] getColors()
    {
        return colors;
    }

    public String[] getStrings()
    {
        return strings;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        if (isSelected)
        {
            setBackground(list.getSelectionBackground());
        }
        else
        {
            setBackground(Color.WHITE);
        }

        if (colors.length != strings.length)
        {
            System.out.println("colors.length does not equal strings.length");
            return this;
        }
        else if (colors == null)
        {
            System.out.println("use setColors first.");
            return this;
        }
        else if (strings == null)
        {
            System.out.println("use setStrings first.");
            return this;
        }

        text.setBackground(getBackground());

        text.setText(value.toString());
        if (index>-1) {
            text.setForeground(colors[index]);
        }
        return text;
    }
}
