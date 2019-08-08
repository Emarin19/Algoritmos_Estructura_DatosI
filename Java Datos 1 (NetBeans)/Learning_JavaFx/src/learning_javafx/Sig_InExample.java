
package learning_javafx;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sig_InExample {
    
    private static Label estudentID;
   
    public static void Display(){
        Stage window = new Stage();
        window.setTitle("Sig In");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(8);
        
        Label name = new Label("Username: ");
        GridPane.setConstraints(name, 0, 0);
        
        TextField nameinput = new TextField();
        GridPane.setConstraints(nameinput, 1, 0);
        
        Label carnet = new Label("Carnet: ");
        GridPane.setConstraints(carnet, 0, 1);
        
        TextField carnetinput = new TextField();
        GridPane.setConstraints(carnetinput, 1, 1);
        
        Button loginButton = new Button("Sig in");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> carnetVerification(carnetinput));
        
        estudentID = new Label();
        estudentID.setText("");
        GridPane.setConstraints(estudentID, 0, 3);
        
        grid.getChildren().addAll(name, nameinput, carnet, carnetinput, loginButton, estudentID);
        
        Scene scene = new Scene(grid, 300, 250);
        scene.getStylesheets().add("Viper.css");
        window.setScene(scene);
        window.show();
        
    }
    
    private static boolean carnetVerification(TextField carnet){
        try{
            int ID = Integer.parseInt(carnet.getText());
            //int NCarnet = carnet.getText().length();
            if (carnet.getText().length() == 10){
                estudentID.setText("Carne: " + ID + " es correcto.");
                return true;
            }
            estudentID.setText("Error: " + carnet.getText() + " es incorrecto.");
            return false;
            
            
        }catch (NumberFormatException e){
            estudentID.setText("Error: " + carnet.getText() + " es incorrecto.");
            return false;
        }
    }
}
