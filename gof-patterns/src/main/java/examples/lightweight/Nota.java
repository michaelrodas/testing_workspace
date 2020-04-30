package examples.lightweight;

public class Nota implements IPresentable {
	String texto;
		
	public Nota(String texto) {		
		this.texto = texto;
	}
	
	@Override
	public void presentar(int x, int y) {
		System.out.println("Contenido nota: " + texto);
	}
	
}
