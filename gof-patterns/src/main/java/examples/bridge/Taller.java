package examples.bridge;

public class Taller implements CentroReparacion {

	@Override
	public void revisarVehiculo() {
		System.out.println("Nivelar presion de aire en llantas");
	}

}
