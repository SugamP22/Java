package actividadEvaluableTema06;

/**
 * Clase que representa a un miembro del personal.
 */
public class Personal {
	private String nombre; // Nombre del personal

	/**
	 * Constructor de la clase Personal.
	 * @param nombre Nombre del personal.
	 */
	public Personal(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el nombre del personal.
	 * @return Nombre del personal.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece un nuevo nombre para el personal.
	 * @param nombre Nuevo nombre del personal.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve una representación en cadena del objeto Personal.
	 * Incluye el nombre y la indicación de que es "personal interno".
	 * @return Cadena con la información del personal.
	 */
	@Override
	public String toString() {
		return "Nombre: " + nombre + " (Personal interno)";
	}
}
