package empresora;

public class Documento implements Runnable {
	private String nombre;
	private int priority;
	private int longitud;
	private Empresora empresora;

	public String getNombre() {
		return nombre;
	}

	public int getPriority() {
		return priority;
	}

	public int getLongitud() {
		return longitud;
	}

	public Documento(String nombre, Empresora empresora) {
		this.nombre = nombre;
		this.priority = (int) ((Math.random() * 5) + 1);
		this.longitud = (int) ((Math.random() * 301) + 200);
		this.empresora = empresora;
	}

	@Override
	public void run() {
		empresora.rellenar(this);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empresora.entrarParaEmprimir(this);

	}

}
