package Decorator;

public abstract class Auto {
	private String marca;
	
	public Auto(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public abstract void presentarCaracteristicas();
}
