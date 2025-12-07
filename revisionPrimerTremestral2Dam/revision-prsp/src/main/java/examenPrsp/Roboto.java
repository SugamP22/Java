package examenPrsp;

import java.util.Objects;

public class Roboto implements Runnable {
	private String nombre;
	private final int prioridad;
	private Estacion estacion;
	private int ronda = 0;

	public int getPrioridad() {
		return prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public Roboto(Estacion estacion, String string) {
		prioridad = (int) (Math.random() * 4);
		this.estacion = estacion;
		this.nombre = string;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
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
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public void run() {
		estacion.rellenar(this);
		for (int i = 0; i < 5; i++) {
			estacion.cargar(this);
		}
	}

	public void aniadirRonda() {
		ronda++;
	}

	public int getRonda() {
		return ronda;
	}

}
