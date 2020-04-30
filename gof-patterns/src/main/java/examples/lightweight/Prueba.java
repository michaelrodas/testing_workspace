package examples.lightweight;

public class Prueba {

	public static void main(String[] args) {
		FabricaDeFiguras fabrica = new FabricaDeFiguras();
		IPresentable figuraUno = fabrica.getFigura("Filepath1");
		figuraUno.presentar(10, 10);

		IPresentable figuraDos = fabrica.getFigura("Filepath2");
		figuraDos.presentar(20, 10);

		IPresentable notaTres = fabrica.getFigura("pathNota");
		notaTres.presentar(30, 10);
	}
}
