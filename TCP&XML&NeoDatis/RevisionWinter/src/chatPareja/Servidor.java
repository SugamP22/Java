package chatPareja;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	private ServerSocket server;
	private Socket socket;
	private Scanner sc = new Scanner(System.in);
	private PrintWriter wr;

	public Servidor(ServerSocket server) {
		this.server = server;
	}

	private void iniciar() {

		try {
			socket = server.accept();
			System.out.println("[Server] nuevo cliente connectado " + socket.getInetAddress());
			wr = new PrintWriter(this.socket.getOutputStream(), true);
			new Listner(socket, "Server").start();
			String msg = "";
			while (true) {
				msg = sc.nextLine();
				wr.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9090);
			System.out.println("[Server] servidor iniciado en la puerta 9090");
			new Servidor(server).iniciar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
