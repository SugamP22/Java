package herencia;

public abstract class Vehiculo {
	protected String nombre;
	protected int ruedas;
	protected int asientos;
	protected String color;

	public Vehiculo(String nombre, int ruedas, int asientos, String color) {
		this.nombre = nombre;
		this.ruedas = ruedas;
		this.asientos = asientos;
		this.color = color;
	}

	public abstract void mostrarInfo();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehiculo [nombre=" + nombre + ", ruedas=" + ruedas + ", asientos=" + asientos + ", color=" + color
				+ "]";
	}

}

