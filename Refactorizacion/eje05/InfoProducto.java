package eje05;
// Clase que representa la información de un producto
public class InfoProducto {
    private String nombre;        // Atributo para almacenar el nombre del producto
    private String descripcion;   // Atributo para almacenar la descripción del producto

    // Constructor: recibe el nombre y la descripción del producto
    public InfoProducto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getter: devuelve el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Getter: devuelve la descripción del producto
    public String getDescripcion() {
        return descripcion;
    }
}
