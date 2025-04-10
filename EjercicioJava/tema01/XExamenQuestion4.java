package tema01;

import java.util.Scanner;

public class XExamenQuestion4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = (int) (Math.random() * (20 - 1 + 1)) + 1;
		System.out.print("Introduce un número para adivinar el numero aleatorio: ");
		int adivinar = sc.nextInt();
		System.out.println("*************************");
		if (r1 == adivinar) {
			System.out.println("Ole!! has adivinado el numero corectamente. El número era " + adivinar);
		} else {
			System.out.println("Buen Intento, el número era " + r1);
		}
		System.out.println();
		sc.close();
	}
}
