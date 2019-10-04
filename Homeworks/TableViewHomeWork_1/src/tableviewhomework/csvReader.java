
package tableviewhomework;

import excepciones.ArchivoVacio;
import excepciones.FormatoCSV;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class csvReader extends Exception{
    private final String delimeter;
    private final String file;
    private String dataString = "";
    
    public csvReader(String delimeter, String file){
        this.delimeter = delimeter;
        this.file = file;
    }
    
    public ArrayList<String> MRows_Colums() throws ArchivoVacio, FormatoCSV, FileNotFoundException, IOException{
            
            ArrayList<String> result = new ArrayList<>();
            int countRows = 0;
            int countColums = 0;
            
            //Lectura de la primer fia del archivo para determinar el número de columnas que deben contener todas las demás
            //con el fin de verificar que el archivo cumple o no con el estandar .csv
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine();
            if ("".equals(firstLine)){
                throw new ArchivoVacio();
            }
            String[] firstColum = firstLine.split(delimeter, -1);
            
            //Con la lectura completa de todo el archivo seleccionado, se determinan la cantidad de filas y columnas 
            //y se crea un solo String que contendrá todo el archivo en una sola línea.
            try {
                br = new BufferedReader(new FileReader(file));
                String line;
                while((line = br.readLine()) != null){
                    countRows++;
                    String[] colums = line.split(delimeter, -1);
                    dataString += line + ",";
                    countColums = colums.length;
                    
                    if (countColums != firstColum.length){
                        throw new FormatoCSV();
                    }
                }
            }catch (FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            }catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Archivo invalido");
            }
            
            String N_ROWS = String.valueOf(countRows -1);
            String N_COLUMS = String.valueOf(countColums);
            result.add(dataString);
            result.add(N_ROWS);
            result.add(N_COLUMS);
            System.out.println(result);
            
            return result; 
    }
}
