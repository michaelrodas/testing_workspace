package examples.lightweight;

import javax.swing.ImageIcon;

public class Figura implements IPresentable {
	String ruta;
	ImageIcon figura;

	public Figura(String ruta) {
		super();
		this.ruta = ruta;
		figura = new ImageIcon(ruta);
	}

	@Override
	public void presentar(int x, int y) {
		System.out.println("Presentar figura " + ruta + " en posicion x:" + x + " y:"
				+ y);
	}

}
