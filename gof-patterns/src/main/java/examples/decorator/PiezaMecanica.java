package examples.decorator;


public abstract class PiezaMecanica extends Auto {
	
	Auto auto;

	public PiezaMecanica(Auto auto, String marca) {
		super(marca);
		this.auto = auto;
	}

	@Override
	public void presentarCaracteristicas() {
		System.out.println(auto.getMarca());
	}

}
