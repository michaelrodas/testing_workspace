package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	private VentanaPrincipal ventana;
	private Modelo modelo;

	public Controlador(VentanaPrincipal ventanaPrincipal) {
		ventana = ventanaPrincipal;
		modelo = ventana.getModelo();
	}

	public Modelo getModelo() {
		return modelo;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Request a connection initiation
		if (event.getActionCommand().equals("connect")) {
			ventana.connectButton.setEnabled(false);
			ventana.disconnectButton.setEnabled(true);
			ventana.statusBar.setText("Online");
			ventana.mainFrame.repaint();
		}
		// Disconnect
		else {
			ventana.connectButton.setEnabled(true);
			ventana.disconnectButton.setEnabled(false);
			ventana.statusBar.setText("Offline");
			ventana.mainFrame.repaint();
			modelo.getServer().terminarHiloServer();
		}
	}
}
