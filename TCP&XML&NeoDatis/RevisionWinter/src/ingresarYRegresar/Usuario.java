package ingresarYRegresar;

public class Usuario extends Thread {
	private String nombre;
	private CuentaBancaria cuenta;
	private String actividad;
	private int ronda = 0;

	public String getActividad() {
		return actividad;
	}

	public Usuario(String nombre, CuentaBancaria cuenta, String sacr) {
		this.setNombre(nombre);
		this.setCuenta(cuenta);
		actividad = sacr;
	}

	@Override
	public void run() {
		while (ronda < 10) {
			if (actividad.equalsIgnoreCase("Ingresar")) {
				cuenta.ingresarDinera(this);
				ronda++;
			} else {
				cuenta.sacarDinaro(this);
				ronda++;
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CuentaBancaria getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}

}
