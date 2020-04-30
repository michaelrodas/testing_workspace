package presentacion;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class ControladorTrollface extends Controlador{

	public ControladorTrollface(VistaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal);
	}

	/** Ejecuta una accion cuando se hace clic en el check box Trollface. */
	public void actionPerformed(ActionEvent e) {
		if (getVentana().getCbTrollface().isSelected() == true
				&& getVentana().getListaImagenes().get(
						getVentana().getListaImagenes().size() - 1) != cargarImagenTrollface()) {
			getVentana().getListaImagenes().add(cargarImagenTrollface()); // adds a bonus image to the images ArrayList.
			getVentana().getLblEstado().setText(
					"Modo Trollface ACTIVADO! Trolololololol!");
		}
		if (getVentana().getCbTrollface().isSelected() == false
				&& getVentana().getListaImagenes().get(
						getVentana().getListaImagenes().size() - 1) != cargarImagenTrollface()) {
			getVentana().getListaImagenes().remove(
					getVentana().getListaImagenes().size() - 1); // removes the bonus image (or last one added to the ArrayList) from the images ArrayList.
			getVentana().getLblEstado().setText(
					"Modo Trollface DESACTIVADO! :'(");
		}
	}

	private ImageIcon cargarImagenTrollface() {
		return getVentana().crearImageIcon("/imagenes/Trollface.png", "Trollface");
	}
}
