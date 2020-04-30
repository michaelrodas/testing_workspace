package logica;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import presentacion.Modelo;

public class JackpotServer {
	private Modelo modelo;
	// The server socket.
	private static ServerSocket serverSocket = null;
	// The client socket.
	private static Socket clientSocket = null;

	// This chat server can accept up to maxClientsCount clients' connections.
	private static final int maxClientsCount = 10;
	private static final ClientThread[] threads = new ClientThread[maxClientsCount];

	public JackpotServer(Modelo modelo) {
		this.modelo = modelo;
	}

	public void ejecutarHiloServer() {
		while (true) {
			try { // Poll every ~10 ms
	            Thread.sleep(10);
	         }
	         catch (InterruptedException e) {
	        	 e.printStackTrace();
	         }
			try {
				if(serverSocket == null){
					serverSocket = new ServerSocket(1234);
				}
				clientSocket = serverSocket.accept();
				int i = 0;
				for (i = 0; i < maxClientsCount; i++) {
					if (threads[i] == null) {
						(threads[i] = new ClientThread(clientSocket, threads,modelo))
								.start();
						break;
					}
				}
				if (i == maxClientsCount) {
					PrintStream os = new PrintStream(
							clientSocket.getOutputStream());
					os.println("Server too busy. Try later.");
					os.close();
					clientSocket.close();
				}

			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	public void terminarHiloServer() {
		try {
			if (serverSocket != null) {
				serverSocket.close();
				serverSocket = null;
			}
		} catch (IOException e) {
			serverSocket = null;
		}

		try {
			if (clientSocket != null) {
				clientSocket.close();
				clientSocket = null;
			}
		} catch (IOException e) {
			clientSocket = null;
		}
	}
}
