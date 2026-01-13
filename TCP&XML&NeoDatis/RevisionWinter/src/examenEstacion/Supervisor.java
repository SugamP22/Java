package examenEstacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Supervisor implements Runnable {
	private int id;
	private Estacion estacion;
	private Socket cliente;
	private int port;
	private PrintWriter writer;

	public int getId() {
		return id;
	}

	public Supervisor(int id, Estacion estacion) {
		this.id = id;
		this.estacion = estacion;
		this.port = 5000;
		try {
			cliente = new Socket("localhost", port);
			writer = new PrintWriter(cliente.getOutputStream(), true);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void escribirmsg(String msg) {
		writer.println(msg);

	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				estacion.inspeccionar(this);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		writer.close();
		try {
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
