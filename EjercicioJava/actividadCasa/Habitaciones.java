package actividadCasa;

public class Habitaciones {
	private int id;
	private Tipo tipo;
	private static int contador = 1;

	public Habitaciones(Tipo tipo) {
		this.id = contador;
		this.tipo = tipo;
		contador++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Habitaciones [id=" + id + ", tipo=" + tipo + "]";
	}
	
	

}
