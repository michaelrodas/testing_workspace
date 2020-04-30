package examples.adapter;

public class CasaRodante implements Motor {
    Combustible tipoCombustible;
	public CasaRodante(Combustible tipoCombustible) {		
		this.tipoCombustible = tipoCombustible;
	}
	@Override
	public void arrancar() {
		System.out.println("arrancar!");
		tipoCombustible.arrancar();
	}
}
