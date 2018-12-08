/*
 * This class will provide the user with options regarding a button
 */
package arduinogui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Robot;

/**
 *
 * @author Bryan
 */
public class ButtonPanel extends JPanel{
    protected JLabel pinLabel;
    protected JTextField pinTextField;
    protected Button highButton;
    protected Button lowButton;
    
    //Initialize components and layout parameters
    public ButtonPanel(){
        pinLabel = new JLabel("Pin");
        pinTextField = new JTextField();
        highButton = new Button("High");
        lowButton = new Button("Low");
        
        //GridLayout manager
        setLayout(new GridLayout(2,2));
        
        //Border Manager
        setBorder(BorderFactory.createTitledBorder("Button"));
        
        //Add action listeners
        
        
        //Add components to panel
        add(pinLabel);
        add(pinTextField);
        add(highButton);
        add(lowButton);
    }
}