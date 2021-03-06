/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinogui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Bryan
 */
public class FocusChanger {
    String id;
    String path;
    
    public FocusChanger(String path){
        this.path = path;
        
        id = parseId();
    }
    
    //Opens cmdow and parses the id of the Arduino IDE application for future use
    private String parseId(){
        try {
            String id = "";
            if(path.charAt(path.length() - 1) != '\\'){
                path+="\\";
            }
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(path + "cmdow /t");
            process.waitFor();
            BufferedReader reader = 
            new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";	
            while((line = reader.readLine()) != null){
                if(line.contains("| Arduino 1.6.12")){
                    id = line.substring(0, 8);
                }
            }
            return id;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    //Returns the id of the Arduino IDE
    public String getId(){
        return id;
    }
    
    //Uses the id obtained from the parseId method to open the Arduino IDE window
    public void changeWindow(){
        try {
            if(path.charAt(path.length() - 1) != '\\'){
                path+="\\";
            }
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(path + "cmdow " + id + " /act /res");
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
