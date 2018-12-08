/*
 * This class will be used to provide the user with options regarding LEDs
 */
package arduinogui;

import javax.swing.*;
import java.awt.*;
import java.awt.Robot;

/**
 *
 * @author Bryan
 */
public class LEDPanel extends JPanel{
    protected JLabel pinLabel;
    protected JTextField pinTextField;
    protected Button highButton;
    protected Button lowButton;
    protected JLabel delayLabel;
    protected JTextField delayTextField;
    
    //Initialize components and layout parameters
    public LEDPanel(){
        pinLabel = new JLabel("Pin");
        pinTextField = new JTextField();
        highButton = new Button("High");
        lowButton = new Button("Low");
        delayLabel = new JLabel("Delay");
        delayTextField = new JTextField();
        
        //GridLayout manager
        setLayout(new GridLayout(3,2));
        
        //Border Manager
        setBorder(BorderFactory.createTitledBorder("LED"));
        
        //Add components to panel
        add(pinLabel);
        add(pinTextField);
        add(highButton);
        add(lowButton);
        add(delayLabel);
        add(delayTextField);
    }
}
