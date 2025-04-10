package actividadCasa;

import java.time.LocalDate;

public class Reservas {
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private Habitaciones habitaciones;
	private Huespedes huespedes;

	public Reservas(LocalDate fechaEntrada, LocalDate fechaSalida, Habitaciones habitaciones, Huespedes huespedes) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.habitaciones = habitaciones;
		this.huespedes = huespedes;
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

	public Habitaciones getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitaciones habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Huespedes getHuespedes() {
		return huespedes;
	}

	public void setHuespedes(Huespedes huespedes) {
		this.huespedes = huespedes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaEntrada == null) ? 0 : fechaEntrada.hashCode());
		result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + ((habitaciones == null) ? 0 : habitaciones.hashCode());
		result = prime * result + ((huespedes == null) ? 0 : huespedes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservas other = (Reservas) obj;
		if (fechaEntrada == null) {
			if (other.fechaEntrada != null)
				return false;
		} else if (!fechaEntrada.equals(other.fechaEntrada))
			return false;
		if (fechaSalida == null) {
			if (other.fechaSalida != null)
				return false;
		} else if (!fechaSalida.equals(other.fechaSalida))
			return false;
		if (habitaciones == null) {
			if (other.habitaciones != null)
				return false;
		} else if (!habitaciones.equals(other.habitaciones))
			return false;
		if (huespedes == null) {
			if (other.huespedes != null)
				return false;
		} else if (!huespedes.equals(other.huespedes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservas [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", habitaciones="
				+ habitaciones + ", huespedes=" + huespedes + "]";
	}
	
	

}
