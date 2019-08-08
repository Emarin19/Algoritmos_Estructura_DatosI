
package excepciones;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        /*int[] Lista = new int[5];
        Lista[0] = 10;
        Lista[1] = 15;
        Lista[2] = 20;
        Lista[3] = 25;
        Lista[4] = 30;
        
        for (int i=0; i<Lista.length; i++){
            System.out.println("Posicion " + i + ", valor: " + Lista[i]);
        }
        
        String name = JOptionPane.showInputDialog("Introduce nombre");
        System.out.println("Estimado " + name + ", la ejecucion del programa ha concluido");*/
        
        
        System.out.println("¿Qué deseas hacer?");
	System.out.println("1. Introducir datos");
	System.out.println("2. Salir del programa");
		
	Scanner entrada=new Scanner (System.in);
		
	int decision=entrada.nextInt();
		
	if (decision==1){
			
            pedirDatos();
			
	}
        else if(decision == 2){
			
            System.out.println("Adios");	
            System.exit(0);
	}
        else{
            System.out.println("Numero incorrecto");
        }
		
            entrada.close();
		
	}
        
        //Este metodo sin el try-catch antes lanzaba un excepcion perteneciente a la clase RuntimeException
        //para controlar dicha excepcion se lanzo opcionalmente un try-catch aunque tambien se pudo modificar el
        //codigo de manera que se prevea de otra tal excepcion.
	public static void pedirDatos() throws InputMismatchException  {			
	
        try{   
	Scanner entrada=new Scanner(System.in);
		
	System.out.println("Introduce tu nombre, por favor");
		
	String nombre_usuario=entrada.nextLine();
		
	System.out.println("Introduce edad, por favor");
		
	int edad=entrada.nextInt();	
			
	System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad+1) + " años");
        entrada.close();
        }catch (InputMismatchException e){
            System.out.println("Has introducido un valor erroneo");
        }	

	System.out.println("Hemos terminado");
		
    }  
    public static String getFile() throws IOException{
        return "Hola";
    }
    
}
