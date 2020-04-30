package examples.adapter;

public class Combustible {
	String tipoCombustible;

	public Combustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public void arrancar() {
		if (tipoCombustible.equals("diesel")) {
			System.out.println("el combustible es diesel ->");
			System.out.println("Rodar");
		}
	}
}
