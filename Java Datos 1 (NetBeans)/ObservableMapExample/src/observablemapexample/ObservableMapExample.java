
package observablemapexample;

import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

public class ObservableMapExample {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        ObservableMap<String,String> observableMap = FXCollections.observableMap(map);
        
        observableMap.addListener(new MapChangeListener(){
            @Override
            public void onChanged(MapChangeListener.Change change) {
                System.out.println("Cambio detectado"); 
            }          
        });
        
        observableMap.put("key 1", "value 1");
        System.out.println("Size:" + observableMap.size()+observableMap.toString());
        
        System.out.println("");
        
        map.put("key 2", "value 2");
        System.out.println("Size:" + observableMap.size()+observableMap.toString());
        
        System.out.println("");
        observableMap.put("key 3", "value 3");
        System.out.println("Size:" + observableMap.size()+observableMap.toString());
        
        System.out.println("");
        observableMap.put("key 4", "value 4");
        System.out.println("Size:" + observableMap.size()+observableMap.toString());
        
        System.out.println("");
        observableMap.remove("key 1");
        System.out.println("Size:" + observableMap.size()+observableMap.toString());
        
        System.out.println("");
        map.remove("key 4");
        System.out.println("Size:" + observableMap.size()+observableMap.toString());
        
        
        
        
        
        
        
        
        
        
    }
    
}
