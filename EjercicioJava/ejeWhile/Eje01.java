package ejeWhile;

import java.util.Scanner;

public class Eje01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean adivinado = false;
		int intentos = 1;
		int r1 = (int) (Math.random() * (20 - 1 + 1)) + 1;
		while (!adivinado && intentos <= 10) {
			System.out.printf("Intento %d para adivinar el numero:::>", intentos);
			int num = sc.nextInt();

			if (num == r1) {
				System.out.printf("Has adivinado el numero correctamente en solo %d intentos\n", intentos);
				adivinado = true;
			} else {
				intentos++;
				System.out.printf("Buen intento te quedan %d intentos\n", (10 - (intentos - 1)));
			}

			System.out.println("**********************");
		}
		if (!adivinado) {
			System.out.printf("GGS el numero corecto era %d ", r1);
		}
		sc.close();
	}
}
