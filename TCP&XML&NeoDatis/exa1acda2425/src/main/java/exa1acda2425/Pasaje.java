package exa1acda2425;

public class Pasaje {
	private Pasajero pasajero;
	private Vuelos identificador;
	private int numAsiento;
	private String clase;
	private float precio;

	public Pasaje(Pasajero pasajero, Vuelos identificador, int numAsiento, String clase, float precio) {
		super();
		this.pasajero = pasajero;
		this.identificador = identificador;
		this.numAsiento = numAsiento;
		this.clase = clase;
		this.precio = precio;
	}
	

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Vuelos getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Vuelos identificador) {
		this.identificador = identificador;
	}

	public int getNumAsiento() {
		return numAsiento;
	}

	public void setNumAsiento(int numAsiento) {
		this.numAsiento = numAsiento;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Pasaje [pasaje=" + pasajero + ", Identificador=" + identificador + ", numAsiento=" + numAsiento
				+ ", clase=" + clase + ", precio=" + precio + "]";

	}
}