package groupChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listener implements Runnable {
	private BufferedReader br;
	private Cliente cliente;

	public Listener(Cliente cliente) throws IOException {
		this.cliente = cliente;
		br = new BufferedReader(new InputStreamReader(cliente.getSocket().getInputStream()));
	}

	@Override
	public void run() {
		try {
			String msg;
			while (!cliente.isClosed() && (msg = br.readLine()) != null) {
				System.out.println(msg);
				System.out.println("==============================================\n");
			}
		} catch (IOException e) {
			cliente.close();
		}
	}
}
