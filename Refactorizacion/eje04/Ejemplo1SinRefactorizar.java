package eje04;
// Clase de ejemplo (sin refactorizar) que agrupa información de una persona con nombre, curso, asignatura y salario
public class Ejemplo1SinRefactorizar {
	private String nombre;        // Nombre de la persona (puede ser un alumno o profesor)
	private int curso;            // Número de curso (por ejemplo: 1º, 2º, 3º, etc.)
	private Asignatura asignatura; // Objeto Asignatura asociado (la materia que tiene)
	private Salario salario;      // Objeto Salario asociado (su salario)

	// Constructor que recibe todos los datos y los asigna a los atributos
	public Ejemplo1SinRefactorizar(String nombre, int curso, Asignatura asignatura, Salario salario) {
		this.nombre = nombre;
		this.curso = curso;
		this.asignatura = asignatura;
		this.salario = salario;
	}

	// Método que muestra por consola todos los detalles del objeto
	public void mostrarDetalles() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Curso: " + curso);
		System.out.println("Asignatura: " + asignatura); // Esto usa el toString() de Asignatura
		System.out.println("Salario: " + salario);       // Esto usa el toString() de Salario
	}
}
