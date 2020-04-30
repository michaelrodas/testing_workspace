package examples.decorator;

public class Prueba {

	public static void main(String args[]){
		System.out.println("AutoDeportivo...");
		AutoDeportivo autoDeportivo = new AutoDeportivo("Nissan:");
		AccesorioPotencia accesorioPotencia = new AccesorioPotencia(autoDeportivo, "Tubo escape Akrapovic");
		autoDeportivo.presentarCaracteristicas();
		accesorioPotencia.presentarCaracteristicas();
		
		autoDeportivo.setMarca("Ferrari:");
		AccesorioJuegoLuces luces = new AccesorioJuegoLuces(autoDeportivo, "Luces LED ohms");
		AccesorioTraccion traccion = new AccesorioTraccion(autoDeportivo, "ohlins");
		autoDeportivo.presentarCaracteristicas();
		luces.presentarCaracteristicas();
		traccion.presentarCaracteristicas();
	}
}
