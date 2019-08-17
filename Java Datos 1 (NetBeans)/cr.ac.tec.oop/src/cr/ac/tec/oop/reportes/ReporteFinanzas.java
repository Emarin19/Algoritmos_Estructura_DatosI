
package cr.ac.tec.oop.reportes;

import java.util.Date;
import java.util.List;


public class ReporteFinanzas extends ReporteBase {
    
    public ReporteFinanzas(List<Item> items, String user, Date date) {
        super(items, user, date);
    }
    
    @Override
    public void generate(List<Item> items){
        super.generate(items);
        float finalValue = 0;
        for(Item i: items){
            finalValue += i.getPrice();
        }
        System.out.println(finalValue);
        
    }
}

