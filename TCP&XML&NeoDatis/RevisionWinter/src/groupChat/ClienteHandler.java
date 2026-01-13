package groupChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ClienteHandler extends Thread {
	private String nombre;
	private Servidor servidor;
	private BufferedReader br;
	private PrintWriter wr;

	public ClienteHandler(Servidor servidor) throws IOException {
		this.servidor = servidor;
		this.br = new BufferedReader(new InputStreamReader(this.servidor.getCliente().getInputStream()));
		this.wr = new PrintWriter(this.servidor.getCliente().getOutputStream(), true);
		nombre = br.readLine();
		this.servidor.broadCastTOExcept(this, "\n" + nombre + " has entered the chat room");
	}

	public String getNombre() {
		return nombre;
	}

	public void sendmsg(String msg) {
		wr.println(msg);

	}

	public void close() throws IOException {
		wr.close();
		br.close();
		servidor.getCliente().close();
	}

	@Override
	public void run() {
		String msg = "";
		try {
			while ((msg = br.readLine()) != null) {
				if (msg.equalsIgnoreCase("Exit")) {
					servidor.exit(this);
					return;
				}
				servidor.broadCastTOExcept(this, "\n[" + nombre + "] -> " + msg);
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
