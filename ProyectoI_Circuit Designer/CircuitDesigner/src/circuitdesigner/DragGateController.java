/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package circuitdesigner;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import nodes.AndGate;
import nodes.LogicGate;
import nodes.NotGate;
import nodes.OrGate;


/**
 * FXML Controller class
 *
 * @author Emanuel
 */
public class DragGateController extends AnchorPane implements Initializable {
    
    public DragGateController(){

    }
    DragGateType gate;
    LogicGate logicGate;
    
    @FXML
    public AnchorPane rootpane; 
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    public LogicGate getType(){
        return logicGate;
    }
    
    public void setType(DragGateType type){
        gate = type;
        
        switch(gate){
            case AND:
                logicGate = new AndGate();
                break;
                
            case OR:
                logicGate = new OrGate();
                break;
                
            case NOT:
                logicGate = new NotGate();
                break;
                
            default:
                logicGate = null;
        }
    }

    void relocateToPoint(Point2D point2D) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
