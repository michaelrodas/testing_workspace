package Decorator;

public class AccesorioPotencia extends PiezaMecanica {

	public AccesorioPotencia(Auto auto, String marca) {
		super(auto, marca);
	}
	
	@Override
	public void presentarCaracteristicas(){
		System.out.println(getMarca());
	}

}
