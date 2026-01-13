package exa1acad2526;

public class Estrellas {
	private String nombre;
	private Double coord_X;
	private Double coord_Y;
	private Double coord_Z;
	private Double distancia;
	private Estrellas estrellas;
	private String tipo;
	private Galaxias galaxias;

	public Estrellas() {
		// TODO Auto-generated constructor stub
	}

	public Estrellas(String nombre, Double coord_X, Double coord_Y, Double coord_Z, Double distancia,
			Estrellas estrellas, String tipo, Galaxias galaxias) {
		super();
		this.nombre = nombre;
		this.coord_X = coord_X;
		this.coord_Y = coord_Y;
		this.coord_Z = coord_Z;
		this.distancia = distancia;
		this.estrellas = estrellas;
		this.tipo = tipo;
		this.galaxias = galaxias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCoord_X() {
		return coord_X;
	}

	public void setCoord_X(Double coord_X) {
		this.coord_X = coord_X;
	}

	public Double getCoord_Y() {
		return coord_Y;
	}

	public void setCoord_Y(Double coord_Y) {
		this.coord_Y = coord_Y;
	}

	public Double getCoord_Z() {
		return coord_Z;
	}

	public void setCoord_Z(Double coord_Z) {
		this.coord_Z = coord_Z;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Estrellas getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Estrellas estrellas) {
		this.estrellas = estrellas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Galaxias getGalaxias() {
		return galaxias;
	}

	public void setGalaxias(Galaxias galaxias) {
		this.galaxias = galaxias;
	}

	@Override
	public String toString() {
		return "Estrellas [nombre=" + nombre + ", coord_X=" + coord_X + ", coord_Y=" + coord_Y + ", coord_Z=" + coord_Z
				+ ", distancia=" + distancia + ", estrellas=" + estrellas + ", tipo=" + tipo + ", galaxias=" + galaxias
				+ "]";
	}

}
