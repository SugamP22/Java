package waterPark;

/*
 * 22. En un parque de atracciones, hay una montaña rusa que puede transportar
 * 
un número limitado de personas por viaje (por ejemplo, 3 personas).
Los visitantes llegan al parque de manera simultánea (representados por
hilos) e intentan subir a la montaña rusa.
Si el vagón ya está lleno, deben esperar su turno hasta que haya espacio
disponible.
Cuando un visitante logra subir, permanece durante un tiempo en el viaje y
luego baja, liberando su lugar para que otro visitante pueda subir.
Realiza una simulación de 10 personas que quieren subirse a la atracción.

 * */
public class Main {

	public static void main(String[] args) {
		int totalPersonas = 10;
		int capacidadVagon = 3;
		System.out.println("====== Parque Abierto ======");
		MRusa mr = new MRusa(totalPersonas, capacidadVagon);

		Thread[] lista = new Thread[totalPersonas];
		for (int i = 0; i < totalPersonas; i++) {
			Persona p = new Persona(mr, (i + 1));
			lista[i] = new Thread(p);
			lista[i].start();
		}

		for (Thread t : lista) {
			try {
				t.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
		System.out.println("====== Cerrando Parque  ======");
	}
}
