
package herencia;

public class EmpleadoPorComision {
    
    private final String nombre;
    private final String apellido;
    private final String numeroSeguroSocial;
    private double ventasBrutas;
    private double tarifaComision;
    
    public EmpleadoPorComision(String nombre, String apellido, String numeroSeguroSocial, double ventasBrutas, double tarifaComision){
        if(ventasBrutas < 0.0){
            throw new IllegalArgumentException("Valor de ventas brutas incorrecto");
        }
        
        if (tarifaComision <= 0.0 || tarifaComision >= 1.0){
            throw new IllegalArgumentException("Tarifa de comision incorrecta");
        }
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroSeguroSocial = numeroSeguroSocial;
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public void setVentasBrutas(double ventasBrutas) {
        if (ventasBrutas < 0.0){
            throw new IllegalArgumentException("Valor de ventas brutas incorrecto");
        }
        this.ventasBrutas = ventasBrutas;
    }

    public double getTarifaComision() {
        return tarifaComision;
    }

    public void setTarifaComision(double tarifaComision) {
        if (tarifaComision <= 0.0 || tarifaComision >= 1.0){
            throw new IllegalArgumentException("Tarifa de comision incorrecta");
        }
        this.tarifaComision = tarifaComision;
    }
    
    public double ingresos(){
        return getTarifaComision() * getVentasBrutas();
    }
    
    @Override
    public String toString(){
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "Empleado por comision", getNombre(), getApellido()
        , "Numero de seguro social", getNumeroSeguroSocial(),"Ventas brutas", getVentasBrutas(), "Tarifa de comision",
        getTarifaComision());
    }
    
}
