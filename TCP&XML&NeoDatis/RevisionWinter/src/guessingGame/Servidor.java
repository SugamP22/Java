package guessingGame;

import java.io.PrintWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Servidor {
	private final ServerSocket server;
	private final LinkedList<ClienteHandler> socketList;
	private boolean adivinado;
	private final int numParaAdivinar;

	public Servidor(ServerSocket server) {
		this.server = server;
		this.socketList = new LinkedList<>();
		this.adivinado = false;
		this.numParaAdivinar = (int) (Math.random() * 100) + 1;
	}

	public void broadcastExceptOne(ClienteHandler cliente, String msg) {
		for (ClienteHandler ch : socketList) {
			if (ch != cliente) {
				ch.sendMSG(msg);
			}
		}
	}

	public void broadcastToAll(String msg) {
		for (ClienteHandler ch : socketList) {
			ch.sendMSG(msg);
		}
	}

	// Called by ClientHandler when a guess is received
	public synchronized void processGuess(ClienteHandler clienteHandler, String msg) {
		if (adivinado)
			return; // ignore if game is over
		if (socketList.isEmpty())
			return;

		// Enforce turn: only the first player in the queue can guess.
		ClienteHandler current = socketList.peek();
		if (current != clienteHandler) {
			clienteHandler.sendMSG("[Server] No es tu turno. Espera.");
			return;
		}

		int num;
		try {
			num = Integer.parseInt(msg);
		} catch (NumberFormatException e) {
			clienteHandler.sendMSG("[Server] Entrada invalida, intenta de nuevo");
			return;
		}

		broadcastToAll(clienteHandler.getNombre() + " intento: " + num);

		if (num == numParaAdivinar) {
			broadcastToAll("[Server] " + clienteHandler.getNombre() + " ha adivinado! Numero era: " + num);
			adivinado = true;
			endGame();
		} else {
			clienteHandler.sendMSG("[Server] Incorrecto");
			rotateQueue();
		}
	}

	private synchronized void rotateQueue() {
		if (socketList.isEmpty()) {
			return;
		}
		ClienteHandler current = socketList.poll();
		if (current == null) {
			return;
		}
		socketList.add(current);

		// notify next player
		ClienteHandler next = socketList.peek();
		if (next == null) {
			return;
		}
		next.sendMSG("Turno de " + next.getNombre());
		broadcastExceptOne(next, "[Server] Es turno de " + next.getNombre());
	}

	private void endGame() {
		for (ClienteHandler ch : socketList) {
			ch.sendMSG("Game Over");
			ch.closeConnection();
		}
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	private void acceptClients() throws IOException {
		// Accept exactly 3 players for the game.
		while (socketList.size() < 3) {
			Socket socket = server.accept();
			ClienteHandler handler = new ClienteHandler(socket, this);
			socketList.add(handler);
			new Thread(handler).start();
		}
	}

	private void rejectExtraClients() {
		// Keep accepting, but reject any additional players.
		while (!adivinado) {
			try {
				Socket socket = server.accept();
				PrintWriter wr = new PrintWriter(socket.getOutputStream(), true);
				wr.println("[Server] Servidor lleno (max 3 jugadores). Conexion rechazada.");
				wr.close();
				socket.close();
			} catch (IOException e) {
				// If the server socket is closed (endGame), stop the reject loop.
				break;
			}
		}
	}

	public void startGame() {
		// Start the game loop: first player's turn
		ClienteHandler first = socketList.peek();
		first.sendMSG("Turno de " + first.getNombre());
		broadcastExceptOne(first, "[Server] Es turno de " + first.getNombre());
	}

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9090);
			Servidor s = new Servidor(server);
			System.out.println("[Server] Esperando hasta 3 jugadores...");

			s.acceptClients(); // accept 3 clients
			System.out.println("[Server] Todos los jugadores conectados. Empezando juego...");
			s.startGame(); // start turn-based game

			// Reject any extra clients after the game has started.
			s.rejectExtraClients();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
