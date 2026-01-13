package exa1acda2425;

public class Pasajero {
	private int cod;
	private String nombre;
	private String tlf;
	private String Direccion;
	private String pais;

	@Override
	public String toString() {
		return "Pasajero [cod=" + cod + ", nombre=" + nombre + ", tlf=" + tlf + ", Direccion=" + Direccion + ", pais="
				+ pais + "]";
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Pasajero(int cod, String nombre, String tlf, String direccion, String pais) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.tlf = tlf;
		Direccion = direccion;
		this.pais = pais;
	}

}
