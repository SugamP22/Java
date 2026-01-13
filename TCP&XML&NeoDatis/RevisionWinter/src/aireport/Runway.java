package aireport;

import java.util.LinkedList;

public class Runway {
	private LinkedList<Airplane> landing;
	private LinkedList<Airplane> flying;
	private boolean occupied;

	public Runway() {
		landing = new LinkedList<>();
		flying = new LinkedList<>();
		occupied = false;
	}

	public void requestTakeoff(Airplane airplane) {
		String nombre = airplane.getNombre();
		System.out.println(nombre + "esta intentando volar...");
		synchronized (this) {
			flying.add(airplane);
			while (occupied || flying.peek() != airplane) {
				if (occupied) {
					System.err.println(
							nombre + " esta intentando volar pero el runway esta occupado por " + flying.peek());

				}
				if (flying.peek() != airplane) {
					System.err.println(nombre + " esta esperando para su turno");
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			occupied = true;
		}
		System.out.println(nombre + " requesting takeoff");
		gap();
		System.out.println(nombre + " proceed to the runway for takeoff");
		gap();
		System.out.println(nombre + " taking off");
		gap();
		synchronized (this) {
			occupied = false;
			flying.poll();
			notifyAll();
		}

	}

	private void gap() {
		try {
			Thread.sleep((int) (Math.random() * 300) + 100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void requestLanding(Airplane airplane) {
		String nombre = airplane.getNombre();
		System.out.println(nombre + " esta intentando bajar...");
		synchronized (this) {
			landing.add(airplane);
			while (occupied || landing.peek() != airplane) {
				if (occupied) {
					System.err.println(
							nombre + " esta intentando volar pero el runway esta occupado por " + landing.peek());

				}
				if (landing.peek() != airplane) {
					System.err.println(nombre + " esta esperando para su turno");
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			occupied = true;
		}
		System.out.println(nombre + " requesting landing");
		gap();
		System.out.println(nombre + " proceding to the runway for landin");
		gap();
		System.out.println(nombre + " landed");
		gap();
		synchronized (this) {
			occupied = false;
			landing.poll();
			notifyAll();
		}

	}

}
