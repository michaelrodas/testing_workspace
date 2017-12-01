package Decorator;


public class AutoDeportivo extends Auto {

	public AutoDeportivo(String marca) {
		super(marca);
	}

	@Override
	public void presentarCaracteristicas() {
		System.out.println(getMarca());
	}
}
