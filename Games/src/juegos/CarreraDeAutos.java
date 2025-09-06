package Juegos;

public class CarreraDeAutos {
	public static void main(String[] args) {
		int puntoAutoUno = 0;
		int puntoAutoDos = 0;

		System.out.println("! La carrera de autos ha comenzado!");
		System.out.println("Turnos de los autos.");
		while (puntoAutoUno < 10 && puntoAutoDos < 10) {
			int numauto1 = (int) (Math.random() * 3) + 1;
			puntoAutoUno += numauto1;
			int numauto2 = (int) (Math.random() * 3) + 1;
			puntoAutoDos += numauto2;
			System.out.printf("Auto 1 avanza %d posiciones. Total: %d\n", numauto1, puntoAutoUno);
			System.out.printf("Auto 2 avanza %d posiciones. Total: %d\n", numauto2, puntoAutoDos);
			System.out.println("-------------------------------------");
		}
		if (puntoAutoDos > puntoAutoUno) {
			System.out.println("El auto dos ganado con exito!!");
		} else if (puntoAutoUno > puntoAutoDos) {
			System.out.println("El auto uno ganado con exito!!");

		} else {
			System.out.println("Juego termina en un empate!!");
		}
	}
}
