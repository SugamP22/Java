package adivinarNumeroSecreto;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private final ServerSocket server;
	private Socket socket;
	private int currentNum = 0;
	private PrintWriter out;
	private Juego juego;

	public Servidor() throws IOException {
		server = new ServerSocket(5001);
		System.out.println("Server iniciado com exitó");
	}

	private synchronized void aceptarCliente() throws IOException {
		juego = new Juego();
		while (currentNum < 3) {
			socket = server.accept();
			System.out.println("nueva cliente entrado...");
			currentNum++;
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("waiting for others to join...." + "\nCurrent players: " + currentNum);
			new Thread(new ClienteHandler(juego, socket)).start();

		}

	}

	public static void main(String[] args) {
		try {
			new Servidor().aceptarCliente();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
