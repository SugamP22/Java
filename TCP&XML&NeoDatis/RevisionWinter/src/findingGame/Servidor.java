package findingGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Servidor {

	private final ServerSocket server;
	private final LinkedList<ClienteHandler> listaSockets;
	private final int numParaAdivinar;
	private boolean adivinado;
	private final int port = 8080;

	public Servidor() throws IOException {
		server = new ServerSocket(port);
		System.out.println("Serividor iniciado en la puerta 8080");
		listaSockets = new LinkedList<>();
		numParaAdivinar = (int) ((Math.random() * 100) + 1);
		adivinado = false;
	}

	private void acceptClientes() throws IOException {
		while (listaSockets.size() < 3) {
			Socket cliente = server.accept();
			ClienteHandler ch = new ClienteHandler(cliente, this);
			new Thread(ch).start();
			synchronized (this) {
				listaSockets.add(ch);
				notifyAll();
			}
		}
	}

	public void chooseSocket(ClienteHandler clienteHandler) throws InterruptedException, IOException {

		while (!adivinado) {

			synchronized (this) {
				while (!adivinado && (listaSockets.size() != 3 || listaSockets.peek() != clienteHandler)) {
					if (!adivinado && listaSockets.size() == 3 && listaSockets.peek() != clienteHandler) {
						clienteHandler.sendMSG("No es tu turno, espera...");
					}
					if (!adivinado && listaSockets.size() != 3) {
						clienteHandler.sendMSG("Esperando para jugadores... || ("+listaSockets.size()+"/"+3+")");

					}
					wait();
				}

				if (adivinado)
					return;
			}
			clienteHandler.sendMSG("\n[Tu turno] adivina el numero (1-100): ");

			String msg = clienteHandler.getBr().readLine();
			if (msg == null) {
				handleDisconnect(clienteHandler, "se desconecto");
				return;
			}

			try {
				int num = Integer.parseInt(msg);

				synchronized (this) {
					broadcastExceptOne(clienteHandler, clienteHandler.getNombre() + " intenta: " + num);

					if (num == numParaAdivinar) {
						shutdown(clienteHandler.getNombre() + " ganó. Numero secreto: " + numParaAdivinar);
						return;
					}

					// Rotate turn ONLY after we know the guess was incorrect.
					ClienteHandler current = listaSockets.poll();
					if (current != null) {
						listaSockets.add(current);
					}

					clienteHandler.sendMSG("\nIncorrecto");
					notifyAll();
				}

			} catch (NumberFormatException e) {
				clienteHandler.sendMSG("\nNumero invalido");
			}
		}
	}

	/**
	 * Called when a client disconnects or crashes. Ends the game cleanly for everyone.
	 */
	public void handleDisconnect(ClienteHandler ch, String reason) {
		synchronized (this) {
			listaSockets.remove(ch);
			notifyAll();
		}
		shutdown("Jugador " + ch.getNombre() + " " + reason + ". Game Over.");
	}

	public void broadcastAll(String msg) {
		List<ClienteHandler> snapshot;
		synchronized (this) {
			snapshot = new ArrayList<>(listaSockets);
		}
		for (ClienteHandler ch : snapshot) {
			ch.sendMSG(msg);
		}
	}

	public void broadcastExceptOne(ClienteHandler cliente, String msg) {
		List<ClienteHandler> snapshot;
		synchronized (this) {
			snapshot = new ArrayList<>(listaSockets);
		}
		for (ClienteHandler ch : snapshot) {
			if (ch != cliente) {
				ch.sendMSG(msg);
			}
		}
	}

	/**
	 * End the game: broadcast a final message, then close all sockets.
	 */
	private void shutdown(String finalMsg) {
		synchronized (this) {
			adivinado = true;
			notifyAll();
		}

		// Best-effort: message first, then close sockets.
		if (finalMsg != null && !finalMsg.isEmpty()) {
			broadcastAll(finalMsg);
		}
		broadcastAll("Game Over");

		List<ClienteHandler> snapshot;
		synchronized (this) {
			snapshot = new ArrayList<>(listaSockets);
		}
		for (ClienteHandler ch : snapshot) {
			try {
				ch.closeConexion();
			} catch (IOException ignored) {
			}
		}
		try {
			server.close();
		} catch (IOException ignored) {
		}
	}

	public static void main(String[] args) {
		try {
			Servidor s = new Servidor();
			System.out.println("[Server] Esperando 3 jugadores...");
			s.acceptClientes();
		} catch (IOException e) {
			System.err.println("[Server] Error: " + e.getMessage());
		}
	}
}


