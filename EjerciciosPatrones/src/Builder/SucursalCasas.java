package Builder;

public class SucursalCasas extends Inmobiliaria<String> {
	String vivienda = "";

	@Override
	public void venderParqueadero() {
		vivienda += "parqueadero al aire libre, ";
	}

	@Override
	public void venderHabitaciones() {
		vivienda += "Casa con 3 habitaciones, ";
	}

	@Override
	public void venderPiscina() {
		vivienda += "piscina privada ";
	}
	
	@Override
	public String getVivienda() {
		return vivienda;
	}
}
