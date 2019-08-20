
package dataorderingexample;

import java.util.Comparator;

public class CarPositions {
    
    private final String carImage;
    private final String marca;
    private final String model;
    private String season;
    private int efficiency;
    
    public CarPositions(String[] carData){
        this.carImage = carData[0];
        this.marca = carData[1];
        this.model = carData[2];
        this.season = carData[3];
        this.efficiency = (int) Double.parseDouble(carData[4]);
        
    }
    
    public String getCarImage() {
        return carImage;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
    
        public static Comparator<CarPositions> efficiencyComparatorA = new Comparator<CarPositions>(){
        
        @Override
        public int compare(CarPositions efficiency1, CarPositions efficiency2){
            int Efficiency1 = efficiency1.getEfficiency();
            int Efficiency2 = efficiency2.getEfficiency();
            
            return Efficiency1 - Efficiency2;
        }
    };
    
    public static Comparator<CarPositions> efficiencyComparatorD = new Comparator<CarPositions>(){
        
        @Override
        public int compare(CarPositions efficiency1, CarPositions efficiency2){
            int Efficiency1 = efficiency1.getEfficiency();
            int Efficiency2 = efficiency2.getEfficiency();
            
            return Efficiency2 - Efficiency1;
        }
    };
    
    @Override
    public String toString(){
        return getCarImage() + ","  + getMarca() + "," + getModel() + "," + getSeason() + "," + getEfficiency();
    }
    
}
