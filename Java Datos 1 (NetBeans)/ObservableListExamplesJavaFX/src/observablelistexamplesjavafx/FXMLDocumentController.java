
package observablelistexamplesjavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    ComboBox cbNames;
    
    @FXML
    TextField textField;
    
    @FXML
    Label linformation;
    
    private ObservableList<String> names = FXCollections.observableArrayList("Emanuel", "Cinthya","Diego","Fatima");
    
    public void onClickedButton(ActionEvent event){
        linformation.setText("");
        String temp = textField.getText();
        if (temp.equals("")){
            return;
            
        }else if(names.contains(temp)){
            linformation.setText(temp + " ya se encuentra \nen la lista");
            
        }
        else{
            names.add(temp);
            textField.clear();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        linformation.setText("");
        cbNames.setItems(names);
    }


    public ObservableList<String> getNames() {
        return names;
    }

    public void setNames(ObservableList<String> names) {
        this.names = names;
    }

    
    
}
