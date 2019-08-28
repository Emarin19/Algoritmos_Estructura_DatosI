
package tableviewhomework;

//Same project
import excepciones.ArchivoVacio;
import excepciones.ExtensionCSV;
import excepciones.FormatoCSV;

//JavaFX package
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

//Java package
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {
    Window window;
    private String filePath;
    private ArrayList<String>fileDatas;
    TableView<ObservableList<String>> tableView = new TableView<>();

    @FXML
    private HBox tableVision;
    
    @FXML
    public void setFile(ActionEvent event) throws IOException, Exception {
        
        tableVision.getChildren().clear();
        
        try{
            filePath = fileSearch();
        }catch (NullPointerException exception){
            exception.getMessage();
            Alert alert = new Alert(AlertType.ERROR, "Archivo no seleccionado");
            alert.showAndWait();
            System.exit(0);
        }catch (ExtensionCSV exception){
            Alert alert = new Alert(AlertType.ERROR, exception.getMessage());
            alert.showAndWait();
            System.exit(0);
        }
        
        csvReader fileReading = new csvReader(",", filePath);
        try{
            fileDatas = fileReading.MRows_Colums();
        }catch (FormatoCSV exception){
            Alert alert = new Alert(AlertType.ERROR, exception.getMessage());
            alert.showAndWait();
        }catch (ArchivoVacio exception){
            Alert alert = new Alert(AlertType.ERROR, exception.getMessage());
            alert.showAndWait();
        }
        
        
        //Se instancia un objeto a la clase TableCreation para crear las filas y columnas y agregar los datos
        //correspondiente a cada celda creada.
        TableCreation Table  = new TableCreation(fileDatas.get(0));
        tableView = new TableView<>();
        
        //Se agregan las columnas a la Tabla
        List<String> columnNames = Table.getNext(Integer.parseInt(fileDatas.get(2)));
        
        
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
        for (int i = 0; i < Integer.parseInt(fileDatas.get(1)); i++) {
            tableView.getItems().add(
                FXCollections.observableArrayList(
                        Table.getNext(Integer.parseInt(fileDatas.get(2)))
                )
            );
        }
        
        finalTable();
    }
    
    public String fileSearch()throws NullPointerException, ExtensionCSV, Exception{
        
        String filePathS;
        FileChooser fileChooser = new FileChooser();
        File csvFile = fileChooser.showOpenDialog(window);
        
        filePathS = csvFile.getAbsolutePath();
        System.out.println("Filepath" + filePathS);
        
        if (filePathS == null){
            throw new NullPointerException();
            
        }
        else if ((filePathS.endsWith(".csv"))==false){
            throw new ExtensionCSV();
        }
        else{
            return filePathS;
        }
        
    }
    
    public void finalTable(){
        tableVision.getChildren().addAll(tableView);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
