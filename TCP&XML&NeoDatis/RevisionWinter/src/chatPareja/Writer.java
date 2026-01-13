package chatPareja;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Writer extends Thread {
	private Socket socket;
	private PrintWriter wr;
	private Scanner sc = new Scanner(System.in);

	public Writer(Socket socket) {
		try {
			this.socket = socket;
			this.wr = new PrintWriter(this.socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String msg = "";
		while (true) {
			msg = sc.nextLine();
			wr.println(msg);
		}
	}
}
