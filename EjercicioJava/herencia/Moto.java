package herencia;

public class Moto extends Vehiculo {
	private String modulo;

	public Moto(String nombre, int ruedas, int asientos, String color, String modulo) {
		super(nombre, ruedas, asientos, color);
		this.modulo = modulo;
	}

	@Override
	public void mostrarInfo() {
		System.out.println(this.toString());

	}

	@Override
	public String toString() {
		return "Moto [modulo=" + modulo + ", nombre=" + nombre + ", ruedas=" + ruedas + ", asientos=" + asientos
				+ ", color=" + color + "]";
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	

}
