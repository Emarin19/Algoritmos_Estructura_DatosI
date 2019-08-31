
package prueba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Emanuel
 */
public class Prueba extends Application {
    ImageView image;
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\ProyectoI_Circuit Designer\\CircuitDesigner\\src\\images\\AND.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80); 
        imageView.setFitWidth(50); 
        
        AnchorPane anchorpane = new AnchorPane(imageView);
        Scene scene = new Scene(anchorpane, 100, 60);
      
       
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
