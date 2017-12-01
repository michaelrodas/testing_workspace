package presentacion;

import java.awt.event.ActionEvent;

/** Ejecuta una accion cuando se hace clic en Siempre gana. */
public class ControladorSiempreGana extends Controlador{
	
	public ControladorSiempreGana(VistaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (getVentana().getCbSiempreGana().isSelected() == true) {
			getVentana().getLblEstado().setText("Modo Siempre Gana Activado! 7-7-7's Vamos!");
		} else{
			getVentana().getLblEstado().setText("Modo Siempre Gana Desactivado! :'(");
		}
	}
}