package examenSegundoTremestre;

import java.time.LocalDate;

public class Productos {
	protected LocalDate fechaDeCaducidad;
	protected int numeroLote;

	public Productos(LocalDate fechaDeCaducidad, int numeroLote) {
		this.fechaDeCaducidad = fechaDeCaducidad;
		this.numeroLote = numeroLote;
	}

	public LocalDate getFechaDeCaducidad() {
		return fechaDeCaducidad;
	}

	public void setFechaDeCaducidad(LocalDate fechaDeCaducidad) {
		this.fechaDeCaducidad = fechaDeCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	@Override
	public String toString() {
		return "fechaDeCaducidad=" + fechaDeCaducidad + ", numeroLote=" + numeroLote + ", ";
	}

}
