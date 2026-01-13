package aireport;

public class Airplane implements Runnable {
	private String nombre;
	private Runway runway;

	public String getNombre() {
		return nombre;
	}

	public Airplane(String nombre, Runway runway) {
		this.nombre = nombre;
		this.runway = runway;
	}

	@Override
	public void run() {
		runway.requestTakeoff(this);
		System.out.println(nombre + " is flying....");
		try {
			Thread.sleep((int) ((int) (Math.random() * 500) + 100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		runway.requestLanding(this);
	}

}
