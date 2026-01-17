package estacionDeRobotYSupervisor;

public class Roboto implements Runnable {
	private int priority;
	private String nombre;
	private Estacion estacion;

	public String getNombre() {
		return nombre;
	}

	public Roboto(String nombre, Estacion estacion) {
		this.nombre = nombre;
		priority = (int) (Math.random() * 4);
		this.estacion = estacion;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			estacion.entrarEstacion(this);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			estacion.cargar(this);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
