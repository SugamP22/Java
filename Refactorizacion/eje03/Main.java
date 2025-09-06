package eje03;
// Definís el paquete donde se encuentra la clase Main.

public class Main {
	public static void main(String[] args) {
		// Creamos un objeto de tipo ImpuestoCalculador con dos valores:
		// El primer valor (2567.33) puede ser, por ejemplo, el monto base
		// El segundo valor (45.23) puede ser el porcentaje o monto del impuesto
		ImpuestoCalculador impuestoCalculador = new ImpuestoCalculador(2567.33, 45.23);

		// Creamos un objeto CalculadoraImpuestos, al cual le pasamos el objeto impuestoCalculador
		// Esto quiere decir que la CalculadoraImpuestos va a trabajar con esos datos
		CalculadoraImpuestos pedido = new CalculadoraImpuestos(impuestoCalculador);

		// Llamamos al método calcularTotalConImpuestos para hacer el cálculo y mostrar el resultado
		pedido.calcularTotalConImpuestos();
	}
}
