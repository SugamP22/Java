package eje03;
// Clase que utiliza un ImpuestoCalculador para calcular el total con impuestos
public class CalculadoraImpuestos {
	private ImpuestoCalculador impuestoCalculador; // Objeto que contiene precio base e impuesto

	// Constructor: recibe un objeto ImpuestoCalculador
	public CalculadoraImpuestos(ImpuestoCalculador impuestoCalculador) {
		this.impuestoCalculador = impuestoCalculador;
	}

	// Getter para acceder al objeto impuestoCalculador
	public ImpuestoCalculador getImpuestoCalculador() {
		return impuestoCalculador;
	}

	// Setter para modificar el objeto impuestoCalculador si es necesario
	public void setImpuestoCalculador(ImpuestoCalculador impuestoCalculador) {
		this.impuestoCalculador = impuestoCalculador;
	}

	// Método principal que calcula el total con impuestos
	public double calcularTotalConImpuestos() {
		// Calcula el impuesto llamando al método calcularImpuesto()
		double impuesto = impuestoCalculador.calcularImpuesto();

		// Suma el precio base más el impuesto calculado
		double totalConImpuestos = impuestoCalculador.getPrecioBase() + impuesto;

		// Redondea el resultado a 2 decimales
		totalConImpuestos = impuestoCalculador.redondear(totalConImpuestos);

		// Muestra el total en pantalla
		imprimirTotal(totalConImpuestos);

		// Retorna el total por si se necesita utilizar en otra parte
		return totalConImpuestos;
	}

	// Método privado que solo muestra el total con impuestos
	private void imprimirTotal(double totalConImpuestos) {
		System.out.println("El total con impuestos es: $" + totalConImpuestos);
	}
}
