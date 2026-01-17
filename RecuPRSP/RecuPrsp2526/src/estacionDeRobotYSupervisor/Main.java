package estacionDeRobotYSupervisor;

public class Main {
	public static void main(String[] args) {
		Estacion estacion = new Estacion();
		Thread[] list = new Thread[5];
		System.out.println("=========== Estacion De Málaga ===================");
		for (int i = 0; i < list.length; i++) {
			Roboto r = new Roboto("Roboto-" + (i + 1), estacion);
			list[i] = new Thread(r);
			list[i].start();
		}
		Supervision supervisor1 = new Supervision("Supervisor-1", estacion);
		Thread t1 = new Thread(supervisor1);
		t1.start();
		Supervision supervisor2 = new Supervision("Supervisor-2", estacion);
		Thread t2 = new Thread(supervisor2);
		t2.start();
		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Estacion cerrando!!");
	}
}
