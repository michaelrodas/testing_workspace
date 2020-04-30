package examples.builder;

public class Prueba {
	public static void main(String[] args) {
		System.out.println("Plan de compra de vivienda:");
		Comprador cliente = new Comprador();

		System.out.println("Construir Apartamento...");
		cliente.setInmobiliaria(new SucursalApartamentos());
		cliente.comprarVivienda();

		System.out.println("Construir Casa...");
		cliente.setInmobiliaria(new SucursalCasas());
		cliente.comprarVivienda();
	}

}
