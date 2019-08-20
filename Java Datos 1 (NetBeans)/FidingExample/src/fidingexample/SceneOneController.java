
package fidingexample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneOneController implements Initializable {
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Label label;

    @FXML
    private void onButtonClick(ActionEvent event) {
        makeFadeOut();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    private void makeFadeOut() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        
        fadeTransition.setOnFinished((ActionEvent event) -> {
            loadNextScene();
        });
        fadeTransition.play();
    }
    
    private void loadNextScene(){
        try{
            Parent secondView;
            secondView = (AnchorPane) FXMLLoader.load(getClass().getResource("SceneTwo.fxml"));
        
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) rootPane.getScene().getWindow();
        
            curStage.setScene(newScene);
        }catch(IOException ex){
            Logger.getLogger(SceneOneController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
