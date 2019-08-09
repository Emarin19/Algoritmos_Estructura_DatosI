
package tarea1_datos_tableview;

import excepciones.ArchivoVacio;
import excepciones.FormatoCSV;

// JavaFX packages
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Java packages
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

// Exception packages
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


//Clase principal
public class Tarea1_Datos_TableView extends Application {
    
    //Variables de clase
    private static Stage window;
    private static int N_COLUMS = 0;
    private static int N_ROWS = 0;
    private static String DataString = "";
    private static String filePath;
    
    @Override
    public void start(Stage stage) throws Exception{
        
        window = stage;
        
        //Busqueda de archivo .csv
        try{
        filePath = fileSearch();
        } catch (NullPointerException exception){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Archivo no seleccionado");
            alert.showAndWait();
        }
   
        
        //Se verifica que el archivo seleccionado sea del formato .csv
        if (filePath.endsWith(".csv")){
            
            //Se instancia un objeto a la clase interna csvReader para definir el delimitador permitido y cargar el número de filas
            //y columnas del archivo seleccionado.
            csvReader fileReading = new csvReader(",", filePath);
            try{
                fileReading.MRows_Colums();
            }catch(ArchivoVacio exception){
                Alert alert = new Alert(AlertType.ERROR, exception.getMessage());
                alert.showAndWait();  
            }catch(FormatoCSV exception){
                Alert alert = new Alert(AlertType.ERROR, exception.getMessage());
                alert.showAndWait();
            }
            
            //Se instancia un onjeto a la clase interna TableCreation para crear las filas y columnas y agregar los datos
            //correspondiente a cada celda creada.
            TableCreation Table  = new TableCreation();
            TableView<ObservableList<String>> tableView = new TableView<>();
            
            //Se agregan las columnas a la Tabla
            List<String> columnNames = Table.getNext(N_COLUMS);
            
            for (int i = 0; i < columnNames.size(); i++) {
                final int finalIdx = i;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(
                    columnNames.get(i)
                );
                column.setCellValueFactory(param ->
                    new ReadOnlyObjectWrapper<>(param.getValue().get(finalIdx))
                );
                tableView.getColumns().add(column);
            }
            
            //Se agregan los datos correspondientes a cada celda de la Tabla previamente creada.
            for (int i = 0; i < N_ROWS; i++) {
                tableView.getItems().add(
                    FXCollections.observableArrayList(
                            Table.getNext(N_COLUMS)
                    )
                );
            }
            
            //Se establece un tamaño default de la tabla, este podrá cambiar dinámicamente
            tableView.setPrefHeight(400);
            
            //Creación de la escena para visualizar la tabla creada.
            Scene scene = new Scene(tableView);
            stage.setScene(scene);
            stage.setTitle("Table View");
            stage.show();
        }
        
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Has seleccionado un archivo incorrecto");
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static String fileSearch() throws NullPointerException {
        
        String filePath;
        FileChooser fileChooser = new FileChooser();
        File csvFile = fileChooser.showOpenDialog(window);
        filePath = csvFile.getAbsolutePath();
        if (filePath == null){
            throw new NullPointerException();
        }
        else{
            return filePath;
        }
    }
     
    
    //Clase interna para determinar del archivo .csv, la cantidad de filas y columnas
    //que este contendrá, además crea un String que concatena todas las filas del archivo
    //para poder ser leido enteramente y poder ser separado por el delimitador indicado en 
    //la instanciación de la clase.
    private static class csvReader extends Exception {
        
        private final String File;
        private final String Delimiter;
        
        public csvReader(String Delimiter, String File){
            this.Delimiter = Delimiter;
            this.File = File;
        }
        
        public String MRows_Colums() throws  FormatoCSV, ArchivoVacio, FileNotFoundException, IOException{
            BufferedReader br;
            int countRows = 0;
            int countColums = 0;
            
            
            //Lectura de la primer fia del archivo para determinar el número de columnas que deben contener todas las demás
            //con el fin de verificar que el archivo cumple o no con el estandar .csv
            br = new BufferedReader(new FileReader(File));
            String FirstLine = br.readLine();
            if ("".equals(FirstLine)){
                throw new ArchivoVacio();
            }
            String[] FirstColum = FirstLine.split(Delimiter, -1);
            
            //Con la lectura completa de todo el archivo seleccionado, se determinan la cantidad de filas y columnas 
            //y se crea un solo String que contendrá todo el archivo en una sola línea.
            try {
                br = new BufferedReader(new FileReader(File));
                String Line;
                while((Line = br.readLine()) != null){
                    countRows++;
                    String[] Colums = Line.split(Delimiter, -1);
                    DataString += Line + ",";
                    countColums = Colums.length;
                    
                    if (countColums != FirstColum.length){
                        throw new FormatoCSV();
                    }
                }
            }catch (FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            }catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Archivo invalido");
            }

            N_ROWS = countRows - 1;
            N_COLUMS = countColums;
            return DataString;
        }
    }
    
    //Clase interna que toma el String creado en la clase csvReader y separa todas las palabras del string de acuerdo
    //al delimitador definido con la idea de poder cargarlos posteriormente a la Tabla
    private static class TableCreation{
        
        private static final String[] Cells = DataString.split(",");
        private int currentWord = 0;
        
        List<String> getNext(int nWords){
            List<String> Words = new ArrayList<>();
            for (int i = 0; i < nWords; i++){
                if (currentWord == Integer.MAX_VALUE){
                    currentWord = 0;
                }
                
                Words.add(Cells[currentWord % Cells.length]);
                currentWord++;
            }
            return Words;
        }
        
    }
    
}
