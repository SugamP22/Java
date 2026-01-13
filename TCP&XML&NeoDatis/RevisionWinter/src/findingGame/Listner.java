package findingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Listner implements Runnable {

	private final Socket socket;
	private final PrintWriter wr;
	private final BufferedReader br;
	private final Scanner sc;

	public Listner(Socket socket) throws IOException {
		this.socket = socket;
		wr = new PrintWriter(socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		sc = new Scanner(System.in);

		System.out.print("Introduce tu nombre: ");
		String nombre = sc.nextLine();
		wr.println(nombre);
	}

	@Override
	public void run() {
		String msg;
		try {
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);

				if ("Game Over".equalsIgnoreCase(msg.trim()) || msg.toLowerCase().contains("game over")) {
					break;
				}

				if (msg.contains("[Tu turno]")) {
					System.out.print("> ");
					wr.println(sc.nextLine());
				}
			}
		} catch (IOException e) {
			System.err.println("Conexion perdida");
		} finally {
			try {
				socket.close();
			} catch (IOException ignored) {
			}
		}
	}

}


