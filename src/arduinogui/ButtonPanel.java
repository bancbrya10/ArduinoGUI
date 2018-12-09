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
    protected Button checkButton;
    protected InputParser inputParser;
    private int pinNumber;
    
    //Initialize components and layout parameters
    public ButtonPanel(){
        pinLabel = new JLabel("Pin Number");
        pinTextField = new JTextField();
        checkButton = new Button("Check Status");
        inputParser = new InputParser();
        
        //GridLayout manager
        setLayout(new GridLayout(2,2));
        
        //Border Manager
        setBorder(BorderFactory.createTitledBorder("Button"));
        
        //Add action listeners
        pinTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(Integer.parseInt(pinTextField.getText()) >= 0 && Integer.parseInt(pinTextField.getText()) <= 13){
                    pinNumber = Integer.parseInt(pinTextField.getText());
                    inputParser.type("pinMode(" + pinNumber + ", INPUT_PULLUP);");
                }
                else{
                    JOptionPane.showMessageDialog(null, "alert", "Please enter a number 0-13", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(pinNumber >= 0 && pinNumber <= 13){
                    inputParser.type("if(digitalRead(" + pinNumber + "){\n"
                            + "\n"
                            + "}\n"
                            + "else{\n"
                            + "\n"
                            + "}");
                }
            }
        });
        
        //Add components to panel
        add(pinLabel);
        add(pinTextField);
        add(checkButton);
    }
}
