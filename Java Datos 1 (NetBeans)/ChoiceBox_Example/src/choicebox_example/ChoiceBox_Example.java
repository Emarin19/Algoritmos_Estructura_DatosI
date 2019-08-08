
package choicebox_example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ChoiceBox_Example extends Application {
    
    private ComboBox<String> comboBox;
    private ListView<String> listView;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Choice Box, ComboBox, ListView, TreView Example!");

        //Creacion de una lista desplegable. Se define el tipo de datos que tendrá dicha lista(no se pueden mezclar los tipos de datos).
        ChoiceBox<String> choiceBox = new  ChoiceBox<String>();
        choiceBox.getItems().add("Manzana");
        choiceBox.getItems().addAll("Piña", "Sandía", "Banana","Melon");
        choiceBox.setValue("Manzana");
        
        //Cuando el usuario escoje un elemento de la lista inmediantamente se imprime en pantalla lo que el usuario ha
        //seleccionado
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue));
        
        
        comboBox = new ComboBox<String>();
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "St. Vincent",
                "Blackhat"
        );
        comboBox.setPromptText("What is your favorite movie?");
        Button comboBoxButton = new Button("Submit");
        comboBoxButton.setOnAction(e -> printMovie());
        
        //ComboBoxes also generate actions if you need to get value instantly
        comboBox.setOnAction( e -> System.out.println("User selected " + comboBox.getValue()) );
        
        
        listView = new ListView<String>();
        listView.getItems().addAll("Iron Man", "Titanic", "Avatar", "The posibles lifes of Mr. Nobody");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        Button listViewButton = new Button("Submit");
        listViewButton.setOnAction(e -> buttonClicked());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView,listViewButton);
        
        Scene scene = new Scene(layout,300,350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void printMovie(){
        System.out.println(comboBox.getValue());
    }
    
    private void buttonClicked(){
        String message ="";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();
        
        for (String m: movies){
            message += m + "\n";
        }
        System.out.println(message);
    }

}
