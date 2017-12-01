package Facade;

public class IntermediarioEmbajada {
	private Embajada embajadaRusia;
	private Embajada embajadaJapon;

	public IntermediarioEmbajada() {
		embajadaRusia = new EmbajadaRusia();
		embajadaJapon = new EmbajadaJapon();
	}

	public void presentarEmbajadaJapon() {
		embajadaJapon.presentar();
	}

	public void presentarEmbajadaRusia() {
		embajadaRusia.presentar();
	}
}
