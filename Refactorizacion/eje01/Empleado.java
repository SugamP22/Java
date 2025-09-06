package eje01;

/**
 * Clase que representa un empleado en una empresa.
 * 
 * Contiene información sobre el nombre y salario, además de métodos para
 * obtener y modificar esos datos, así como calcular el salario anual.
 * 
 * @author
 * @version 1.1
 */
public class Empleado {

	// Atributos privados de la clase
	private String nombre;// guarda nombre de empleado
	private double salario;// guarda salario de empleado

	/**
	 * Constructor de la clase Empleado.
	 * 
	 * @param nombre  Nombre del empleado.
	 * @param salario Salario mensual del empleado.
	 * @throws IllegalArgumentException si el salario es negativo.
	 */
	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		setSalario(salario); // Usar el setter para validar
	}

//uso de metodo getters y setters para poder llamar por otro clase
	/**
	 * Obtiene el nombre del empleado.
	 * 
	 * @return El nombre del empleado.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre del empleado.
	 * 
	 * @param nombre Nuevo nombre del empleado.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el salario mensual del empleado.
	 * 
	 * @return El salario mensual del empleado.
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Establece un nuevo salario para el empleado. No permite valores negativos.
	 * 
	 * @param salario Nuevo salario del empleado.
	 * @throws IllegalArgumentException si el salario es negativo.
	 */

	public void setSalario(double salario) {
		if (salario < 0) {
			throw new IllegalArgumentException("El salario no puede ser negativo.");
		}
		this.salario = salario;
	}

	/**
	 * Calcula el salario anual del empleado.
	 * 
	 * @return Salario anual multiplicado por 12.
	 */

	public double calcularSalarioAnual() {
		return salario * 12;
	}

	/**
	 * Método principal para pruebas rápidas.
	 * 
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {
		Empleado emp = new Empleado("Carlos", 2500);// Crear un objeto Empleado con el nombre "Carlos" y salario 2500
		System.out.println(emp);// Mostrar el objeto empleado
		System.out.println("Salario anual: " + emp.calcularSalarioAnual());// Mostrar el salario anual del empleado
	}
}
