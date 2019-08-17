
package herencia;

public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double salarioBase;
    
    public EmpleadoBaseMasComision(String nombre, String apellido, String numeroSeguroSocial, double ventasBrutas, 
    double tarifaComision, double salarioBase) {
        super(nombre, apellido, numeroSeguroSocial, ventasBrutas, tarifaComision);
        
        if (salarioBase < 0.0){
            throw new IllegalArgumentException("Salario base incorrecto");
        }
        
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    @Override
    public double ingresos(){
        return super.ingresos() + getSalarioBase();
    }
    
    @Override
    public String toString(){
        return String.format("%s %s%n%s: %.2f", "Con sueldo base", super.toString(), "Sueldo base", getSalarioBase());
    }
}
