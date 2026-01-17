package adivinarNumeroSecreto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteHandler implements Runnable {
	private final Socket socket;
	private BufferedReader br;
	private PrintWriter out;
	private String nombre;
	private Juego juego;

	public ClienteHandler(Juego juego, Socket socket) {
		this.juego = juego;
		this.socket = socket;
		try {
			this.out = new PrintWriter(this.socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			nombre = br.readLine();
			juego.broadExceptOne(this, nombre + " entrado en el juego!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void run() {
		while (!juego.isTerminated()) {
			juego.rellanarJugadores(this);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			juego.startGame(this);
		}
		System.out.println("Juego terminado saliendo...");
		try {
			br.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMSG(String string) {
		out.println(string);

	}

	public int recieveNumeroSecreto() {
		String msg = null;
		try {
			msg = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Client may disconnect or send invalid data; return sentinel instead of crashing.
		if (msg == null) {
			return -1;
		}
		try {
			return Integer.parseInt(msg);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
