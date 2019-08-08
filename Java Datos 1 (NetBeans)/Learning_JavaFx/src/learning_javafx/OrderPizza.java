
package learning_javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OrderPizza {
    
    public static void pizzaSelected(){
        
        Stage window = new Stage();
        window.setTitle("Pizza Hut");
        
        Label label = new Label("Pizza Hut");
        CheckBox box1 = new CheckBox("Bicon");
        CheckBox box2 = new CheckBox("Peperoni");
        
        Button orderPizza = new Button("Order Now!");
        orderPizza.setOnAction(e -> pizzaOrderned(box1, box2));
        
        VBox layout = new  VBox(20);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(label, box1, box2, orderPizza);
        
        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
    }
    
    private static String pizzaOrderned(CheckBox box1, CheckBox box2){
        
        String message = "User order:\n";
        
        if (box1.isSelected()){
            message += "Bicon\n"; 
        }
        
        if (box2.isSelected()){
            message += "Peperoni";
        }
        System.out.println(message);
        return message; 
    }
    
}
