package ejeFor;

import java.util.Scanner;

public class Eje03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un rango del numeros:::>");
		int rango = sc.nextInt();
		int numPares = 0;
		int numImpares = 0;
		for (int i = 0; i < rango; i++) {
			if (i % 2 == 0) {
				numPares++;
			} else {
				numImpares++;
			}
		}
		System.out.printf("Numero total de numeros pares dentro del rango %d es %d\n", rango, numPares);
		System.out.printf("Numero total de numeros impares dentro del rango %d es %d", rango, numImpares);
		sc.close();
	}
}
