package eje04;
// Clase principal donde se ejecuta el programa
public class Main {
	public static void main(String[] args) {
		// Creamos un objeto Asignatura con el nombre "Java"
		Asignatura asignatura = new Asignatura("Java");

		// Creamos un objeto Salario con un salario mensual de 1700.00
		Salario salario = new Salario(1700.00);

		// Creamos un objeto Ejemplo1SinRefactorizar (un "profesor" en este caso)
		// Le pasamos nombre, curso, asignatura y salario
		Ejemplo1SinRefactorizar profesor = new Ejemplo1SinRefactorizar("María", 1, asignatura, salario);

		// Mostramos todos los detalles del objeto profesor
		profesor.mostrarDetalles();
	}
}
