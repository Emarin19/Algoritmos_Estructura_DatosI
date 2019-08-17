
package filewriterexamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriterExamples {
    
    private static FileWriter fileWriter;
    private static ArrayList<String> nameList = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try{
            fileWriter = new FileWriter("C:\\Users\\Emanuel\\Desktop\\FirstFile.txt");
            fileWriter.write("Amanda");
            fileWriter.write("\nEmanuel");
            fileWriter.write("\nCinthya");
            fileWriter.write("\nDiego");
            fileWriter.close();
        } catch(Exception e){
            System.out.println("MISTAKE");
            System.out.println(e);
        }
        System.out.println("Success");
        
        
        try{
            FileReader fileReader = new FileReader(new File("C:\\Users\\Emanuel\\Desktop\\FirstFile.txt"));
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while((line = br.readLine())!= null){
                nameList.add(line);
                System.out.println(line);
                
            }
        } catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        } catch(IOException e){
            System.out.println("Error de entrada o salida de datos");
        }
        
        System.out.println("");
        System.out.println("Lectura de los elementos almacenados en la lista");
        for(String row: nameList){
            System.out.println(row);
        }
    }
    
}
