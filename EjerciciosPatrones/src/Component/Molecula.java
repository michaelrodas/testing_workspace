package Component;

import java.util.ArrayList;
import java.util.List;

public class Molecula extends CompuestoMolecular {
	List<CompuestoMolecular> atomos = new ArrayList<CompuestoMolecular>();

	public Molecula(String nombre, int peso) {
		super(nombre, peso);
	}

	public void adicionar(CompuestoMolecular atomo) {
		if (atomo != null) {
			atomos.add(atomo);
		}
	}

	@Override
	public void presentarCaracteristicas() {
		System.out.print("Molecula ");
		for (CompuestoMolecular atomoInterno : atomos) {
			peso += atomoInterno.getPeso();
		}
		super.presentarCaracteristicas();
		for (CompuestoMolecular atomoInterno : atomos) {
			atomoInterno.presentarCaracteristicas();
		}
	}

	@Override
	public int getPeso() {
		int peso = 0;
		for (CompuestoMolecular atomoInterno : atomos) {
			peso += atomoInterno.getPeso();
		}
		return peso;
	}
}
