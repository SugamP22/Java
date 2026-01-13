package exa1acad2526;

public class Galaxias {
	private String nombre;
	private String tipo;
	private Long numero_estrellas;

	public Galaxias() {
		// TODO Auto-generated constructor stub
	}

	public Galaxias(String nombre, String tipo, Long numero_estrellas) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.numero_estrellas = numero_estrellas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getNumero_estrellas() {
		return numero_estrellas;
	}

	public void setNumero_estrellas(Long numero_estrellas) {
		this.numero_estrellas = numero_estrellas;
	}

	@Override
	public String toString() {
		return "Galaxias [nombre=" + nombre + ", tipo=" + tipo + ", numero_estrellas=" + numero_estrellas + "]";
	}

}
