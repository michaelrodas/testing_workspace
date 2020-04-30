package examples.component;

public abstract class CompuestoMolecular {
	String nombre;
	int peso;

	public int getPeso() {
		return peso;
	}

	public CompuestoMolecular(String nombre, int peso) {
		super();
		this.nombre = nombre;
		this.peso = peso;
	}

	public void presentarCaracteristicas() {
		System.out.println("nombre:" + nombre + " peso:" + peso);
	}
}
