/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitdesigner;

import com.jfoenix.controls.JFXButton;
import com.sun.prism.paint.Color;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Emanuel
 */
public class MainViewController implements Initializable {
    
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

    @FXML
    private GridPane gridPane;
    
    @FXML
    private CheckBox checkboxGrid;
    
    @FXML
    private CheckMenuItem gridOption;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttons();
        gridDimensions();
        checkboxGrid.setSelected(true);
        
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
            gridPane.setVisible(true);
            System.out.println("Grid");
        }
        else{
            checkboxGrid.setSelected(false);
            gridPane.setVisible(false);
            System.out.println("No grid");
        }
    }
    
    @FXML
    void checkboxGridAction(ActionEvent event) {
        if(checkboxGrid.isSelected()){
            gridOption.setSelected(true);
            gridPane.setVisible(true);
        }
        else{
            gridOption.setSelected(false);
            gridPane.setVisible(false);
        }
    }
    
    @FXML
    void about(ActionEvent event) {
        System.out.println("Aditional Information");
    }

    private void gridDimensions() {
        for (int i = 0; i < 40; i++) {
            RowConstraints row = new RowConstraints(20);
            gridPane.getRowConstraints().add(row);
        }
        
        for(int j=0; j<60; j++){
            ColumnConstraints colum = new ColumnConstraints(20);
            gridPane.getColumnConstraints().add(colum);   
        }
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
     
}
