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
public class AnalogPanel extends JPanel{
    protected JLabel xPinLabel;
    protected JTextField xPinTextField;
    protected JLabel yPinLabel;
    protected JTextField yPinTextField;
    protected JLabel dPinLabel;
    protected JTextField dPinTextField;
    protected Button xReadButton;
    protected Button yReadButton;
    protected Button dReadButton;
    protected int xPinNumber = -1;
    protected int yPinNumber = -1;
    protected int dPinNumber = -1;
    protected FocusChanger focusChanger;
    protected String path;
    protected InputParser inputParser;
    
    //Initialize components and layout parameters
    public AnalogPanel(String path){
        xPinLabel = new JLabel("X Pin");
        xPinTextField = new JTextField("");
        yPinLabel = new JLabel("Y Pin");
        yPinTextField = new JTextField("");
        dPinLabel = new JLabel("D Pin");
        dPinTextField = new JTextField("");
        xReadButton = new Button("X Read");
        yReadButton = new Button("Y Read");
        dReadButton = new Button("D Read");
        this.path = path;
        inputParser = new InputParser();
        focusChanger = new FocusChanger(path);
        
        //GridLayout manager        
        setLayout(new GridLayout(6,2));
        
        //Border Manager        
        setBorder(BorderFactory.createTitledBorder("Analog Joystick"));
        
        //Add action listeners
        xPinTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int temp = Integer.parseInt(xPinTextField.getText());
                if(temp >= 0 && temp <= 13){
                    xPinNumber = temp;
                    focusChanger.changeWindow();
                    inputParser.type("pinMode(A" + xPinNumber + ", INPUT_PULLUP);\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "alert", "Please enter a number 0-5", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        yPinTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int temp = Integer.parseInt(yPinTextField.getText());
                if(temp >= 0 && temp <= 13){
                    yPinNumber = temp;
                    focusChanger.changeWindow();
                    inputParser.type("pinMode(A" + yPinNumber + ", INPUT_PULLUP);\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "alert", "Please enter a number 0-5", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        dPinTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int temp = Integer.parseInt(dPinTextField.getText());
                if(temp >= 0 && temp <= 13){
                    dPinNumber = temp;
                    focusChanger.changeWindow();
                    inputParser.type("pinMode(" + dPinNumber + ", INPUT_PULLUP);\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "alert", "Please enter a number 0-13", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        xReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(xPinNumber >= 0 && xPinNumber <= 13){
                    focusChanger.changeWindow();
                    inputParser.type("analogRead(A" + xPinNumber + ");\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a pin number 0-5 and press enter", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        yReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(yPinNumber >= 0 && yPinNumber <= 13){
                    focusChanger.changeWindow();
                    inputParser.type("analogRead(A" + yPinNumber + ");\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a pin number 0-5 and press enter", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        dReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(dPinNumber >= 0 && dPinNumber <= 13){
                    focusChanger.changeWindow();
                    inputParser.type("digitalRead(" + dPinNumber + ");\n");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a pin number 0-13 and press enter", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Add components to panel        
        add(xPinLabel);
        add(xPinTextField);
        add(yPinLabel);
        add(yPinTextField);
        add(dPinLabel);
        add(dPinTextField);
        add(xReadButton);
        add(yReadButton);
        add(dReadButton);
    }
}
