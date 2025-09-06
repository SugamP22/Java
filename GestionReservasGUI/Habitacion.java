package activivdadJOption;

public class Habitacion {

	private int id;
	private Tipo tipo;
	public static int contador = 1;

	public Habitacion(Tipo tipo) {
		id = contador;
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
		return "Habitacion [id=" + id + ", tipo=" + tipo + "]";
	}
	
	
}
