package proxy;

public class Banner extends Recurso {

	Recurso imagen;

	public Banner(Recurso imagen) {
		this.imagen = imagen;
	}

	@Override
	public String localizar() {
		System.out.println("Se crea un banner que contiene imagen con ruta  " + imagen.localizar());
		return imagen.localizar();
	}
}
