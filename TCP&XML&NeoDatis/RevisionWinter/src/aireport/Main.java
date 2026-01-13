package aireport;

public class Main {
	public static void main(String[] args) {
		Runway runway = new Runway();
		for (int i = 0; i < 10; i++) {
			Airplane a = new Airplane("Plane-" + (i + 1), runway);
			Thread t = new Thread(a);
			t.start();
		}
	}
}
