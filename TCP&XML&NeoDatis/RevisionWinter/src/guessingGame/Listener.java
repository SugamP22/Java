package guessingGame;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Listener implements Runnable {
	private Socket socket;
	private BufferedReader br;
	private PrintWriter writer;
	private String name;
	private Scanner sc = new Scanner(System.in);

	public Listener(Socket socket) throws IOException {
		this.socket = socket;
		this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.writer = new PrintWriter(this.socket.getOutputStream(), true);
		System.out.print("Enter Your name: ");
		this.name = sc.nextLine();
		writer.println(name);
	}

	@Override
	public void run() {
		String msg = "";
		try {
			while ((msg = br.readLine()) != null) {
				// Always show server messages so the user understands what's happening.
				System.out.println(msg);

				// Server is full -> close this client immediately.
				if (msg.contains("Servidor lleno") || msg.contains("Conexion rechazada")) {
					socket.close();
					break;
				}

				if ("Game Over".equalsIgnoreCase(msg.trim())) {
					socket.close();
					break;
				}

				// If it's your turn, ask for a guess and send it.
				if (msg.trim().equals("Turno de " + name)) {
					System.out.print("[Tu turno] Escribe un número (1-100): ");
					String guess = sc.nextLine();
					writer.println(guess);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
