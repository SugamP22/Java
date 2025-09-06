package eje04;
// Clase que representa una asignatura (una materia o curso)
public class Asignatura {
	private String nombre; // Atributo para guardar el nombre de la asignatura

	// Constructor: recibe el nombre de la asignatura al crear el objeto
	public Asignatura(String nombre) {
		this.nombre = nombre;
	}

	// Getter: permite obtener el nombre de la asignatura
	public String getNombre() {
		return nombre;
	}

	// Setter: permite cambiar el nombre de la asignatura
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Método toString: devuelve un texto representando la asignatura
	// Útil para mostrarlo por consola o depuración
	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + "]";
	}
}
