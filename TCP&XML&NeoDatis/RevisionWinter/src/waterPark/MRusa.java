package waterPark;

import java.util.LinkedList;

public class MRusa {

	private final int totalPersonas;
	private final int capacidadVagon;

	// FIFO: el primero que llega a la cola es el primero que puede subir.
	private final LinkedList<Persona> cola = new LinkedList<>();

	// "Vagón": un array normal de tamaño fijo (en este ejercicio, capacidad=3).
	private final Persona[] vagon;
	private int ocupacion = 0;

	private int viajeNumero = 0;
	private boolean viajeEnMarcha = false;
	private int plazasEnViajeActual = 0;
	private int bajadosEnViajeActual = 0;
	private int completados = 0;

	public MRusa(int totalPersonas, int capacidadVagon) {
		this.totalPersonas = totalPersonas;
		this.capacidadVagon = capacidadVagon;
		this.vagon = new Persona[capacidadVagon];
	}

	/**
	 * FIFO + capacidad:
	 * - Si el vagón está lleno, espera.
	 * - Si NO es tu turno (no eres el primero en la cola), espera.
	 * - Cuando subes, "viajas" un rato y luego bajas, liberando plaza.
	 */
	public void montarYViajar(Persona p) throws InterruptedException {
		final int id = p.getNumBoleto();
		final int miViaje;
		final int miAsiento;

		synchronized (this) {
			cola.addLast(p);
			System.out.println("Persona " + id + " entra en la cola");

			try {
				while (viajeEnMarcha || ocupacion == capacidadVagon || cola.peekFirst() == null || cola.peekFirst() != p) {
					wait();
				}

				// Es su turno, hay hueco y no hay viaje en marcha
				cola.removeFirst(); // sale de la cola FIFO
				miAsiento = ocupacion;
				vagon[miAsiento] = p; // se guarda en el "vagón"
				ocupacion++;
				miViaje = viajeNumero + 1;
				System.out.println("Persona " + id + " sube a la atracción (viaje " + miViaje + ")");

				// Empieza el viaje cuando se llena, o cuando ya han subido todos (último viaje incompleto).
				boolean ultimoGrupo = (completados + ocupacion == totalPersonas);
				if (!viajeEnMarcha && (ocupacion == capacidadVagon || ultimoGrupo)) {
					viajeEnMarcha = true;
					viajeNumero++;
					plazasEnViajeActual = ocupacion;
					bajadosEnViajeActual = 0;
					System.out.println("Viaje " + viajeNumero + " empieza (" + plazasEnViajeActual + " personas)");
					notifyAll(); // despierta a los que ya han subido para que arranque el viaje
				} else {
					notifyAll(); // despierta al siguiente de la cola, si procede
				}

				// Espera hasta que empiece SU viaje
				while (!(viajeEnMarcha && viajeNumero == miViaje)) {
					wait();
				}
			} catch (InterruptedException e) {
				// Si se interrumpe mientras espera, sale de la cola para no bloquear a otros.
				cola.remove(p);
				notifyAll();
				throw e;
			}
		}

		try {
			// Simulación del viaje (fuera del monitor)
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// En esta simulación no gestionamos interrupciones en mitad del viaje.
			throw e;
		}

		synchronized (this) {
			System.out.println("Persona " + id + " sale de la atracción (viaje " + miViaje + ")");
			bajadosEnViajeActual++;
			completados++;

			if (bajadosEnViajeActual == plazasEnViajeActual) {
				// Termina el viaje: se vacía el vagón y se vuelve a permitir subir.
				for (int i = 0; i < ocupacion; i++) {
					vagon[i] = null;
				}
				ocupacion = 0;
				viajeEnMarcha = false;
				plazasEnViajeActual = 0;
				notifyAll();
			} else {
				notifyAll();
			}
		}
	}
}