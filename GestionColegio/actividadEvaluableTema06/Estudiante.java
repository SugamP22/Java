package actividadEvaluableTema06;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * Clase que representa un estudiante en la sistema
 * 
 */
public class Estudiante extends Personal {
	private HashMap<Asignatura, EstadoAsignatura> asignaturas;

	// Constructor de la clase Estudiante
	public Estudiante(String nombre) {
		super(nombre); // Llama al constructor de la superclase Personal
		this.asignaturas = new HashMap<>(); // Inicializa el HashMap para almacenar asignaturas y sus estados
	}

	/**
	 * Método para añadir una asignatura al estudiante.
	 * 
	 * @param asignatura Asignatura a añadir.
	 * @param estado     Estado de la asignatura.
	 * @return false si se añade correctamente, true si la asignatura ya existía.
	 */
	public boolean anadirAsignaturas(Asignatura asignatura, EstadoAsignatura estado) {

		return asignaturas.put(asignatura, estado) != null;

	}

	/**
	 * Método para borrar una asignatura del estudiante.
	 * 
	 * @param asignatura Asignatura a eliminar.
	 * @return 1 si la lista está vacía, 2 si se elimina correctamente, 3 si no se
	 *         encontró la asignatura.
	 */
	public int borrarAsignatura(Asignatura asignatura) {
		if (asignaturas.isEmpty())
			return 1; // Retorna 1 si no hay asignaturas registradas

		// remove() devuelve null si la clave no existe, lo que nos ayuda a saber si se
		// eliminó o no
		return asignaturas.remove(asignatura) != null ? 2 : 3;
	}

	/**
	 * Método para mostrar todas las asignaturas registradas del estudiante.
	 */
	public void mostrarAsignaturas() {
		if (asignaturas.isEmpty()) {
			System.err.println("Error: No tiene ninguna asignatura registrada.");
			return;
		}

		System.out.println("\nLista de asignaturas guardadas:");
		for (Map.Entry<Asignatura, EstadoAsignatura> entrada : asignaturas.entrySet()) {
			System.out.printf(
					"| Nombre Asignatura: %-15s | Nombre profesor: %-15s | Créditos: %-15d | Estado asignatura: %-15s\n",
					entrada.getKey().getNombreAsignatura(), entrada.getKey().getProfesor(),
					entrada.getKey().getCredito(), entrada.getValue());
		}
	}

}
