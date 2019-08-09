
package excepciones;


public class FormatoCSV extends Exception {
    private String message = "Archivo no cumple con el formato .csv";
            
    public void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
}
