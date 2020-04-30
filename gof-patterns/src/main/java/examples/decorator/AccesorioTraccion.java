package examples.decorator;

public class AccesorioTraccion extends PiezaMecanica {

	public AccesorioTraccion(Auto auto, String marca) {
		super(auto, marca);
	}
	
	@Override
	public void presentarCaracteristicas(){
		System.out.println(getMarca());
	}
}
