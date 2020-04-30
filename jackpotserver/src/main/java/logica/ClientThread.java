package logica;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;

import presentacion.Modelo;

/*
 * The chat client thread. This client thread opens the input and the output
 * streams for a particular client, ask the client's name, informs all the
 * clients connected to the server about the fact that a new client has joined
 * the chat room, and as long as it receive data, echos that data back to all
 * other clients. The thread broadcast the incoming messages to all clients and
 * routes the private message to the particular client. When a client leaves the
 * chat room this thread informs also all the clients about that and terminates.
 */
public class ClientThread extends Thread {

	private DataInputStream is = null;
	private PrintStream os = null;
	private Socket clientSocket = null;
	private Modelo modelo;

	public ClientThread(Socket clientSocket, ClientThread[] threads,
			Modelo modelo) {
		this.clientSocket = clientSocket;
		this.modelo = modelo;
	}

	public void run() {

		try {
			/*
			 * Create input and output streams for this client.
			 */
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			String message;
			while (true) {
				if((message = is.readLine())!=null&&!message.equals("")){
					os.println("OK");
					Object[] datosMaquina = message.split("\\|");
					modelo.getVentanaPrincipal().addFilaTabla(
							new Object[] { datosMaquina[0], datosMaquina[1],
									datosMaquina[2], datosMaquina[3] });
					// "Machine", "gando", "creditos", "dinero"
				}else {
					os.println("NK");
					break;
				}
			}
			/*
			 * Close the output stream, close the input stream, close the
			 * socket.
			 */
			is.close();
			os.close();
			clientSocket.close();
			
		} catch(SocketException ex){
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}