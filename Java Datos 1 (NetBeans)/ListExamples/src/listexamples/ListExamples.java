
package listexamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListExamples {

    public static void main(String[] args) {
        System.out.println("Use of Lists");
        List<String> list = new ArrayList<String>();
        list.add("Emanuel");
        list.add("Cinthya");
        list.add("Diego");
        //Collections.reverse(list);
        Collections.sort(list);
        System.out.println(list);
        
        System.out.println("");
        
        System.out.println("Adding a element in index 0");
        list.set(0, "Elsi");
        System.out.println(list);
        
        System.out.println("");
        
        System.out.println("Removing the last Element");
        list.remove(list.size()-1);
        System.out.println(list);
        
        System.out.println("");
        
        System.out.println("Removing all elements");
        list.clear();
        System.out.println(list);
        
        System.out.println("");
        System.out.println("________________________________________________");
        
        System.out.println("");
        System.out.println("Use of Map");
        
        Map<String,String> map = new HashMap<String,String>();
        
        map.put("apple", "Fruit");
        map.put("carrot", "Vegestable");
        System.out.println("El mapa esta vacio? \n " +map.isEmpty());
        
        System.out.println("The key is apple, the value is: " + map.get("apple"));
        System.out.println("The key is carrot, the value is: " + map.get("carrot"));
        
        System.out.println("Removing a key-value");
        map.remove("apple");
        System.out.println("Size: " + map.size() + map.toString());
        
        System.out.println("Removing all");
        map.clear();
        System.out.println("Size: " + map.size() + map.toString());
        
        System.out.println("More about map");
        Map<Integer,String> map2 = new HashMap<Integer,String>();
        map2.put(1, "Emanuel");
        map2.put(2, "Cinthya");
        map2.put(3, "Diego");
        map2.put(4, "Fatima");
        System.out.println("Size: " + map2.size() + map2.toString());
        
        System.out.println("The first key has the value: " + map2.get(1));
        
        
        
        
    }
    
}
