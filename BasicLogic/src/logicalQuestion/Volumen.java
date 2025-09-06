package logicalQuestion;

import java.util.Scanner;

public class Volumen {
	public static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		System.out.println("Introduce el radio:::::>");
		double num = sc.nextDouble();

		double resultado = (4.0 / 3) * Math.PI * Math.pow(num, 3);

		System.out.printf("El volumen para una esfera con radio %1.2f es %1.2f", num, resultado);

		sc.close();
	}
}
