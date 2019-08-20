
package loginexample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SiginData {
    
    private final String userName;
    private final String userPassword;
    
    public SiginData(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    
    public ObservableList<String> readDatabase(){
        ObservableList<String> Database = FXCollections.observableArrayList();
        BufferedReader br;
        String Line;
        try{
            br = new BufferedReader(new FileReader(
            new File("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\Java Datos 1 (NetBeans)\\LoginExample\\src\\Database.txt")));
            Line = br.readLine();
            if (Line == null || Line.equals("")){
                System.out.println("Database vacia");
            }
            
            else{
                Database.add(Line);
                while((Line = br.readLine()) != null){
                    Database.add(Line);
                }
            }

            
        } catch (IOException ex){
            System.out.println("Error de lectura");
        }  
        return Database;
    }
    
    public boolean credencialsVerifications(ObservableList<String> Database){
        boolean result = true;
        if (Database.isEmpty()){
            result = true;
        }
        else{
            String user = getUserName();
            String passWord = getUserPassword();
            ObservableList<String> Datas = FXCollections.observableArrayList();
            
            String Line;
            for(String s: Database){
                Line = s;
                Datas.addAll(Line.split(","));
                if (Datas.contains(user) && Datas.contains(passWord)){
                    result = false;
                    break;
                } 
            }
        }
        return result;
    }
}
