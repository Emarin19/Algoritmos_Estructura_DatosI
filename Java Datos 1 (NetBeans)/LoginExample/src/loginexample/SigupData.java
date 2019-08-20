
package loginexample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class SigupData {
    private final String name;
    private final String lastName;
    private String email; 
    private String userName;
    private String userPassword;
    List<String> datas;
    
    public SigupData(String name, String lastName, String email, String userName, String userPassword){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public boolean emptyData(){
        boolean emptyResult = true;
        datas = new ArrayList<>();
        datas.add(getName());
        datas.add(getLastName());
        datas.add(getEmail());
        datas.add(getUserName());
        datas.add(getUserPassword());
        
        for(String s: datas){
            if (s.equals("") || s == null){
                emptyResult = true;
                break;
            }
            else{
                emptyResult = false;
            }
        }
        return emptyResult;
    }
    
    public boolean name_lastNameVerification(){
        boolean result = true;
        List<String> numbers = new ArrayList<>();
        String Name = getName();
        String LastName = getLastName();
        
        for (int i=0; i<10; i++){
            numbers.add(String.valueOf(i));
        }
        
        for (String s: numbers){
            if (Name.contains(s) || LastName.contains(s)){
                result = true;
                break;
            }
            else{
                result = false;
            }
        }
        
        if (Name.equals("") || LastName.equals("")){
            result = true;
        }
        return result;
    }
    
    public boolean emailAddressVerication(){
        boolean result = true;
        String email_address = getEmail();
       
        int dot = 0;
        int at = 0;
        String[] chars = email_address.split("");
        for(String c: chars){
            if(".".equals(c)){
                dot++;
            }
            if("@".equals(c)){
                at++;
            }
        }

        if (dot != 1||at != 1){
            result = true;
        }
        else{
            if (email_address.contains("gmail") && email_address.contains("com")){
                result = false;
            }
            else{
                result = true;
            }
            
        } 
        
        return result;
    }
    
    public boolean usernameVerification(){
        boolean result;
        String UserName = getUserName();
        if (UserName.equals("")){
            result = true;
        }
        else{
            result = false;
        }
        
        return result;
    }
    
    public boolean passwordVerification(){
        boolean result = true;
        String password = getUserPassword();
        if(password.length() >= 8){
            result = false;
        }
        else{
            result = true;
        }
        
        
        return result;
    }
    
    public void saveDatas(){
        System.out.println("Every correct");
        BufferedReader br;
        ObservableList<String> database = FXCollections.observableArrayList();
        String Datas = getName() + "," + getLastName() + "," + getEmail() + "," + getUserName() + "," + getUserPassword();
        String Line;
        try{
            br = new BufferedReader(new FileReader(
            new File("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\Java Datos 1 (NetBeans)\\LoginExample\\src\\Database.txt")));
            Line = br.readLine();
            if (Line == null || Line.equals("")){
                writing(Datas);
            }
            else{
                database.add(Line);
                while((Line = br.readLine()) != null){
                    database.add(Line);
                }
                writing(database, Datas);
            }
            br.close();
        } catch (FileNotFoundException ex){
            System.out.println("Archivo no encontrado");
        } catch (IOException ex){
            System.out.println("Error de lectura");
        }
    }

    private void writing(String Datas) {
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\Java Datos 1 (NetBeans)\\LoginExample\\src\\Database.txt",true);
            fileWriter.write(Datas + "\n");
            fileWriter.close();
        } catch(IOException ex){
            System.out.println("Error de escritura");
        }
    }

    private void writing(ObservableList<String> database, String Datas) {
        if (database.contains(Datas)){
            System.out.println("Datos ya han sido almacenado antes");
        }
        else{
            FileWriter fileWriter;
            try{
                fileWriter = new FileWriter("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\Java Datos 1 (NetBeans)\\LoginExample\\src\\Database.txt",true);
                fileWriter.write("\n" + Datas);
                fileWriter.close();
            } catch (IOException ex){
                System.out.println("Error de escritura");
            }
        }
    }
    
}
