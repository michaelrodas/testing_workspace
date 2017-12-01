package Bridge;

public class Prueba {
       public static void main(String s[]){
    	   System.out.println("Vehiculo privado->");
    	   Vehiculo vehiculo = new VehiculoPrivado();
		   vehiculo.setCentroReparacion(new Taller());
		   vehiculo.irARevision();
		   System.out.println("Vehiculo publico->");
		   vehiculo = new VehiculoPublico();
		   vehiculo.setCentroReparacion(new Serviteca());
		   vehiculo.irARevision();
       }
}
