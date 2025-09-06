package activivdadJOption;

public class Huespeda {
	private int id;
	private String nombre;
	private String preferencia;
	private static int contadorHuespeda = 1;

	public Huespeda(String nombre, String preferencia) {
		id = contadorHuespeda;
		this.nombre = nombre;
		this.preferencia = preferencia;
		contadorHuespeda++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	@Override
	public String toString() {
		return "Huespeda [id=" + id + ", nombre=" + nombre + ", preferencia=" + preferencia + "]";
	}
	
	
	
}
