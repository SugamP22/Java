package eje05;

// Clase que representa un producto con su información y precio con IVA
public class Producto {
	private InfoProducto infoProducto; // Objeto que contiene la información del producto (nombre y descripción)
	private Iva iva; // Objeto que contiene el precio y el IVA del producto

	// Constructor: recibe un objeto InfoProducto (información del producto) y un
	// objeto Iva (precio y IVA)
	public Producto(InfoProducto infoProducto, Iva precio) {
		this.infoProducto = infoProducto;
		this.iva = precio;
	}

	// Método que muestra por consola los detalles del producto
	public void mostrarDetalles() {
		System.out.println("Nombre del Producto: " + infoProducto.getNombre()); // Muestra el nombre del producto
		System.out.println("Descripción: " + infoProducto.getDescripcion()); // Muestra la descripción del producto
		System.out.println("Precio sin IVA: $" + iva.getPrecioSinIVA()); // Muestra el precio sin IVA
		System.out.println("IVA: " + iva.getIVA() + "%"); // Muestra el porcentaje de IVA
		System.out.println("Precio con IVA: $" + iva.getPrecioConIVA()); // Muestra el precio con IVA
	}
}
