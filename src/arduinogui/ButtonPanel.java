/*
 * This class will provide the user with options regarding a button
 */
package arduinogui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bryan
 */
public class ButtonPanel extends JPanel{
    protected JLabel pinLabel;
    protected JTextField pinTextField;
    protected Button checkButton;
    protected InputParser inputParser;
    protected int pinNumber;
    protected FocusChanger focusChanger;
    protected String path;
    
    //Initialize components and layout parameters
    public ButtonPanel(String path){
        pinLabel = new JLabel("Pin Number");
        pinTextField = new JTextField();
        checkButton = new Button("Check Status");
        inputParser = new InputParser();
        this.path = path;
        focusChanger = new FocusChanger(path);
        
        //GridLayout manager
        setLayout(new GridLayout(2,2));
        
        //Border Manager
        setBorder(BorderFactory.createTitledBorder("Button"));
        
        //Add action listeners
        pinTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int temp = Integer.parseInt(pinTextField.getText());
                if(temp >= 0 && temp <= 13){
                    pinNumber = temp;
                    focusChanger.changeWindow();
                    inputParser.type("pinMode(" + pinNumber + ", INPUT_PULLUP);\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a number 0-13", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(pinNumber >= 0 && pinNumber <= 13){
                    focusChanger.changeWindow();
                    inputParser.type("if(digitalRead(" + pinNumber + "){\n"
                            + "\n"
                            + "}\n"
                            + "else{\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a pin number and press enter", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Add components to panel
        add(pinLabel);
        add(pinTextField);
        add(checkButton);
    }
}
