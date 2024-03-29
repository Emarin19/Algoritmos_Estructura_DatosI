
package tableviewhomework;

import java.util.ArrayList;
import java.util.List;

public class TableCreation {
    
    private String[] cells;
    private int currentWord = 0;
    
    public TableCreation(String dataString){
        this.cells = dataString.split(",");
    }
    
    public List<String> getNext(int nWords){
        List<String> Words = new ArrayList<>();
        for (int i = 0; i < nWords; i++){
            if (currentWord == Integer.MAX_VALUE){
            currentWord = 0;
            }
                
            Words.add(cells[currentWord % cells.length]);
            currentWord++;
        }
        System.out.println("Words" + Words);
        return Words;
    }
    
}
