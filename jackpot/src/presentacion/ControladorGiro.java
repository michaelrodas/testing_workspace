package presentacion;

import java.awt.event.ActionEvent;

/** Ejecuta la accion cuando se hace clic en el boton girar. */
public class ControladorGiro extends Controlador{
	public ControladorGiro(VistaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		getSistema().ejecutarJuego();
	}
}	