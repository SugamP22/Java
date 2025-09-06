package tema01;

import java.util.Scanner;

public class XExamenQuestion3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una masa: ");
		double masa = sc.nextDouble();
		System.out.print("Introduce una velocidad: ");
		double velocidad = sc.nextDouble();
		System.out.println("********************");
		double res = (1 / 2.0) * masa * Math.pow(velocidad, 2);
		System.out.printf("La energía cinetica con masa %.2f kg y velocidad %.2f m es %.2f %c", masa, velocidad, res,
				'J');
		sc.close();
	}
}
