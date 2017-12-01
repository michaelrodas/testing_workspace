package Adapter;

public class Prueba {	
	public static void main(String[] args) {
		System.out.println("Casa rodante:");
		new Condenado(new CasaRodante(new Combustible("diesel")));
	}
}
