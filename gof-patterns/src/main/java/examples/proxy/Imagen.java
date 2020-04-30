package examples.proxy;

public class Imagen extends Recurso {
	private String ruta;

	public Imagen(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String localizar() {
		return ruta;
	}
}
