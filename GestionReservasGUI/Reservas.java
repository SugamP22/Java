package activivdadJOption;

import java.time.LocalDate;	


public class Reservas {
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private Habitacion habitacion;
	private Huespeda huespeda;

	public Reservas(LocalDate fechaEntrada, LocalDate fechaSalida, Habitacion habitacion, Huespeda huespeda) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.habitacion = habitacion;
		this.huespeda = huespeda;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Huespeda getHuespeda() {
		return huespeda;
	}

	public void setHuespeda(Huespeda huespeda) {
		this.huespeda = huespeda;
	}

	@Override
	public String toString() {
		return "Reservas [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", habitacion=" + habitacion
				+ ", huespeda=" + huespeda + "]";
	}

}
