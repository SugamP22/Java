package ejeFor;

import java.util.Scanner;

public class Eje02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int contadorPar = 0;
		int contadorImpar = 0;
		System.out.print("Introduce un rango del numero:::>");
		int rango = sc.nextInt();
		for (int i = 0; i < rango; i++) {
			if (i % 2 == 0) {
				contadorPar += i;
			} else {
				contadorImpar += i;
			}
		}
		System.out.printf("La suma total del numeros Pares en rango de %d es %d\n",rango,contadorPar);
		System.out.printf("La suma total del numeros impares en rango de %d es %d",rango,contadorImpar);
sc.close();
	}
}
