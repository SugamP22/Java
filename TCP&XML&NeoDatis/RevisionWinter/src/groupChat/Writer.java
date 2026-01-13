package groupChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Writer implements Runnable {
	private PrintWriter wr;
	private Cliente cliente;
	private Scanner sc = new Scanner(System.in);

	public Writer(Cliente cliente) throws IOException {
		this.cliente = cliente;
		wr = new PrintWriter(cliente.getSocket().getOutputStream(), true);

		System.out.print("Introduce tu nombre: ");
		wr.println(sc.nextLine());
	}

	@Override
	public void run() {
		try {
			while (!cliente.isClosed()) {
				String msg = sc.nextLine();
				wr.println(msg);
				if (msg.equalsIgnoreCase("Exit")) {
					cliente.close();
					break;
				}
			}
		} catch (Exception e) {
			cliente.close();
		} finally {
			wr.close();
		}
	}
}
