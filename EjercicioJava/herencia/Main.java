package herencia;

public class Main {
	public static void main(String[] args) {
		Coche coche1 = new Coche("Toyota Corolla", 4, 5, "Azul", "Sedán");
		Coche coche2 = new Coche("Ford Mustang", 4, 2, "Rojo", "Deportivo");

		// Crear dos motos
		Moto moto1 = new Moto("Yamaha R1", 2, 2, "Negro", "Superbike");
		Moto moto2 = new Moto("Harley Davidson", 2, 2, "Plateado", "Chopper");

		coche1.mostrarInfo();
		System.out.println("******************************");
		coche2.mostrarInfo();
		System.out.println("******************************");
		moto1.mostrarInfo();
		System.out.println("******************************");
		moto2.mostrarInfo();
	}
}
