package estacionDeRobotYSupervisor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Supervision implements Runnable {
	private String nombre;
	private Estacion estacion;
	private PrintWriter out;
	private Socket socket;

	public String getNombre() {
		return nombre;
	}

	public Supervision(String nombre, Estacion estacion) {
		try {
			socket = new Socket("localhost", 5001);
			out = new PrintWriter(socket.getOutputStream(), true);
			out.print(nombre);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.nombre = nombre;
		this.estacion = estacion;

	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			estacion.inspeccionar(this);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enviarmsg(String msg) {
		out.println(msg);
	}
}
