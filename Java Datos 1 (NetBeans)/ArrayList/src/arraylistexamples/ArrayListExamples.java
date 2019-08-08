
package arraylistexamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ArrayListExamples {

    public static void main(String[] args) throws Exception {
        
        //Hay muchos metodos de inicializar un ArrayList, este es uno de ellos. Mas informacion
        //consultar la pagina beginnersbook
        ArrayList<String> List = new ArrayList<String>();
        List.add("Emanuel Marin");
        List.add("Diego Solis");
        List.add("Rusmery Valle");
        
        //ArrayList tiene muchos metodos
        System.out.println("ArrayList_Colletion: " + List);
        System.out.println("ArrayList_Colletion: " + List.get(1));
        List.remove(0);
        System.out.println("ArrayList_Colletion: " + List);
        System.out.println("ArrayList_Colletion: " + List.size());
        
        
        //Iterar una lista (Hay 5 formas)
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(14);
        intList.add(25);
        intList.add(-10);
        intList.add(869);
        intList.add(78);
        
        //For
        System.out.println("For");
        for (int i=0; i<intList.size(); i++){
            System.out.println(intList.get(i));
        }
        
        //For - Each
        System.out.println("For - Each");
        for (int i: intList){
            System.out.println(i);
        }
        
        //While 
        System.out.println("While");
        int counter = 0;
        while (intList.size()>counter){
            System.out.println(intList.get(counter));
            counter++;
        }
        
        ArrayList<String> Lectura = new ArrayList<>();
        Lectura = getLectura();
        for (String row: Lectura){
            String[] Colum = row.split(",");
            for (String colum: Colum){
                System.out.println(colum);
            }
        }
        
        System.out.println("Intanciacion de un objeto Person a un ArrayList");
        ArrayList<Person> peopleData = new ArrayList<>();
        peopleData.add(new Person("Emanuel","Marin",19));
        peopleData.add(new Person("Cinthya","Aguilar",18));
        for (Person datas: peopleData){
            System.out.println(datas.getInformation());
        }
        
        
    }
    public static ArrayList<String> getLectura() throws Exception{
        
        String filePath = "C:\\Users\\Emanuel\\Desktop\\myfile2.csv";
        BufferedReader br;
        ArrayList<String> Result = new ArrayList<>();
        //Result = null;
        try{
            br = new BufferedReader(new FileReader(filePath));
            String Row;
            while ((Row = br.readLine()) != null){
                Result.add(Row);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error");
            
        }catch (IllegalStateException e){
            System.out.println("Error");
        }
        return Result;
    }

}

class Person{
    private String Name;
    private String lastName;
    private int Age;
    
    public Person(String Name, String lastName, int Age){
        this.Name = Name;
        this.lastName = lastName;
        this.Age = Age;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setlastName(String lastName){
        this.lastName = Name;
    }
    
    public String getlastName(){
        return lastName;
    }
    
    public void setAge(int Age){
        this.Age = Age;
    }
    
    public int getAge(){
        return Age;
    }
    
    public String getInformation(){
        return Name + ", " + lastName + ", " + Age;
    }
    
}
    
    
