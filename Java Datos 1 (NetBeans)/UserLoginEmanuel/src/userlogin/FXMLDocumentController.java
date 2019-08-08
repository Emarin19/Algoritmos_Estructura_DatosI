
package userlogin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void closeApp(MouseEvent event){
        System.exit(0);
    }
    
    
    @FXML
    private void siginRemain(ActionEvent event2){
        System.out.println("I`m going to remain you");
        
    }
    
}
