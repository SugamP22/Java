package actividad14;

import java.io.Serializable;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int contador = 0;
	private int codigo;
	private String nombre;
	private boolean stock;
	private double precio;
	transient String proveedor;

	public Producto(String nombre, boolean stock, double precio, String provedor) {
		this.setCodigo(contador);
		contador++;
		this.setNombre(nombre);
		this.setStock(stock);
		this.setPrecio(precio);
		this.proveedor = provedor;
	}

	public Producto() {
		this.codigo = contador;
		contador++;
	}

	public static void setContador(int contador) {
		Producto.contador = contador;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio
				+ ", proveedor=" + proveedor + "]";
	}
	

}
