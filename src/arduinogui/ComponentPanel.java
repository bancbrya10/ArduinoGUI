/*
 * This class is the main menu of the Arduino GUI in which the user can select
 * the component they wish to implement
 */
package arduinogui;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Bryan
 */
public class ComponentPanel extends JPanel{
    protected Button buttonButton;
    protected Button ledButton;
    protected Button analogButton;
    protected Button buzzerButton;
    protected Button tempButton;
    protected Button helpButton;
    protected JLabel pathLabel;
    protected JTextField pathTextField;
    
    //Constructor to initialize components and set layout parameters
    public ComponentPanel(){
        buttonButton = new Button("Button");
        ledButton = new Button("LED");
        analogButton = new Button("Analog Stick");
        buzzerButton = new Button("Buzzer");
        tempButton = new Button("Temperature Sensor");
        helpButton = new Button("Help");
        pathLabel = new JLabel("Path");
        pathTextField = new JTextField();
        
        //GridLayout manager
        setLayout(new GridLayout(8,1));
        
        //BorderLayout manager
        setBorder(BorderFactory.createTitledBorder("Choose Component"));
        
        //Add Components to the panel
        add(buttonButton);
        add(ledButton);
        add(analogButton);
        add(buzzerButton);
        add(tempButton);
        add(helpButton);
        add(pathLabel);
        add(pathTextField);
    }
}
