package Juegos;

import java.util.Scanner;

public class Alienigenos {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int puntosVida = 20;
		int numeroALiegenosMatados = 0;
		int ronda = 1;
		System.out.println("!La invasión alienigena ha comienzado! Debes defender la Tierra.");
		while (numeroALiegenosMatados < 10 && puntosVida > 0) {
			System.out.printf("Tienes en total %d puntos de la vida.\n", puntosVida);
			int numAliegenosAparecido = (int) (Math.random() * 20) + 1;
			System.out.printf("Cuantas alienígenas quiere atacar en la ronda %d ::::>", ronda);
			int numAdivinadoParaAtacar = sc.nextInt();
			if (numAdivinadoParaAtacar > numAliegenosAparecido) {
				puntosVida -= numAdivinadoParaAtacar;
			} else {
				numeroALiegenosMatados += numAdivinadoParaAtacar;
			}
			System.out.printf("Numero total de alienegenos derrotado: %d.\n", numeroALiegenosMatados);

			ronda += 1;
			System.out.println("-------------------------------------");
		}
		if (numeroALiegenosMatados < 10) {
			System.out.printf("No has podido defender la tierra!! AliegenosMatados: %d Y PuntosVida: %d",
					numeroALiegenosMatados, puntosVida);

		} else {
			System.out.printf("Has defendido la tierra con exito!! AliegenosMatados: %d Y PuntosVida: %d",
					numeroALiegenosMatados, puntosVida);
		}
		sc.close();
	}
}
