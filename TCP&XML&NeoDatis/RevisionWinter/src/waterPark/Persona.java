package waterPark;

public class Persona implements Runnable {

	private final MRusa mr;
	private final int numBoleto;

	public Persona(MRusa mr, int numBoleto) {
		this.mr = mr;
		this.numBoleto = numBoleto;
	}

	@Override
	public void run() {
		try {
			mr.montarYViajar(this);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public int getNumBoleto() {
		return numBoleto;
	}

}