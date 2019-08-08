
package learning_javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    
    private static boolean answer;
    
    public static boolean display(){
        
        Stage Window = new Stage();
        Window.setTitle("Confirmation");
        Window.setMaxHeight(250);
        Window.setMaxWidth(250);
        Window.initModality(Modality.APPLICATION_MODAL);
        
        Label label = new Label("Sure you want to exit? ");
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        
        yesButton.setOnAction(e -> {
            answer = true;
            Window.close();
        });
        
        noButton.setOnAction(e -> {
            answer = false;
            Window.close();
        });
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, yesButton, noButton);
        
        Scene scene = new Scene(layout);
        Window.setScene(scene);
        Window.showAndWait();
        
        return answer;
        
    }
}
