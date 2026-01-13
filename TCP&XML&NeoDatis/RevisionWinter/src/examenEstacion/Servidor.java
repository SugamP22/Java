package examenEstacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private int port;

	public Servidor(int port) {
		this.port = port;
	}

	public void iniciar() {
		try (ServerSocket server = new ServerSocket(port)) {
			System.out.println("Servidor abierto en el puerto " + port);

			while (true) {
				// Accept a client connection
				Socket cliente = server.accept();
				System.out.println(cliente.getInetAddress() + " :::> conectado.");

				// Start a new thread for this client
				new Thread(() -> handleClient(cliente)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleClient(Socket cliente) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()))) {
			String msg;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
			}
		} catch (IOException e) {
			System.err.println("Error en cliente " + cliente.getInetAddress() + ": " + e.getMessage());
		} finally {
			try {
				cliente.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor(5000);
		servidor.iniciar();
	}
}
