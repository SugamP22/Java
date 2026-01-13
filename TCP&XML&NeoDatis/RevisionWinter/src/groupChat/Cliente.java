package groupChat;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class Cliente {
	private Socket socket;
	private String server = "localhost";
	private volatile boolean closed = false;

	public Cliente() throws UnknownHostException, IOException {
		socket = new Socket(server, 7070);
	}

	public boolean isClosed() {
		return closed;
	}

	public Socket getSocket() {
		return socket;
	}

	public static void main(String[] args) {
		try {
			Cliente c = new Cliente();
			c.inciar();
		} catch (IOException e) {
			System.err.println("Error: conexion interrumpida");
		}
	}

	private void inciar() throws IOException {
		new Thread(new Listener(this)).start();
		new Thread(new Writer(this)).start();
	}

	public synchronized void close() {
		if (closed)
			return;
		closed = true;
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
}
