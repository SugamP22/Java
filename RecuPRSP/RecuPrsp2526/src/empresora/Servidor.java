package empresora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private ServerSocket server;
	private Socket socket;
	private BufferedReader br;

	public Servidor() throws IOException {
		server = new ServerSocket(5001);
	}

	private void aceptarCliente() throws IOException {
		socket = server.accept();
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("Nuevo cliente entrado: " + socket.getInetAddress());
	}

	private void leerMsg() {
		String msg = "";
		try {
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				socket.close();
				System.out.println("Conexion con cliente terminado");
				System.out.println("Servidor cerrado con exitó");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			Servidor s = new Servidor();
			System.out.println("Servidor inciado con exitó");
			s.aceptarCliente();
			s.leerMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
