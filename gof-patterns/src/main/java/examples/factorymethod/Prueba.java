package examples.factorymethod;

public class Prueba {
	public static void main(String[] args) {
		System.out.println("Tratamiento paciente con gripa->fiebre");
		new AtencionPaciente().tratarEnfermedad();
	}
}
