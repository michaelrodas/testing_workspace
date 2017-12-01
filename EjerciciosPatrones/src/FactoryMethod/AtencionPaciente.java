package FactoryMethod;

public class AtencionPaciente extends ControlEnfermedades {
	@Override
	protected ControlGripa aplicarMedicamento() {
		return new ControlFiebre();
	}
}
