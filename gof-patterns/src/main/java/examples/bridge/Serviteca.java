package examples.bridge;

public class Serviteca implements CentroReparacion {

	@Override
	public void revisarVehiculo() {
		System.out.println("Revision tecnomecanica");
	}

}
