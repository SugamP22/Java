package printer;

public class Documento implements Runnable {
	private String nombre;
	private int prioridad;
	private Empresora empresora;

	public String getNombre() {
		return nombre;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public Documento(String nombre, Empresora empresora) {
		this.nombre = nombre;
		this.empresora = empresora;
		prioridad = (int) ((Math.random() * (5 - 1 + 1)) + 1);

	}

	@Override
	public void run() {
		empresora.rellanarCola(this);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empresora.iniciar(this);
	}

}
