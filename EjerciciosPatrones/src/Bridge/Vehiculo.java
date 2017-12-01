package Bridge;

public abstract class Vehiculo {
	CentroReparacion revisor;
	public void setCentroReparacion(CentroReparacion revisor) {
		this.revisor = revisor;
	}
	public void irARevision() {
		revisor.revisarVehiculo();
	}
}
