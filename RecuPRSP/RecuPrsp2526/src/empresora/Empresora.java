package empresora;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Empresora {
	private Socket socket;

	private PrintWriter out;

	private PriorityBlockingQueue<Documento> lista;

	private boolean occupado = false;

	public Empresora() throws UnknownHostException, IOException {
		this.socket = new Socket("localhost", 5001);
		out = new PrintWriter(socket.getOutputStream(), true);
		lista = new PriorityBlockingQueue<Documento>(11, Comparator.comparingInt(Documento::getPriority).reversed());
	}

	synchronized void rellenar(Documento documento) {
		lista.add(documento);
		notifyAll();

	}

	public void entrarParaEmprimir(Documento documneto) {
		System.out.println(documneto.getNombre() + " ready to print || Prioridad: " + documneto.getPriority());
		String msg = "";
		synchronized (this) {
			while (occupado || lista.peek() != documneto) {
				msg = documneto.getNombre() + " no pudo imprimir en este momento";
				System.err.println(msg);
				out.println(msg);
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			occupado = true;
			lista.poll();
		}
		msg = "insertando " + documneto.getNombre() + " para imprimir, Prioridad: " + documneto.getPriority();
		System.out.println(msg);
		out.println(msg);
		gap(100);
		msg = "impriminendo " + documneto.getNombre() + " ....";
		System.out.println(msg);
		out.println(msg);
		gap(documneto.getLongitud());
		msg = documneto.getNombre() + " imprimido con exitó!!";
		System.out.println(msg);
		out.println(msg);

		synchronized (this) {
			occupado = false;
			notifyAll();

		}
	}

	private void gap(int documneto) {
		try {
			Thread.sleep(documneto);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
