
package cr.ac.tec.oop.reportes;

public class Item {
    private String name;
    private String description;
    private float price;
    private final String id;
    private static int idSiguiente = 1;
    
    public Item(String name, String description, float price){
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = "Produsct's ID: " + String.valueOf(idSiguiente);
        idSiguiente++;
    }
    
    @Override
    public String toString(){
        return id + " | " + name + " | " + description + " | " + price;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }
}
