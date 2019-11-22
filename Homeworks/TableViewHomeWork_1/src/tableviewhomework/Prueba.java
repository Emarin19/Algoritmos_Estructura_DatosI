/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewhomework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel
 */
public class Prueba {
    private final String delimiter;
    private final File file;
    
    public Prueba(String delimiter, File file){
        this.delimiter = delimiter;
        this.file = file;
    }
    
    public void reading(File file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine();
            System.out.println(firstLine);
            String line = null;
            while((line = br.readLine()) != null){
                String[] words = line.split(delimiter);
                for(int i=0; i<words.length; i++){
                    System.out.println(words[i]);
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex){
            System.out.println("Error de lectura");
        }
    }
    
}
