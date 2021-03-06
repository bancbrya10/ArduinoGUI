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
public class ArduinoGui extends JFrame{

    private ComponentPanel componentPanel;
    private Button backButton;
    public static String path;
    
    public ArduinoGui(){
        componentPanel = new ComponentPanel();
        backButton = new Button("Back");
        
        //Add action listeners to the component panel buttons
        componentPanel.buttonButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(path != null){
                    String path = ArduinoGui.path;
                    getContentPane().removeAll();
                    repaint();
                    add(new ButtonPanel(path), BorderLayout.NORTH);
                    add(backButton, BorderLayout.SOUTH);
                    getContentPane().revalidate();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please specify a path and press enter", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        componentPanel.ledButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String path = ArduinoGui.path;
                getContentPane().removeAll();
                repaint();
                add(new LEDPanel(path), BorderLayout.NORTH);
                add(backButton, BorderLayout.SOUTH);
                getContentPane().revalidate();
            }
        });
        
        componentPanel.analogButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String path = ArduinoGui.path;
                getContentPane().removeAll();
                repaint();
                add(new AnalogPanel(path), BorderLayout.NORTH);
                add(backButton, BorderLayout.SOUTH);
                getContentPane().revalidate();
            }
        });
        
        componentPanel.buzzerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String path = ArduinoGui.path;
                getContentPane().removeAll();
                repaint();
                add(new BuzzerPanel(path), BorderLayout.NORTH);
                add(backButton, BorderLayout.SOUTH);
                getContentPane().revalidate();
            }
        });
        
        componentPanel.tempButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String path = ArduinoGui.path;
                getContentPane().removeAll();
                repaint();
                add(new TempPanel(path), BorderLayout.NORTH);
                add(backButton, BorderLayout.SOUTH);
                getContentPane().revalidate();
            }
        });
        
        componentPanel.helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String path = ArduinoGui.path;
                getContentPane().removeAll();
                repaint();
                add(new HelpPanel(path), BorderLayout.NORTH);
                add(backButton, BorderLayout.SOUTH);
                getContentPane().revalidate();
            }
        });
        
        componentPanel.pathTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                path = componentPanel.pathTextField.getText();
                componentPanel.path = componentPanel.pathTextField.getText();
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getContentPane().removeAll();
                repaint();
                add(componentPanel);
                getContentPane().revalidate();
            }
        });
        
        //Add component panel everytime gui is instantiated
        add(componentPanel, BorderLayout.CENTER);
    }
    
    //Main method to set general gui attributes
    public static void main(String[] args) {
        ArduinoGui gui = new ArduinoGui();
        gui.setSize(250,300);
        gui.setVisible(true);
        gui.setResizable(true);
        gui.setTitle("Arduino GUI");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
