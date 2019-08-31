/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitdesigner;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nodes.LogicGate;


/**
 *
 * @author Emanuel
 */
public class MainViewController extends AnchorPane implements Initializable {

    
    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private BorderPane borderpane;
    
    @FXML
    private VBox rightpane;
    
    @FXML
    private AnchorPane leftpane;
    
    @FXML
    private CheckMenuItem gridOption;
    
    @FXML
    private GridPane gridpane;
    
    @FXML
    private JFXCheckBox checkboxGrid;
    
    @FXML
    private JFXButton newFileButton;

    @FXML
    private JFXButton openFileButton;

    @FXML
    private JFXButton saveFileButton;

    @FXML
    private JFXButton saveasFileButton;

    @FXML
    private JFXButton settingsButton;

    @FXML
    private JFXButton helpButton;

    @FXML
    private JFXButton exitButton;
    
    @FXML
    private JFXButton runButton;

    @FXML
    private JFXButton truetable;
    
    @FXML
    private ImageView newFileIcon;

    @FXML
    private ImageView openFileIcon;

    @FXML
    private ImageView saveFileIcon;

    @FXML
    private ImageView saveasFileIcon;

    @FXML
    private ImageView settingsIcon;

    @FXML
    private ImageView helpIcon;

    @FXML
    private ImageView exitIcon;
    
    @FXML
    private ImageView runIcon;
    
    /*private DragGateController Gate = null;
    
    private EventHandler gateDragOverRoot = null;
    private EventHandler gateDragDropped = null;
    private EventHandler gateDragOverLeftPane = null;*/
    


    void setStageAndSetupListeners(Stage stage) {
        stage.setTitle("Circuit Designer");
        Scene scene = new Scene(mainAnchorPane,1000,650);
        borderpane.prefWidthProperty().bind(mainAnchorPane.widthProperty());
        borderpane.prefHeightProperty().bind(mainAnchorPane.heightProperty());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons();
        gridDimensions();
        checkboxGrid.setSelected(true);
        /*Gate = new DragGateController();
        Gate.setVisible(true);
        getChildren().add(Gate);
        
        for(int i=0; i<3; i++){
            
            DragGateController logic = new DragGateController();
            logic.setType(DragGateType.values()[i]);
            ImageView image = new ImageView(logic.getType().getImage());
            AnchorPane base = new AnchorPane(image);
            rightpane.getChildren().add(base);
        }*/
        
        
    }
    
    @FXML
    void newFile(ActionEvent event) {
        System.out.println("Craeting a new file...");
    }
    
    @FXML
    void openFile(ActionEvent event) {
        System.out.println("Open file...");

    }

    @FXML
    void saveFile(ActionEvent event) {
        System.out.println("Saving file...");
    }

    @FXML
    void saveasFile(ActionEvent event) {
        System.out.println("Saving as file...");
    }

    @FXML
    void settings(ActionEvent event) {
        System.out.println("Opening settings option");
    }
    
    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    void copy(ActionEvent event) {
        System.out.println("Coping...");
    }

    @FXML
    void cut(ActionEvent event) {
        System.out.println("Cutting");
    }
    
    @FXML
    void paste(ActionEvent event) {
        System.out.println("Pasting...");
    }
    
    @FXML
    void gridView(ActionEvent event) {
        if(gridOption.isSelected()){
            checkboxGrid.setSelected(true);
            gridpane.setVisible(true);
            System.out.println("Grid");
        }
        else{
            checkboxGrid.setSelected(false);
            gridpane.setVisible(false);
            System.out.println("No grid");
        }
    }
    
    @FXML
    void checkboxGridAction(ActionEvent event) {
        if(checkboxGrid.isSelected()){
            gridOption.setSelected(true);
            gridpane.setVisible(true);
        }
        else{
            gridOption.setSelected(false);
            gridpane.setVisible(false);
        }
    }
    
    @FXML
    void runCircuit(ActionEvent event) {
        System.out.println("Running circuit");
    }
    
    @FXML
    void generateTrueTable(ActionEvent event) {
        System.out.println("True Table");
    }
    
    @FXML
    void about(ActionEvent event) {
        System.out.println("Aditional Information");
    }

    private void buttons() {
        newFileButton.setGraphic(newFileIcon);
        openFileButton.setGraphic(openFileIcon);
        saveFileButton.setGraphic(saveFileIcon);
        saveasFileButton.setGraphic(saveasFileIcon);
        settingsButton.setGraphic(settingsIcon);
        runButton.setGraphic(runIcon);
        helpButton.setGraphic(helpIcon);
        exitButton.setGraphic(exitIcon);
    }

    private void gridDimensions() {
        for (int i = 0; i < 60; i++) {
            RowConstraints row = new RowConstraints(20);
            gridpane.getRowConstraints().add(row);
        }
        
        for(int j=0; j<60; j++){
            ColumnConstraints colum = new ColumnConstraints(20);
            gridpane.getColumnConstraints().add(colum);   
        }
    }

    @FXML
    private void loadGates() {
        /*DragGateController draggate = new DragGateController();
        LogicGate logicGate;
        for(int i=0; i<3; i++){
            try{
                AnchorPane base = new AnchorPane();
                draggate.setType(DragGateType.values()[i]);
                logicGate = draggate.getType();
                ImageView logicGateImage = new ImageView(logicGate.getImage());
                base.getChildren().add(logicGateImage);
                rightpane.getChildren().add(base);   
            } catch(Exception ex){
                System.out.println("Error");
            }
        }*/

    }
   
}
