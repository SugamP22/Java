package eje02; 
// Declaras el paquete donde está la clase, para organizar el proyecto.

// Clase principal que representa un pedido online
public class PedidoOnline {
	private String cliente; // Guarda el nombre del cliente
	private double total;   // Guarda el monto total del pedido
	private Pago pago;      // Objeto de tipo Pago para gestionar el estado del pago

	// Constructor: recibe el nombre del cliente y el total del pedido
	// Al crear un pedido, también crea un objeto Pago vacío
	public PedidoOnline(String cliente, double total) {
		this.cliente = cliente;
		this.total = total;
		this.pago = new Pago(); 
	}

	// Métodos getters y setters para acceder o modificar los atributos privados
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	// Método que simula procesar el pedido
	public void procesarPedido() {
		// Verifica que el total sea mayor que 0
		if (total <= 0) {
			System.out.println("Error: El total debe ser mayor a 0.");
			return; // Sale del método si el total no es válido
		}

		System.out.println("Procesando pedido de " + cliente + " por $" + total);

		// Simulación de un pago
		// Si el total es mayor a 100, el pago es exitoso
		if (total > 100) {
			pago.setPago(true); // Marca el pago como realizado
			System.out.println("Pago exitoso.");
		} else {
			// Si el total es menor o igual a 100, se considera fallido
			System.out.println("Pago fallido.");
			return; // Sale sin confirmar el pedido
		}

		// Si todo ha ido bien, confirma el pedido
		System.out.println("Pedido confirmado.");
	}
}
