package ingresarYRegresar;

public class Main {
	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria();
		Usuario u1 = new Usuario("Sugam", cuenta, "Sacar");
		Usuario u2 = new Usuario("Miguel", cuenta, "ingresar");
		u1.start();
		u2.start();

	}
}
