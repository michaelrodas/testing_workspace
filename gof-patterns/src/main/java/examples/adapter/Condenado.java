package examples.adapter;

/** @author Sandro Bola�os */

public class Condenado {
	Motor silla;
	public Condenado(Motor silla) {		
		this.silla = silla;
		silla.arrancar();
	}
}
