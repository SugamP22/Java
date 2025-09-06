package eje05;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto InfoProducto con el nombre y la descripción del producto
        InfoProducto infoProducto = new InfoProducto("Laptop", "Ordenador portátil");

        // Crear un objeto Precio con el precio sin IVA y el IVA
        Iva precio = new Iva(1200.00, 21.0);

        // Crear un objeto Producto con el objeto InfoProducto y Precio
        Producto producto = new Producto(infoProducto, precio);

        // Mostrar los detalles del producto
        producto.mostrarDetalles();
    }
}
