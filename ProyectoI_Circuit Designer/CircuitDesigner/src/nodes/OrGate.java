/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;


/**
 *
 * @author Emanuel
 */
public class OrGate extends LogicGate {
    
    Image imageOR;
    
    public OrGate(){
        
    }
    
    @Override
    public Image getImage() {
       System.out.println("Entre OR");
       try{
            imageOR = new Image(new FileInputStream("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\ProyectoI_Circuit Designer\\CircuitDesigner\\src\\images\\OR.png"));
                
        } catch(FileNotFoundException ex){
            System.out.println("Error imagen no encontrada");
        }
        System.out.println(imageOR);
        return imageOR;
    }


    
}
