package guessingGame;

import java.io.*;
import java.net.Socket;

public class Cliente {
	private final Socket socket;

	public Cliente(Socket socket) {
		this.socket = socket;
	}

	public void iniciar() {
		try {
			Listener listner = new Listener(socket);
			new Thread(listner).start();
		} catch (IOException e) {
			System.err.println("[Cliente] Conexion con cliente cerrado");
			System.err.println("[Cliente] " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9090);
			System.out.println("[Cliente] Nuevo cliente creado en la puerta 9090");
			new Cliente(socket).iniciar();
		} catch (IOException e) {
			System.err.println("[Cliente] Conexion con cliente cerrado");
			System.err.println("[Cliente] " + e.getMessage());
		}
	}
}
