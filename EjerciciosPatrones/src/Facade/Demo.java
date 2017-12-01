package Facade;

public class Demo {
	public static void main(String[] args) {
		System.out.println("Presentando embajadas...");
		IntermediarioEmbajada intermediario = new IntermediarioEmbajada();
		intermediario.presentarEmbajadaRusia();
		intermediario.presentarEmbajadaJapon();
	}
}
