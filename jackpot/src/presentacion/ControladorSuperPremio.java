package presentacion;

import java.awt.event.ActionEvent;

/** Ejecuta una accion cuando se hace clic en el check box Super Jack pot. */
public class ControladorSuperPremio extends Controlador{
	public ControladorSuperPremio(VistaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal);
	}

	public void actionPerformed(ActionEvent e) {
		if (getVentana().getCbSuperJackpot().isSelected() == true) {
			getVentana().getLblEstado().setText("Modo Super Premio Activado! El $ ganado ahora es x100!");
		} else {
			getVentana().getLblEstado().setText("Modo Super Premio Desactivado! :'(");
		}
	}
}
