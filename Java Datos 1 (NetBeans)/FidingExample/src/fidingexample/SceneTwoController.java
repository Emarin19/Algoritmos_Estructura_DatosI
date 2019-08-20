
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneTwoController implements Initializable {
    
    @FXML
    private AnchorPane rootPane;

    @FXML
    void onClick(ActionEvent event) {
        makeFadeOut();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    private void makeFadeOut() {
        FadeTransition fadeT = new FadeTransition();
        fadeT.setDuration(Duration.millis(1000));
        fadeT.setNode(rootPane);
        fadeT.setFromValue(1);
        fadeT.setToValue(0);
        
        fadeT.setOnFinished((ActionEvent event) -> {
            loadBeforeScene();
        });
        fadeT.play();
    }
    
    private void loadBeforeScene(){
        try{
            Parent firstView;
            firstView = (AnchorPane) FXMLLoader.load(getClass().getResource("SceneOne.fxml"));
        
            Scene newScene = new Scene(firstView);
            Stage curStage = (Stage) rootPane.getScene().getWindow();
        
            curStage.setScene(newScene);          
        } catch(IOException ex){
            Logger.getLogger(SceneTwoController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
