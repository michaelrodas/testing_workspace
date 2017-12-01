package Component;

public class Prueba {
	public static void main(String[] args) {
		System.out.println("Compuesto molecular...");
		
		Atomo atomoHidrogeno = new Atomo("Hidrogeno", 3);
		Atomo atomoCarbono = new Atomo("Carbono", 5);
		Atomo atomoSodio = new Atomo("Sodio", 1);
		Atomo atomoOxigeno = new Atomo("Oxigeno", 2);

		Molecula alquilo = new Molecula("Alquilo", 0);
		Molecula oxidoSodio = new Molecula("Oxido de Sodio", 0);

		alquilo.adicionar(atomoHidrogeno);
		alquilo.adicionar(atomoCarbono);

		oxidoSodio.adicionar(atomoSodio);
		oxidoSodio.adicionar(atomoOxigeno);
		alquilo.adicionar(oxidoSodio);

		alquilo.presentarCaracteristicas();
	}

}
