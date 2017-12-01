package FactoryMethod;

public abstract class ControlEnfermedades {
	public void tratarEnfermedad() {
		aplicarMedicamento();
	}

	protected abstract ControlGripa aplicarMedicamento();
}
