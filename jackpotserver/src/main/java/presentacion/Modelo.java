package presentacion;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import logica.JackpotServer;

public class Modelo {
	// TCP Components
	public static ServerSocket hostServer = null;
	public static Socket socket = null;
	public static BufferedReader in = null;
	public static PrintWriter out = null;

	private VentanaPrincipal ventanaPrincipal;
	private JackpotServer server;

	public void iniciar() {
		getVentanaPrincipal();
		getServer().ejecutarHiloServer();
	}

	public VentanaPrincipal getVentanaPrincipal() {
		if (ventanaPrincipal == null) {
			ventanaPrincipal = new VentanaPrincipal(this);
		}
		return ventanaPrincipal;
	}
	
	public JackpotServer getServer() {
		if (server == null) {
			server = new JackpotServer(this);
		}
		return server;
	}

}
