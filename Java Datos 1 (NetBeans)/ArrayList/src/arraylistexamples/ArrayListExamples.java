
package arraylistexamples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
        
        //Ordenar la lista de forma ascendente
        System.out.println("Lista ordenada de manera descendente");
        Collections.sort(intList);
        
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
        
        ArrayList<Integer> intList2 = new ArrayList<>();
        intList2.add(14);
        intList2.add(25);
        intList2.add(-10);
        intList2.add(869);
        intList2.add(78);
        
        //Ordenar la lista de forma descendente
        System.out.println("Lista ordenada de manera descendente");
        Collections.sort(intList2,Collections.reverseOrder());
        
        //While 
        System.out.println("While");
        int counter = 0;
        while (intList2.size()>counter){
            System.out.println(intList2.get(counter));
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
        peopleData.add(new Person("Maria","Fernandez",24));
        
        for (Person datas: peopleData){
            System.out.println(datas.getInformation());
        }
        
        System.out.println("\n");
        System.out.println("Ordenar la lista peopleData de acuerdo al orden alfabetico de los nombres");
        Collections.sort(peopleData, Person.nameComparator);
        for (Person datas: peopleData){
            System.out.println(datas);
        }
        
        System.out.println("\n");
        System.out.println("Ordenar la lista peopleData de acuerdo al orden alfabetico de los apellidos");
        Collections.sort(peopleData, Person.lastNameComparator);
        int counter2 = 0;
        while(peopleData.size()>counter2){
            System.out.println(peopleData.get(counter2));
            counter2++;
        }
        
        System.out.println("\n");
        System.out.println("Ordenar la lista peopleData de acuerdo a la edad en orden ascendente");
        Collections.sort(peopleData, Person.ageComparator);
        for (int i=0; i<peopleData.size(); i++){
            System.out.println(peopleData.get(i));
        }
    }
    public static ArrayList<String> getLectura() throws Exception{
        
        String filePath = "C:\\Users\\Emanuel\\Desktop\\myfile2.csv";
        BufferedReader br;
        ArrayList<String> Result = new ArrayList<>();
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
    
    public static Comparator<Person> nameComparator = new Comparator<Person>(){
        
        public int compare(Person name1, Person name2){
            
            String Name1 = name1.getName().toUpperCase();
            String Name2 = name2.getName().toUpperCase();
            
            //Ordenar en forma ascendente
            return Name1.compareTo(Name2);
            
            //Ordenar en forma descendente
            // return Name2.compareTo(Name1);
             
        }
        
    };
    
    public static Comparator<Person> lastNameComparator = new Comparator<Person>(){
            
        public int compare(Person lastName1, Person lastName2){
            
            String LastName1 = lastName1.getlastName().toUpperCase();
            String LastName2 = lastName2.getlastName().toUpperCase();
            
            //Forma ascendente
            return LastName1.compareTo(LastName2);
        }   
    };
    
    public static Comparator<Person> ageComparator = new Comparator<Person>(){
    
         public int compare(Person age1, Person age2){
            
            int Age1 = age1.getAge();
            int Age2 = age2.getAge();
            
            //Forma ascendente
            return Age1-Age2;
        }
    };
    
    @Override
    public String toString(){
        return "[Name: " + Name + " Last Name: " + lastName + " Age: " + Age + "]";
    }
    
}
    
    
