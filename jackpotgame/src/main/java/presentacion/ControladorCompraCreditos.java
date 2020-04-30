package presentacion;

import java.awt.event.ActionEvent;

public class ControladorCompraCreditos extends Controlador{

	public ControladorCompraCreditos(VistaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal);
	}


	/** Ejecuta la accion cuando el boton Comprar Creditos es presionado. */
	@Override
	public void actionPerformed(ActionEvent event) {
		getSistema().comprarCreditos();
	}
}
