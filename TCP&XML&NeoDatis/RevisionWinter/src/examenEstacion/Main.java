package examenEstacion;

public class Main {
	public static void main(String[] args) {
		Estacion estacion = new Estacion();
		Thread[] lista = new Thread[4];
		for (int i = 0; i < lista.length; i++) {
			Roboto r = new Roboto(i + 1, estacion);
			lista[i] = new Thread(r);
			lista[i].start();
			
		}
		new Thread(new Supervisor(1, estacion)).start();
		new Thread(new Supervisor(2, estacion)).start();
		
	}
}
