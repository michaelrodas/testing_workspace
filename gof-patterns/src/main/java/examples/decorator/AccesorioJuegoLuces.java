package examples.decorator;

public class AccesorioJuegoLuces extends PiezaMecanica {

	public AccesorioJuegoLuces(Auto auto, String marca) {
		super(auto, marca);
	}
	
	@Override
	public void presentarCaracteristicas(){
		System.out.println(getMarca());
	}

}
