
package loginexample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SigupController implements Initializable {
    
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField name;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPassword;
    
    @FXML
    private Label empty;
    
    @FXML
    private Label noEmpty;
    
    @FXML
    private ImageView name_lastnameE;

    @FXML
    private ImageView name_lastnameR;
    
    @FXML
    private ImageView rightEmail;

    @FXML
    private ImageView errorEmail;
    
    @FXML
    private ImageView passwordR;

    @FXML
    private ImageView passwordE;
    
    @FXML
    private ImageView usernameR;

    @FXML
    private ImageView usernameE;
    
    boolean name_lastnameTF, emailTF, usernameTF, passwordTF; 
    
    @FXML
    void backSiginScene(ActionEvent event) {
        siginScene();
    }
    
    @FXML
    void sigupConfirmation(ActionEvent event) {
        empty.setText("");
        noEmpty.setText("");
        String Name = name.getText();
        String LastName = lastName.getText();
        String Email = email.getText();
        String Username = userName.getText();
        String Password = userPassword.getText();
        
        SigupData sigupData = new SigupData(Name,LastName,Email,Username,Password);
        
        //Verifications
        emptyVerifications(sigupData);
        name_lastName(sigupData);
        emailAddress(sigupData);
        password(sigupData);
        username(sigupData);
        savedata(sigupData);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    private void siginScene() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(0));
        fadeTransition.setNode(rootPane);
        
        fadeTransition.setOnFinished((ActionEvent event) ->{
            loadSiginScene();
        });
        fadeTransition.play();
    }

    private void loadSiginScene() {
        try{
            Parent firstView;
            firstView = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
            
            Scene firstScene = new Scene(firstView);
            Stage curStage = (Stage) rootPane.getScene().getWindow();
            curStage.setScene(firstScene);
            
        } catch(IOException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    private void emptyVerifications(SigupData sigupData) {
        if(sigupData.emptyData() == true){
            empty.setText("There are empty options");
        }
        else{
            noEmpty.setText("Everything correct");
        }
    }

    private void name_lastName(SigupData sigupData) {
        name_lastnameTF = sigupData.name_lastNameVerification();
        if (name_lastnameTF == true){
            name_lastnameR.setOpacity(0);
            name_lastnameE.setOpacity(1);
        }
        else{
            name_lastnameE.setOpacity(0);
            name_lastnameR.setOpacity(1);
        }
    }

    private void emailAddress(SigupData sigupData) {
        emailTF = sigupData.emailAddressVerication();
        if(emailTF == true){
            rightEmail.setOpacity(0);
            errorEmail.setOpacity(1);
        }
        else{
            errorEmail.setOpacity(0);
            rightEmail.setOpacity(1);
        }
    }
    
    private void username(SigupData sigupData) {
        usernameTF = sigupData.usernameVerification();
        if(usernameTF == true){
            usernameR.setOpacity(0);
            usernameE.setOpacity(1);
        }
        else{
            usernameE.setOpacity(0);
            usernameR.setOpacity(1);
        }
    }

    private void password(SigupData sigupData) {
        passwordTF = sigupData.passwordVerification();
        if (passwordTF == true){
            passwordR.setOpacity(0);
            passwordE.setOpacity(1);
        }
        else{
            passwordE.setOpacity(0);
            passwordR.setOpacity(1);
        }
    }

    private void savedata(SigupData sigupData) {
        if (name_lastnameTF == false && emailTF == false && usernameTF == false && passwordTF == false){
            sigupData.saveDatas();
        }
        else{
            System.out.println("Hay datos erroneos");
        }
        
    }

}
