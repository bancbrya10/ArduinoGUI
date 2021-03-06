/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinogui;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Bryan
 */
public class HelpPanel extends JPanel{
    protected JTextArea helpInfo;
    protected String path;
    
    //Initialize component and layout parameters
    public HelpPanel(String path){
        helpInfo = new JTextArea("To use this GUI, first open the Arduino IDE."
                + " Then, from the main menu (which is reached by pressing the Back "
                + "button below) you will select the component you are working with."
                + " From there, place the cursor where you would like the text to be written"
                + " and select the option you would like to implement in your script."
                + " For any GUI components that involve a text box (Pin number/Delay),"
                + " press enter when the desired value is entered in the box."
                + " \n\nNOTE: CMDOW must be installed on your computer to use this application."
                + " To install visit https://ritchielawrence.github.io/cmdow/ and copy"
                + " the path name to add to the path field. Be sure to press enter after pasting"
                + " the path name into the field to save the path name to the gui.");
        this.path = path;
        
        //Configure textArea settings
        helpInfo.setLineWrap(true);
        helpInfo.setWrapStyleWord(true);
        helpInfo.setAutoscrolls(true);
        helpInfo.setEditable(false);
        helpInfo.setSize(new Dimension(200,300));
        
        //Border manager
        setBorder(BorderFactory.createTitledBorder("Help"));
        
        //Add component to panel
        add(helpInfo);
    }
}
