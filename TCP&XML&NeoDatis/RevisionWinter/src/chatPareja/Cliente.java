package chatPareja;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*1. En parejas, crear un sistema de comunicaciones siguiendo el modelo Cliente-Servidor que
permita la comunicación bidireccional entre un cliente y un servidor. Deberá permitir que
ambos escriban cuando quieran, sin un orden de pregunta respuesta.
Un miembro de la pareja implementará el cliente y otro el servidor.
*/
public class Cliente {
	private int port;
	private Socket socket;
	private PrintWriter wr;
	private Scanner sc = new Scanner(System.in);

	public Cliente() {
		try {
			this.port = 9090;
			socket = new Socket("localhost", port);
			wr = new PrintWriter(this.socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciar() {
		Listner listner = new Listner(socket, "Cliente");
		listner.start();
		String msg = "";
		while (true) {
			msg = sc.nextLine();
			wr.println(msg);
		}
	}

	public static void main(String[] args) {
		new Cliente().iniciar();
	}
}
