package adivinarNumeroSecreto;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	private Socket socket;

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		try {
			cliente.iniciar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void iniciar() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 5001);
		new Thread(new Reader(socket)).start();
	}
}
