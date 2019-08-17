
package herencia;

public class Main {
    
    public static void main(String[] args) {
         /*EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Emanuel", "Marin", "222-2332-3234", 1200, 0.4);
         System.out.println(empleadoPorComision.toString());
         
         System.out.println("");
         
         EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision("Diego", "Solis",
         "267-2444-8865", 1700, 0.6, 25000);
         System.out.println(empleadoBaseMasComision.toString());*/
         
         EmpleadoBaseMasComision empleado = new EmpleadoBaseMasComision("Diego", "Solis",
         "267-2444-8865", 1700, 0.6, 25000);
         System.out.println(empleado);
         System.out.println(factorial2(50,1));
         
         
    }
    
    public static long factorial(int n){
       if (n == 1)
           return 1;
       
       else
           return n * factorial (n-1);
    }
    
    public static long factorial2(int n, long Resultado){
        if (n==1){
            return Resultado;
        }
        else{
            Resultado = Resultado*n;
            return (factorial2(n-1,Resultado));
        }
    }
    
  
  
}
