package Juegos;

public class BrujaYMago {
	public static void main(String[] args) {
		int puntosMago = 0;
		int puntosBruja = 0;
		int numanteriorMago = 0;
		int numanteriorBruja = 0;
		int ronda = 1;
		while (puntosMago < 50 && puntosBruja < 50) {
			System.out.printf("     ---- Ronda %d ----\n", ronda);
			int numMago = (int) (Math.random() * 3) + 1;
			int numBruja = (int) (Math.random() * 3) + 1;
			if (numMago == numanteriorMago) {
				puntosMago -= numMago;
				System.out.printf(
						"Mago tine el mismo avance que la ronda anterior , se retrocede %d puntos, ahora está en %d\n",
						numMago, puntosMago);
			} else {
				puntosMago += numMago;
				System.out.printf("Mago avanza %d puntos y alcanza el punto %d\n", numMago, puntosMago);
			}
			if (numBruja == numanteriorBruja) {
				puntosBruja -= numBruja;
				System.out.printf(
						"Bruja tine el mismo avance que la ronda anterior , se retrocede %d puntos, ahora está en %d\n",
						numBruja, puntosBruja);
			} else {
				puntosBruja += numBruja;
				System.out.printf("Bruja avanza %d puntos y alcanza el punto %d\n", numBruja, puntosBruja);

			}
			ronda++;
			numanteriorMago = numMago;
			numanteriorBruja = numBruja;
			System.out.println(":::::::::::::::::::::::::::::::::::");

		}
		if (puntosBruja == 50 && puntosMago == 50) {
			System.out.println("Juego termina con un empate");
		} else if (puntosBruja > puntosMago) {
			System.out.println("Bruga fue el ganador!!");
		} else {
			System.out.println("Mago ganó el partido!!");
		}
	}
}
