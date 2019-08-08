
package guidemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;


public class FXMLDocumentController implements Initializable {
    
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox peperoniCheckBox;
    @FXML private CheckBox piñaCheckBox;
    @FXML private CheckBox biconCheckBox;
    
    public void MSpizzaselected(){
        String Selecciones = "Has seleccionado una pizza con: ";
        
        if (peperoniCheckBox.isSelected()){
            Selecciones += "\nPeperoni";
        }
        
        if (piñaCheckBox.isSelected()){
            Selecciones += "\nPiña";
        }
        
        if (biconCheckBox.isSelected()){
            Selecciones += "\nBicon";
        }
        
        this.pizzaOrderLabel.setText(Selecciones);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pizzaOrderLabel.setText("");
    }    
    
}
