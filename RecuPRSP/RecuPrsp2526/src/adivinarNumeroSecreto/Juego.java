package adivinarNumeroSecreto;

import java.util.LinkedList;

public class Juego {
	private final LinkedList<ClienteHandler> listaCliente;
	private final int numParaAdivinar;
	private boolean terminated = false;

	public boolean isTerminated() {
		return terminated;
	}

	public Juego() {
		listaCliente = new LinkedList<>();
		numParaAdivinar = (int) ((Math.random() * 100) + 1);

	}

	public void broadExceptOne(ClienteHandler clienteHandler, String string) {
		for (ClienteHandler clienteHandler1 : listaCliente) {
			if (clienteHandler1 != clienteHandler) {
				clienteHandler1.sendMSG(string);
			}
		}
	}

	public void broadcastToAll(String string) {
		for (ClienteHandler clienteHandler : listaCliente) {
			clienteHandler.sendMSG(string);
		}
	}

	public void startGame(ClienteHandler clienteHandler) {
		synchronized (this) {
			// If the game finished while someone was waiting, stop waiting and exit cleanly.
			while (!terminated && (listaCliente.peek() != clienteHandler || listaCliente.size() != 3)) {
				clienteHandler.sendMSG("No es tu turno espera...");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (terminated) {
				return;
			}
			listaCliente.poll();

		}
		broadExceptOne(clienteHandler, clienteHandler.getNombre() + " esta adivinando el numero secreto");
		clienteHandler.sendMSG("Adivina el numero secreto: ");
		checkNum(clienteHandler);

	}

	public void rellanarJugadores(ClienteHandler clienteHandler) {
		synchronized (this) {
			listaCliente.add(clienteHandler);
			notifyAll();
		}

	}

	public synchronized void checkNum(ClienteHandler clienteHandler) {
		int num = clienteHandler.recieveNumeroSecreto();
		// -1 means invalid input or disconnect; avoid crashing and wake others.
		if (num < 0) {
			clienteHandler.sendMSG("Entrada invalida o desconexion detectada.");
			notifyAll();
			return;
		}
		if (num == numParaAdivinar) {
			clienteHandler.sendMSG("Has adivinando el numero con exito!!");
			broadExceptOne(clienteHandler, clienteHandler.getNombre()
					+ " Adivinado el numero secreto con exit�!! \nNumero Secreto: " + numParaAdivinar);
			terminated = true;
			// Broadcast final message so all clients can exit.
			broadcastToAll("Gracias por paticipar!!");

		} else if (num != numParaAdivinar) {
			clienteHandler.sendMSG("No pudiste adivinar el numero secreto correctamente");
			broadExceptOne(clienteHandler, clienteHandler.getNombre()
					+ " No pudo adivinar el numero secreto\nNumero Secreto: " + numParaAdivinar);
		}
		notifyAll();
	}
}
