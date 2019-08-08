
package learning_javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert_Box {
    
    public static void Display(String Title, String Message){
        
        Stage window = new Stage();
        window.setTitle(Title);
        
        //Se le aplica un modelo de comportamiento a la ventana en la cual una vez que esta se abre, obliga al usuario
        //a realizar la tarea o funcionalidad específica por la cual fue creada.
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMaxWidth(250);
        window.setMaxHeight(250);
        
        Label label = new Label(Message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());
        
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
