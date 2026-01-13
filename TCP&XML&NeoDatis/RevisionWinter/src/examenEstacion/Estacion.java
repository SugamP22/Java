package examenEstacion;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Estacion {

	private Set<Roboto> registrados;
	private PriorityQueue<Roboto> cola;

	// Track station occupancy
	private boolean robotInside;
	private int supervisorsInside;

	public Estacion() {
		registrados = new HashSet<>();
		cola = new PriorityQueue<>(Comparator.comparingInt(Roboto::getPrioridad));
		robotInside = false;
		supervisorsInside = 0;
	}

	public void rellenar(Roboto roboto2) {
		synchronized (this) {
			if (!registrados.contains(roboto2)) {
				System.out.println("Roboto-" + roboto2.getId() + " entrando en la cola");
				registrados.add(roboto2);
				cola.add(roboto2);
				notifyAll();
			}
		}
	}

	// Robot logic
	public void cargar(Roboto roboto2) throws InterruptedException {
		int id = roboto2.getId();
		synchronized (this) {
			while (robotInside || supervisorsInside > 0 || !cola.peek().equals(roboto2)) {
				if (!cola.peek().equals(roboto2)) {
					System.err.println("Roboto-" + id + " esperando en la cola...");
				}
				if (robotInside) {
					System.err.println("Roboto-" + id + " esperando, estacion ocupada por otro robot");
				}
				if (supervisorsInside > 0) {
					System.err.println("Roboto-" + id + " esperando, supervisor(es) en la estacion");
				}
				wait();
			}
			robotInside = true;
		}

		System.out.println("Roboto-" + id + " entrando en la estacion");
		gap();
		System.out.println("Roboto-" + id + " esta cargando en la estacion");
		gap();
		System.out.println("Roboto-" + id + " saliendo de la estacion");
		gap();

		synchronized (this) {
			robotInside = false;
		}
	}

	public void resetRegistrado(Roboto roboto) {
		synchronized (this) {
			registrados.remove(roboto);
			cola.poll();
			notifyAll();
		}
	}

	// Supervisor logic
	public void inspeccionar(Supervisor supervisor) throws InterruptedException {
		int id = supervisor.getId();
		String msg = "";
		synchronized (this) {
			while (robotInside) {
				System.err.println("Supervisor-" + id + " esperando, robot en la estacion...");
				wait();
			}
			supervisorsInside++;
		}

		msg = "Supervisor-" + id + " entrado en la estacion";
		System.out.println(msg);
		supervisor.escribirmsg(msg);
		gap();
		msg = "Supervisor-" + id + " esta inspeccionando...";
		System.out.println(msg);
		supervisor.escribirmsg(msg);
		gap();
		msg = "Supervisor-" + id + " esta saliendo de la estacion...";
		System.out.println(msg);
		supervisor.escribirmsg(msg);
		gap();

		synchronized (this) {
			supervisorsInside--; // Supervisor leaves
			notifyAll();
		}
	}

	// Helper for random delay
	private void gap() {
		try {
			Thread.sleep((int) ((Math.random() * 301) + 200));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
