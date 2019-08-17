
package cr.ac.tec.oop;

import cr.ac.tec.oop.reportes.Item;
import cr.ac.tec.oop.reportes.ReporteBase;
import cr.ac.tec.oop.reportes.ReporteFinanzas;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Item> items = new ArrayList<>();
        for(int i=0; i<100; i++){
            items.add(new Item("Laptop", "Work", 600f));
        }
        
        ReporteBase report = new ReporteFinanzas(items, "Emanuel", null);
        report.generate(items);
    }
    
}
