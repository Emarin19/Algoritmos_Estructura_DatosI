/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Emanuel
 */
public class AndGate extends LogicGate {
    Image imageAND;
    public AndGate() {
       
    }

    @Override
    public Image getImage() {
            System.out.println("Entre AND");
        try{
            imageAND = new Image(new FileInputStream("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\ProyectoI_Circuit Designer\\CircuitDesigner\\src\\images\\AND.png"));
                
        } catch(FileNotFoundException ex){
            System.out.println("Error imagen no encontrada");
        }
        System.out.println("IMAGEN AND: " + imageAND);
        return imageAND;
    }
    
}
