
package cr.ac.tec.oop.reportes;

import java.util.Date;
import java.util.List;

public class ReporteBase {
    private String user;
    private Date date = new Date();
    
    protected List<Item> items;
    
    public ReporteBase(List<Item> items, String user, Date date){
        this.items = items;
        this.user = user;
        this.date.getTime();
 
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public void generate(List<Item> items){
        System.out.println("------------------------------------------------");
        System.out.println(user + date); 
        
        for(Item i: items){
            System.out.println(i);
        }
        
    }
    
}
