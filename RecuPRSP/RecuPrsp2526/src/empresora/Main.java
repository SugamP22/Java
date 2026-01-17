package empresora;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) {
		Thread[] processos = new Thread[20];
		Empresora empresora = null;
		try {
			empresora = new Empresora();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < processos.length; i++) {
			processos[i] = new Thread(new Documento("Doc-" + (i + 1), empresora));
			processos[i].start();
		}

	}
}
