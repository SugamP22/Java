package estacionDeRobotYSupervisor;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Estacion {
	private boolean robotoDentro = false;
	private PriorityQueue<Roboto> listaRoboto;
	private int inspectorInside = 0;

	public Estacion() {
		listaRoboto = new PriorityQueue<>(Comparator.comparingInt(Roboto::getPriority));
	}

	public void entrarEstacion(Roboto roboto) {
		System.out.println(roboto.getNombre() + " Esta entranado en la cola...");
		synchronized (this) {
			listaRoboto.add(roboto);
			notifyAll();
		}
	}

	public void cargar(Roboto roboto) {
		String nombre = roboto.getNombre();
		synchronized (this) {
			while (robotoDentro || inspectorInside > 0 || !(listaRoboto.peek().equals(roboto))) {
				if (robotoDentro)
					System.err.println(
							"Estacion occupado " + nombre + " con prioridad " + roboto.getPriority() + " esperando...");

				if (inspectorInside > 0) {
					System.err.println(nombre + " inspection en la marcha esta esperando...");
				}
				if (!(listaRoboto.peek().equals(roboto)))
					System.err
							.println(nombre + " con prioridad " + roboto.getPriority() + " esperando para su turno...");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			robotoDentro = true;
			listaRoboto.poll();

		}
		System.out.println(nombre + " Prioridad: " + roboto.getPriority() + ", entrando para cargar...");
		gap();
		System.out.println(nombre + " cargado completamente, saliendo...");
		gap();
		synchronized (this) {
			robotoDentro = false;
			notifyAll();
		}
	}

	private void gap() {
		try {
			Thread.sleep((int) (Math.random() * 201) + 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void inspeccionar(Supervision supervision) {
		String nombre = supervision.getNombre();
		String msg = "";
		msg = nombre + " buscando hueco para inspeccionar";
		System.out.println(nombre + " buscando hueco para inspeccionar");
		supervision.enviarmsg(msg);
		synchronized (this) {
			while (robotoDentro || inspectorInside >= 2) {
				try {
					System.err.println(nombre + " esperando en la cola hasta que el no hay nadie en la estacion");
					supervision.enviarmsg(msg);
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			inspectorInside++;
		}
		System.out.println(nombre + " esta dentro para especcionar...");
		msg = nombre + " esta dentro para especcionar...";
		supervision.enviarmsg(msg);
		gap();
		System.out.println(nombre + " terminando de inspeccionar...");
		msg = nombre + " terminando de inspeccionar...";
		supervision.enviarmsg(msg);
		gap();
		System.out.println(nombre + " Saliendo...");
		msg = nombre + " Saliendo...";
		supervision.enviarmsg(msg);
		gap();
		synchronized (this) {
			inspectorInside--;
			notifyAll();

		}

	}
}
