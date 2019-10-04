
package observablelistexamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservableListExamples {

    public static void main(String[] args) {
        List<String> ll = (List<String>) new LinkedList<String>();
        ObservableList<String> observable = FXCollections.observableList(ll);
        observable.addListener(new ListChangeListener(){
            @Override
            public void onChanged(ListChangeListener.Change c) {
                System.out.println("Algo ha sido agregado");
            }
            
        });
        
        //List<String> list = new ArrayList<>();
        //ObservableList<String> observableList = FXCollections.observableList(list);
        
        /*observableList.addListener(new ListChangeListener(){
            
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Cambio detectado");
                while(change.next()){
                    System.out.println("Agregado: "+change.wasAdded());
                    System.out.println("Eliminado: "+change.wasRemoved());
                }
            }
            
        });*/
        
        observable.add("Hola");
        
        /*observableList.add("a: item one");
        System.out.println("Size:" + observableList.size() + " " + observableList.toString());
        
        System.out.println("\n");
        
        list.add("b: item two");
        System.out.println("Size:" + observableList.size() + " " + observableList.toString());
        
        System.out.println("\n");
        observableList.add("c: item three");
        System.out.println("Size:" + observableList.size() + " " + observableList.toString());
        
        System.out.println("\n");
        observableList.add("d: item four");
        System.out.println("Size:" + observableList.size() + " " + observableList.toString());
        FXCollections.reverse(observableList);
        System.out.println(observableList.get(0));
        
        list.remove(0);
        System.out.println("\n");
        System.out.println("Size:" + observableList.size() + " " + observableList.toString());
        
        System.out.println("\n");
        observableList.remove(list.size()-1);
        System.out.println("Size:" + observableList.size() + " " + observableList.toString());*/
        
    }
    
}
