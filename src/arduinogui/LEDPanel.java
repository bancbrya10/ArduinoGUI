/*
 * This class will be used to provide the user with options regarding LEDs
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
public class LEDPanel extends JPanel{
    protected JLabel pinLabel;
    protected JTextField pinTextField;
    protected Button highButton;
    protected Button lowButton;
    protected JLabel delayLabel;
    protected JTextField delayTextField;
    protected FocusChanger focusChanger;
    protected String path;
    protected int pinNumber = -1;
    protected InputParser inputParser;
    
    
    //Initialize components and layout parameters
    public LEDPanel(String path){
        pinLabel = new JLabel("Pin");
        pinTextField = new JTextField();
        highButton = new Button("High");
        lowButton = new Button("Low");
        delayLabel = new JLabel("Delay");
        delayTextField = new JTextField();
        inputParser = new InputParser();
        this.path = path;
        focusChanger = new FocusChanger(path);
        
        //GridLayout manager
        setLayout(new GridLayout(3,2));
        
        //Border Manager
        setBorder(BorderFactory.createTitledBorder("LED"));
        
        //Add action listeners
        pinTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int temp = Integer.parseInt(pinTextField.getText());
                if(temp >= 0 && temp <= 13){
                    pinNumber = temp;
                    focusChanger.changeWindow();
                    inputParser.type("pinMode(" + pinNumber + ", OUTPUT);\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "alert", "Please enter a number 0-13", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        highButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(pinNumber >= 0 && pinNumber <= 13){
                    focusChanger.changeWindow();
                    inputParser.type("digitalWrite(" + pinNumber + ", HIGH);\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a pin number and press enter", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        lowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(pinNumber >= 0 && pinNumber <= 13){
                    focusChanger.changeWindow();
                    inputParser.type("digitalWrite(" + pinNumber + ", LOW);\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a pin number and press enter", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        delayTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                focusChanger.changeWindow();
                inputParser.type("delay(" + delayTextField.getText() + ");\n");
            }
        });
        
        //Add components to panel
        add(pinLabel);
        add(pinTextField);
        add(highButton);
        add(lowButton);
        add(delayLabel);
        add(delayTextField);
    }
}
