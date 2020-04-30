package examples.builder;

public class SucursalApartamentos extends Inmobiliaria<String> {
	String vivienda = "";

	@Override
	public void venderHabitaciones() {
		vivienda+= "Apartamento 1 habitacion, ";
	}

	@Override
	public void venderParqueadero() {
		vivienda+= "parqueadero cubierto, ";
	}

	@Override
	public void venderPiscina() {
		vivienda+= "piscina comunal ";
	}
	
	@Override
	public String getVivienda() {
		return vivienda;
	}
}
