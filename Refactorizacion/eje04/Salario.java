package eje04;
// Clase que representa el salario de un empleado
public class Salario {
	private double salarioEmpleado; // Atributo que guarda el salario mensual del empleado

	// Constructor: recibe un valor y lo asigna al salario
	public Salario(double salario) {
		this.salarioEmpleado = salario;
	}

	// Getter: permite obtener el salario actual
	public double getSalario() {
		return salarioEmpleado;
	}

	// Setter: permite cambiar el salario
	public void setSalario(double salario) {
		this.salarioEmpleado = salario;
	}

	// Método toString: devuelve un texto representando el salario de forma clara
	@Override
	public String toString() {
		return "SalarioMensual [salario=" + salarioEmpleado + "]";
	}
}
