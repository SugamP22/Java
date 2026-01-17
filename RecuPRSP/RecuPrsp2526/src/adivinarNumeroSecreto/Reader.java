package adivinarNumeroSecreto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Reader implements Runnable {
	private BufferedReader br;
	private PrintWriter out;
	private Socket socket;
	private Scanner sc;

	public Reader(Socket socket) throws IOException {
		this.socket = socket;
		sc = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		System.out.print("Introduce tu nombre: ");
		out = new PrintWriter(this.socket.getOutputStream(), true);
		out.println(sc.nextLine());
	}

	@Override
	public void run() {
		String msg = "";
		try {
			while ((msg = br.readLine()) != null) {
				switch (msg) {
				case "Adivina el numero secreto: ":
					adivinarElnumero(msg);
					break;
				case "Has adivinando el numero con exito!!":
					System.out.println(msg);
					return;
				case "Gracias por paticipar!!":
					System.out.println(msg);
					return;
				default:
					System.out.println(msg);
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Always release resources when exiting the client reader.
			closeQuietly();
		}
	}

	private void adivinarElnumero(String msg) {
		System.out.println(msg);
		String num = sc.nextLine();
		if (!num.isEmpty()) {
			try {
				out.println(Integer.parseInt(num));
			} catch (NumberFormatException e) {
				out.println(0);
			}
		}
	}

	private void closeQuietly() {
		try {
			if (out != null) {
				out.close();
			}
			if (br != null) {
				br.close();
			}
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			// Ignore close errors on shutdown
		}
		// Scanner needs explicit close to release System.in resources.
		if (sc != null) {
			sc.close();
		}
	}

}
