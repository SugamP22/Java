package ingresarYRegresar;

public class CuentaBancaria {
	private double saldoInicial = 5000;
	private boolean esInferior = false;

	public boolean isEsInferior() {
		return esInferior;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void ingresarDinera(Usuario usuario) {
		String nombre = usuario.getNombre();
		System.out.println(nombre + " esta intentando Ingresar dinero... | Saldo Actual: " + saldoInicial);
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		synchronized (this) {
			actualizarSlado(usuario);
			notifyAll();
		}
		System.out.println("Dinero Ingresado con Exito. Saldo Actual: " + saldoInicial);
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public void sacarDinaro(Usuario usuario) {
		String nombre = usuario.getNombre();
		System.out.println(nombre + " esta intentando Sacar dinero... | Saldo Actual: " + saldoInicial);
		synchronized (this) {
			while (esInferior) {
				System.err.println(nombre + " esta esperando que alguien Ingrese el dinero");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			actualizarSlado(usuario);
		}
		System.out.println("Dinero sacado con Exito. Saldo Actual: " + saldoInicial);
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void actualizarSlado(Usuario u) {
		if (u.getActividad().equalsIgnoreCase("Ingresar")) {
			saldoInicial += 500;

		} else {
			saldoInicial -= 500;
		}
		esInferior = saldoInicial < 4000;
	}
}
