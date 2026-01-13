package chatPareja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Listner extends Thread {
	private Socket socket;
	private BufferedReader br;
	private String name;

	public Listner(Socket socket, String name) {
		try {
			this.name = name;
			this.socket = socket;
			this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String msg = "";
		try {
			while ((msg = br.readLine()) != null) {
				System.out.printf("[%s]:: %s \n", name, msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
