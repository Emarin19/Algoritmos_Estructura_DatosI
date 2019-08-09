
package excepciones;

public class ArchivoVacio extends Exception {
    private String message = "Archivo vacio";

    public void setName(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }    
}