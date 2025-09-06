package actividadCasa;

public class Huespedes {
	private String nombre;
	private int id;
	private String preferencia;
	

	public Huespedes(String nombre, int id,String preferencia) {
		this.nombre = nombre;
		this.id =id;
		this.preferencia = preferencia;
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	@Override
	public String toString() {
		return "Huespedes [nombre=" + nombre + ", id=" + id + ", preferencia=" + preferencia + "]";
	}

}
