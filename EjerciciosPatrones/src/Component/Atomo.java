package Component;

public class Atomo extends CompuestoMolecular{
	public Atomo(String nombre, int peso) {
		super(nombre, peso);
	}

	@Override
	public void presentarCaracteristicas() {
		System.out.print("Atomo ");
		super.presentarCaracteristicas();
	}
	
}
