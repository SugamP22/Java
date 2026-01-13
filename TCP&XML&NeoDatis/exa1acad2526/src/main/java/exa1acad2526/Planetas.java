package exa1acad2526;

public class Planetas {
	private String nombre;
	private Double masa;
	private Double periodo_orbital;
	private Estrellas estrellas;

	public Planetas() {

	}
	

	public Planetas(String nombre, Double masa, Double periodo_orbital, Estrellas estrellas) {
		super();
		this.nombre = nombre;
		this.masa = masa;
		this.periodo_orbital = periodo_orbital;
		this.estrellas = estrellas;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getMasa() {
		return masa;
	}

	public void setMasa(Double masa) {
		this.masa = masa;
	}

	public Double getPeriodo_orbital() {
		return periodo_orbital;
	}

	public void setPeriodo_orbital(Double periodo_orbital) {
		this.periodo_orbital = periodo_orbital;
	}

	public Estrellas getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Estrellas estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Planetas [nombre=" + nombre + ", masa=" + masa + ", periodo_orbital=" + periodo_orbital + ", estrellas="
				+ estrellas + "]";
	}

}
