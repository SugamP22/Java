package eje03;
// Clase ImpuestoCalculador donde se calcula el impuesto y se puede redondear el resultado
public class ImpuestoCalculador {
	private double precioBase; // Guarda el precio base (sin impuestos)
	private double impuestoPorcentaje; // Guarda el porcentaje del impuesto

	// Constructor de la clase, recibe el precio base y el porcentaje de impuesto
	public ImpuestoCalculador(double precioBase, double impuestoPorcentaje) {
		this.precioBase = precioBase;
		this.impuestoPorcentaje = impuestoPorcentaje;
	}

	// Getter para obtener el precio base
	public double getPrecioBase() {
		return precioBase;
	}

	// Setter para modificar el precio base
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	// Getter para obtener el porcentaje de impuesto
	public double getImpuestoPorcentaje() {
		return impuestoPorcentaje;
	}

	// Setter para modificar el porcentaje de impuesto
	public void setImpuestoPorcentaje(double impuestoPorcentaje) {
		this.impuestoPorcentaje = impuestoPorcentaje;
	}

	// Método que calcula el valor del impuesto a pagar
	// Fórmula: precioBase * (impuestoPorcentaje / 100)
	public double calcularImpuesto() {
		return precioBase * (impuestoPorcentaje / 100);
	}

	// Método para redondear un valor a 2 decimales
	public double redondear(double valor) {
		return Math.round(valor * 100.0) / 100.0;
	}

	// Método toString para mostrar el contenido de un objeto de esta clase
	@Override
	public String toString() {
		return "ImpuestoCalculador [precioBase=" + precioBase + ", impuestoPorcentaje=" + impuestoPorcentaje + "]";
	}
}
