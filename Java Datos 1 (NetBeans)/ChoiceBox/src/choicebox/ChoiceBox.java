
package choicebox;

import java.awt.Insets;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBox extends Application {
    
    Stage window;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Choice Box Example");
        Button btn = new Button("Click me!");
        
        ChoiceBox<String> choiceBox = new ChoiceBox<>(); 
        VBox layout = new VBox(20);
        layout.getChildren().addAll(btn);
        
       Scene scene = new Scene(layout,300,250);
       window.setScene(scene);
       window.show();

    }
  
}
