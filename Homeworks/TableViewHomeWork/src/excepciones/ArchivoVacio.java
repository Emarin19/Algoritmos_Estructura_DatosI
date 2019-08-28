
package excepciones;

public class ArchivoVacio extends Exception {
    private String message = "Archivo vacio";

    public void setName(String message){
        this.message = message;
    }
    
    @Override
    public String getMessage(){
        return message;
    }    
}