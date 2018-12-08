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
public class TempPanel extends JPanel{
    protected JLabel pinLabel;
    protected JTextField pinTextField;
    protected JLabel delayLabel;
    protected JTextField delayTextField;
    
    //Initialize components and layout parameters        
    public TempPanel(){
        pinLabel = new JLabel("Pin");
        pinTextField = new JTextField();
        delayLabel = new JLabel("Delay");
        delayTextField = new JTextField();
        
        //GridLayout manager
        setLayout(new GridLayout(2,2));
        
        //Border Manager
        setBorder(BorderFactory.createTitledBorder("LED"));
        
        //Add components to panel
        add(pinLabel);
        add(pinTextField);
        add(delayLabel);
        add(delayTextField);
    }
}
