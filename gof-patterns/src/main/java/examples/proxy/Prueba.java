package examples.proxy;

public class Prueba {
	public static void main(String[] args) {
		System.out.println("Se crea una imagen");
		Recurso imagen = new Imagen("/defaultPath/directory/");
		Recurso banner = new Banner(imagen);		
		banner.localizar();
	}
}
