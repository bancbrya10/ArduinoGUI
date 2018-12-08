/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinogui;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class InputParser {
    String input;
    //Robot robot;
    
    public InputParser(String input){
        this.input = input;
        
        /*
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(InputParser.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "alert", "Your system configuration does not allow low level input control.", JOptionPane.ERROR_MESSAGE);
        }
        catch(SecurityException ex){
            Logger.getLogger(InputParser.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "alert", "Robot permission is not granted.", JOptionPane.ERROR_MESSAGE);
        }
        */
    }
}
