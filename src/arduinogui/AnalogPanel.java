/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinogui;

import javax.swing.*;
import java.awt.*;
import java.awt.Robot;

/**
 *
 * @author Bryan
 */
public class AnalogPanel extends JPanel{
    protected JLabel xPinLabel;
    protected JTextField xPinTextField;
    protected JLabel yPinLabel;
    protected JTextField yPinTextField;
    protected JLabel dPinLabel;
    protected JTextField dPinTextField;
    protected Button xHighButton;
    protected Button yHighButton;
    protected Button dHighButton;
    protected Button xLowButton;
    protected Button yLowButton;
    protected Button dLowButton;
    
    //Initialize components and layout parameters
    public AnalogPanel(){
        xPinLabel = new JLabel("X Pin");
        xPinTextField = new JTextField("");
        yPinLabel = new JLabel("Y Pin");
        yPinTextField = new JTextField("");
        dPinLabel = new JLabel("D Pin");
        dPinTextField = new JTextField("");
        xHighButton = new Button("X High");
        yHighButton = new Button("Y High");
        dHighButton = new Button("D High");
        xLowButton = new Button("X Low");
        yLowButton = new Button("Y Low");
        dLowButton = new Button("D Low");
        
        //GridLayout manager        
        setLayout(new GridLayout(6,2));
        
        //Border Manager        
        setBorder(BorderFactory.createTitledBorder("Analog Joystick"));
        
        //Add components to panel        
        add(xPinLabel);
        add(xPinTextField);
        add(yPinLabel);
        add(yPinTextField);
        add(dPinLabel);
        add(dPinTextField);
        add(xHighButton);
        add(yHighButton);
        add(dHighButton);
        add(xLowButton);
        add(yLowButton);
        add(dLowButton);
    }
}
