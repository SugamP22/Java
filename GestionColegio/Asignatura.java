package actividadEvaluableTema06;

import java.util.Objects;

/**
 * Clase que representa una asignatura en el sistema.
 */
public class Asignatura {

	private String nombreAsignatura; // Nombre de la asignatura
	private String profesor; // Nombre del profesor que imparte la asignatura
	private int credito; // Cantidad de créditos de la asignatura

	/**
	 * Constructor de la clase Asignatura.
	 * @param nombreAsignatura Nombre de la asignatura.
	 * @param profesor Nombre del profesor de la asignatura.
	 * @param credito Número de créditos de la asignatura.
	 */
	public Asignatura(String nombreAsignatura, String profesor, int credito) {
		this.nombreAsignatura = nombreAsignatura;
		this.profesor = profesor;
		this.credito = credito;
	}

	/**
	 * Obtiene el nombre de la asignatura.
	 * @return Nombre de la asignatura.
	 */
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	/**
	 * Establece un nuevo nombre para la asignatura.
	 * @param nombreAsignatura Nuevo nombre de la asignatura.
	 */
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	/**
	 * Obtiene el nombre del profesor de la asignatura.
	 * @return Nombre del profesor.
	 */
	public String getProfesor() {
		return profesor;
	}

	/**
	 * Establece un nuevo nombre de profesor para la asignatura.
	 * @param profesor Nuevo nombre del profesor.
	 */
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	/**
	 * Obtiene el número de créditos de la asignatura.
	 * @return Número de créditos.
	 */
	public int getCredito() {
		return credito;
	}

	/**
	 * Establece un nuevo número de créditos para la asignatura.
	 * @param credito Nuevo número de créditos.
	 */
	public void setCredito(int credito) {
		this.credito = credito;
	}

	/**
	 * Devuelve una representación en cadena de la asignatura.
	 * @return Cadena con la información de la asignatura.
	 */
	@Override
	public String toString() {
		return "Asignatura [nombreAsignatura=" + nombreAsignatura + ", profesor=" + profesor + ", credito=" + credito + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(credito, nombreAsignatura, profesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return credito == other.credito && Objects.equals(nombreAsignatura, other.nombreAsignatura)
				&& Objects.equals(profesor, other.profesor);
	}
}

