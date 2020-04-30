package logica.util;

public enum Base {
	BIN(2),
	OCT(8),
	DEC(10),
	HEX(16);
	
	private int valorBase;

	private Base(int valorBase) {
		this.valorBase = valorBase;
	}

	public int getValorBase() {
		return valorBase;
	}
}
