
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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable {
    
    List<String> users = new ArrayList<>();
    
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPassword;
    
    @FXML
    private CheckBox userRemembered;
    
    @FXML
    private ImageView usernameR;

    @FXML
    private ImageView usernameE;

    @FXML
    private ImageView passwordR;

    @FXML
    private ImageView passwordE;

    @FXML
    void loginButton(ActionEvent event) {
        String user = userName.getText();
        String passWord = userPassword.getText();

        if (user.equals("") || user == null){
            usernameR.setOpacity(0);
            usernameE.setOpacity(1);
        }
        
        if (passWord.equals("") || user == null){
            passwordR.setOpacity(0);
            passwordE.setOpacity(1);
        }
        
        else{
            SiginData siginData = new SiginData(user, passWord);
            ObservableList<String> Database = siginData.readDatabase();

            if(siginData.credencialsVerifications(Database) == true){
                usernameR.setOpacity(0);
                passwordR.setOpacity(0);
                usernameE.setOpacity(1);
                passwordE.setOpacity(1);
                System.out.println("No te has registrado aun");
            }
            
            else{
                if(userRemembered.isSelected()){
                    saveLastUserCredencials();
                }
                usernameE.setOpacity(0);
                passwordE.setOpacity(0);
                usernameR.setOpacity(1);
                passwordR.setOpacity(1);
                
                makeFadingOut();
            }
        }
        
        userName.clear();
        userPassword.clear();
    }
    
    @FXML
    void sigupUser(ActionEvent event) {
        sigupScene();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lastLogin();
    }    

    private void lastLogin() {
        BufferedReader br;
        String[] credencials;
        try{
            //Verificacion de que el archivo no este vacio, no haya ninguna credencial almacenada previamente
            br = new BufferedReader(new FileReader(new 
            File("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\Java Datos 1 (NetBeans)\\LoginExample\\src\\lastLogin.txt")));
            
            String Line;
            Line = br.readLine();
            if (Line == null){
                br.close();
            }
            else{
                users.add(Line);
                credencials = Line.split(",");
                userName.setText(credencials[0]);
                userPassword.setText(credencials[1]);
                br.close();
            }
        } catch(FileNotFoundException ex){
            System.out.println("Archivo no encontrado");
        } catch(IOException ex){
            System.out.println("Problemas de lectura");
        } catch(Exception ex){
            System.out.println("Unknown error");
        }
        
    }

    private void saveLastUserCredencials() {
        FileWriter fileWriter;
        String Line = userName.getText() + "," + userPassword.getText();
        try{
            if (users.contains(Line)){
                System.out.println("Usuario ya ha sido almacenado");
            }
            else{
                fileWriter = new FileWriter("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\Java Datos 1 (NetBeans)\\LoginExample\\src\\lastLogin.txt");
                fileWriter.flush();
                fileWriter.write(Line);
                fileWriter.close();
            }
            
        } catch(IOException ex){
            System.out.println("Error de escritura");
        }
    }

    private void makeFadingOut() {
        FadeTransition fadeT = new FadeTransition();
        fadeT.setDuration(Duration.millis(500));
        fadeT.setNode(rootPane);

        fadeT.setOnFinished((ActionEvent event) -> {
            loadNextScene();
        });
        fadeT.play();
    }

    private void loadNextScene() {
        try{
            Parent secondView;
            secondView = (AnchorPane) FXMLLoader.load(getClass().getResource("Profile.fxml"));
        
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) rootPane.getScene().getWindow();
        
            curStage.setScene(newScene);
        }catch(IOException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    private void sigupScene() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(0));
        fadeTransition.setNode(rootPane);

        fadeTransition.setOnFinished((ActionEvent event) -> {
            loadSigupScene();
        });
        fadeTransition.play();
    }

    private void loadSigupScene() {
        try{
            Parent thirdView;
            thirdView = (AnchorPane) FXMLLoader.load(getClass().getResource("Sigup.fxml"));
            
            Scene newScene = new Scene(thirdView);
            Stage curStage = (Stage) rootPane.getScene().getWindow();
            curStage.setScene(newScene);
            
        } catch(IOException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
