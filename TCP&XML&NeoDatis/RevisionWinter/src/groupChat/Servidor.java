package groupChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Servidor {
	private Socket cliente;
	private ServerSocket server;
	private LinkedList<ClienteHandler> listaClientes;

	public Socket getCliente() {
		return cliente;
	}

	public Servidor() throws IOException {
		// TODO Auto-generated constructor stub
		this.server = new ServerSocket(7070);
		listaClientes = new LinkedList<>();
		System.out.println("[Servidor] servidor iniciado en la puerta " + server.getLocalPort());
	}

	public synchronized void exit(ClienteHandler c) throws IOException {
		for (ClienteHandler clienteHandler : listaClientes) {
			if (c == clienteHandler) {
				broadCastTOExcept(c, "\n" + c.getNombre() + "has left the chat");
				clienteHandler.close();
			}
		}
	}

	public void broadCastTOAll(String msg) {

		for (ClienteHandler clienteHandler : listaClientes) {
			clienteHandler.sendmsg(msg);
		}

	}

	private void accepClientes() throws IOException {
		while (true) {
			cliente = server.accept();
			ClienteHandler c = new ClienteHandler(this);
			c.start();
			listaClientes.add(c);
		}

	}

	public static void main(String[] args) {
		try {
			Servidor servidor = new Servidor();
			servidor.accepClientes();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	public void broadCastTOExcept(ClienteHandler c, String string) {
		for (ClienteHandler clienteHandler : listaClientes) {
			if (clienteHandler != c) {
				clienteHandler.sendmsg(string);
			}
		}

	}

}
