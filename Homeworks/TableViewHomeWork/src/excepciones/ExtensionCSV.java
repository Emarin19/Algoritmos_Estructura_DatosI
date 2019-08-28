
package excepciones;

public class ExtensionCSV extends Exception {
    
    private String message = "Has seleccionado un archivo incorrecto";
    
    public void setMessage(String message){
        this.message = message;
    }
    
    @Override
    public String getMessage(){
        return message;
    }
    
}
