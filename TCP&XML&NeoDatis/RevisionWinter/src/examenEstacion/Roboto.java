package examenEstacion;

import java.util.Objects;

public class Roboto implements Runnable {
	private int prioridad;
	private int id;
	private Estacion estacion;

	public int getPrioridad() {
		return prioridad;
	}

	public int getId() {
		return id;
	}

	public Roboto(int id, Estacion estacion) {
		// TODO Auto-generated constructor stub
		this.prioridad = (int) (Math.random() * 3);
		this.id = id;
		this.estacion = estacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roboto other = (Roboto) obj;
		return id == other.id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			estacion.rellenar(this);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				estacion.cargar(this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Roboto-" + id + " terminando de cargar!! | Prioridad: " + prioridad);
		estacion.resetRegistrado(this);

	}

}
