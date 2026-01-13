package printer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Empresora {
	private boolean occupied;
	private PriorityQueue<Documento> cola;

	public Empresora() {
		cola = new PriorityQueue<>(Comparator.comparingInt(Documento::getPrioridad).reversed());// documento::getPrioridad
		occupied = false;// si tu quiere 5 4 3 1
	}

	public void iniciar(Documento documento) {
		String nombre = documento.getNombre();
		System.out.println(nombre + "entrando para emprimir....");
		synchronized (this) {
			while (occupied || !cola.peek().equals(documento)) {
				if (occupied) {
					System.err.println(nombre + " No puede entrar en este momento por que esta en processo");
				}
				if (cola.peek() != documento) {
					System.err
							.println(nombre + " No puede entrar en este momento por que hay otras con mayor prioridad");

				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			cola.poll();
			occupied = true;

		}
		System.out.println(nombre + " Esta emprimiendo | Prioridad: " + documento.getPrioridad());
		gap();
		System.out.println(nombre + " Ya sale de empresora , empresora esta libre");
		synchronized (this) {
			occupied = false;
			
				
			
			notifyAll();
		}

	}

	private void gap() {
		try {
			Thread.sleep((int) (Math.random() * (2000 - 1000 + 1)) + 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public synchronized void rellanarCola(Documento documento) {
		cola.add(documento);
	}

}
