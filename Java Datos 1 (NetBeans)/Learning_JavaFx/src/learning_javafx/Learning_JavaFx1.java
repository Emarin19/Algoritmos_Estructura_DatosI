
package learning_javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Learning_JavaFx1 extends Application {
    
    Button button;
    
    public static void main(String[] args) {
        launch(args); //Set up your program as a JavaFX aplication
    }
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("JavaFX Aplication");
        
        button = new Button();
        button.setText("Click me");
        
        //Expresion lambda para simplificar la instanciación de una clase interna o bien implementar una interfaz ActionEvent.
        button.setOnAction(e -> {
            System.out.println("My name is Emanuel");
            System.out.println("I´m from Costa Rica");
            System.out.println("I really enjoy to learn JavaFX");
        });
        
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    
    
}

