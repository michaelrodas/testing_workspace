package logica;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import presentacion.Modelo;

/**
 * A Simple Socket client that connects to our socket server
 *
 */
public class SocketClient {
//implements Runnable {

	// The client socket
	private static Socket clientSocket = null;
	// The output stream
	private static PrintStream os = null;
	// The input stream
	private static DataInputStream is = null;
	private static boolean closed = false;

	private String hostname = "localhost";
	private int port = 1234;

	private Modelo modelo = null;

	public SocketClient(Modelo modelo) {
		this.modelo = modelo;
	}

	public void connect() throws UnknownHostException, IOException {
		 /*
	     * Open a socket on a given host and port. Open input and output streams.
	     */
	    try {
	      clientSocket = new Socket(hostname, port);
	      os = new PrintStream(clientSocket.getOutputStream());
	      is = new DataInputStream(clientSocket.getInputStream());
	    } catch (UnknownHostException e) {
	      System.err.println("Don't know about host " + hostname);
	    } catch (IOException e) {
	      System.err.println("Couldn't get I/O for the connection to the host "
	          + hostname);
	    }
	    
	}

	
	public void tellStatus() throws IOException {
		/*
	     * If everything has been initialized then we want to write some data to the
	     * socket we have opened a connection to on the port portNumber.
	     */
	    if (clientSocket != null && os != null && is != null) {
	      try {

	        /* Create a thread to read from the server. */
//	        new Thread(new SocketClient(modelo)).start();
//	        while (!closed) {
	          os.println(getStatusMessage());
//	          os.println("");
//	        }
	        /*
	         * Close the output stream, close the input stream, close the socket.
	         */
	        os.close();
	        is.close();
	        clientSocket.close();
	      } catch (IOException e) {
	        System.err.println("IOException:  " + e);
	      }
	    }
	}

	private String getStatusMessage() {
		return clientSocket.getRemoteSocketAddress().toString()+"-"+modelo.getNumMaquina() + "|"
					+ modelo.gana() + "|" + modelo.getCreditos() + "|"
					+ modelo.getFondos();
		// "Machine", "gando", "creditos", "dinero"
	}

	public void startClient(Modelo modelo) {
		// Creating a SocketClient object
		try {
			// trying to establish connection to the server
			connect();
			tellStatus();
		} catch (UnknownHostException e) {
			System.err.println("Host unknown. Cannot establish connection");
		} catch (IOException e) {
			System.err
					.println("Cannot establish connection. Server may not be up."
							+ e.getMessage());
		}
	}

	public void run() {
	    /*
	     * Keep on reading from the socket till we receive "Bye" from the
	     * server. Once we received that then we want to break.
	     */
	    String responseLine;
	    try {
	      while ((responseLine = is.readLine()) != null) {
	        System.out.println(responseLine);
	        if (responseLine.indexOf("NK") != -1)
	          break;
	      }
	      closed = true;
	    } catch (IOException e) {
	      System.err.println("IOException:  " + e);
	    }
	  }
	
	
}