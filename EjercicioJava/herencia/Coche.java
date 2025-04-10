package herencia;

public class Coche extends Vehiculo {
	private String modulo;

	public Coche(String nombre, int ruedas, int asientos, String color, String modulo) {
		super(nombre, ruedas, asientos, color);
		this.modulo = modulo;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	@Override
	public void mostrarInfo() {
		System.out.println(this.toString());
		;
	}

	@Override
	public String toString() {
		return String.format("Nombre Coche: %s\nNumero Ruedas: %d\nNumero asientos:%d\nColor: %s\nModulo:%s ", nombre,
				ruedas, asientos, color, modulo);
	}

}
