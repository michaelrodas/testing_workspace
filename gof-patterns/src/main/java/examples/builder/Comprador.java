package examples.builder;

public class Comprador {
	private Inmobiliaria<String> inmobiliaria;

	public void comprarVivienda() {
		getInmobiliaria().venderHabitaciones();
		getInmobiliaria().venderParqueadero();
		getInmobiliaria().venderPiscina();
		System.out.println(getInmobiliaria().getVivienda());
	}

	public Inmobiliaria<String> getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria<String> inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}
}
