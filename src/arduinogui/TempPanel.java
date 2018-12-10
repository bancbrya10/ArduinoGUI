/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class TempPanel extends JPanel{
    protected JLabel pinLabel;
    protected JTextField pinTextField;
    protected Button celciusButton;
    protected Button fahrenheitButton;
    protected JLabel delayLabel;
    protected JTextField delayTextField;
    protected FocusChanger focusChanger;
    protected String path;
    protected int pinNumber = -1;
    protected InputParser inputParser;
    
    //Initialize components and layout parameters        
    public TempPanel(String path){
        pinLabel = new JLabel("Pin");
        pinTextField = new JTextField();
        celciusButton = new Button("Celcius");
        fahrenheitButton = new Button("Fahrenheit");
        delayLabel = new JLabel("Delay");
        delayTextField = new JTextField();
        this.path = path;
        inputParser = new InputParser();
        focusChanger = new FocusChanger(path);
        
        //GridLayout manager
        setLayout(new GridLayout(3,2));
        
        //Border Manager
        setBorder(BorderFactory.createTitledBorder("Temperature Sensor"));
        
        //Add action listeners
        pinTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int temp = Integer.parseInt(pinTextField.getText());
                if(temp >= 0 && temp <= 5){
                    pinNumber = temp;
                    focusChanger.changeWindow();
                    inputParser.type("pinMode(" + pinNumber + ", INPUT_PULLUP);\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "alert", "Please enter a number 0-5", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        celciusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                focusChanger.changeWindow();
                inputParser.type("float temperature;\n" +
                    "// read the input on analog pin " + pinNumber + ":\n" +
                    "float sensorValue = analogRead(A" + pinNumber + ");\n" +
                    "// the celcius value is now stored in temperature\n" +
                    "temperature = (sensorValue/1023)*powervoltage*100;\n");
            }
        });
        
        fahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                focusChanger.changeWindow();
                inputParser.type("float temperature;\n" +
                    "// read the input on analog pin " + pinNumber + ":\n" +
                    "float sensorValue = analogRead(A" + pinNumber + ");\n" +
                    "// the celcius value is now stored in temperature\n" +
                    "temperature = (sensorValue/1023)*powervoltage*100;\n" +
                    "// convert the celcius value to fahrenheit\n" +
                    "temperature = (temperature * (9/5)) + 32");
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
        add(celciusButton);
        add(fahrenheitButton);
        add(delayLabel);
        add(delayTextField);
    }
}
