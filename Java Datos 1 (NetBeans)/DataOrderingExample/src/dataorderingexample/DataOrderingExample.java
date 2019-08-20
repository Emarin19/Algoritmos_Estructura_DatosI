
package dataorderingexample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataOrderingExample {

    public static void main(String[] args) {

        BufferedReader br;
        ArrayList<CarPositions> carDatas = new ArrayList<>();
        String row;
        try{
            br = new BufferedReader(new FileReader(
            new File("C:\\Users\\Emanuel\\Desktop\\Algoritmos_Estructura_DatosI\\Java Datos 1 (NetBeans)\\DataOrderingExample\\src\\files\\carDatas.txt")));
            
            while((row = br.readLine()) != null){
                String[] carData = row.split(",");
                carDatas.add(new CarPositions(carData));
            }
            br.close();
            
            System.out.println("Orden de autos de manera ascedente");
            Collections.sort(carDatas, CarPositions.efficiencyComparatorA);
            for(CarPositions car: carDatas){
                System.out.println(car);
            }
            
            System.out.println("");
            
            System.out.println("Orden de autos de manera descendente");
            Collections.sort(carDatas, CarPositions.efficiencyComparatorD);
            for(CarPositions car: carDatas){
                System.out.println(car);
            }
            
        } catch(IOException ex){
            System.out.println("Error de lectura");
        }
    }
    
}
