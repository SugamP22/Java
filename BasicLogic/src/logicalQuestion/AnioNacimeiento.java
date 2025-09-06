package logicalQuestion;

import java.util.Scanner;

public class AnioNacimeiento {
	public static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		final int ANIOACTUAL = 2025;
		System.out.println("Introsuce tu año de nacimeiento:::>");
		int anioNacimiento = sc.nextInt();
		int resultado = ANIOACTUAL - anioNacimiento;
		System.out.printf("Su edad actual es %d", resultado);
		sc.close();
	}
}
