
package csvexample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVExample {
    private static String[] finalData;
    private static ArrayList<String> finalData2 = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException, IOException {

        
        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\Emanuel\\Desktop\\Java Datos 1 (NetBeans)\\CSVExample\\Datas.csv"));
        String row;
        try{
            while ((row = csvReader.readLine()) != null){
                finalData= row.split(",");
                finalData2.add(row);
                //finalData2.add(row.split(","));
                //System.out.println("Nombre: " + finalData[0] + ", Apellido: " + finalData[1] + ", Edad: " + finalData[2]);
            }
            csvReader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        for (int i=0; i<finalData.length; i++){
            System.out.println(finalData[i]);
        }
        System.out.println(finalData2.get(1));
        
    }
    
}
