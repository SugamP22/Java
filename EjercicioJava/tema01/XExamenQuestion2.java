package tema01;

import java.util.Scanner;

public class XExamenQuestion2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un peso en kg: ");
		float peso = sc.nextFloat();
		System.out.print("Introduce un altura en cm: ");
		float altura = sc.nextFloat();
		float altura1 = altura / 100;
		float imc = (float) (peso / Math.pow(altura1, 2));
		System.out.println("**************");
		System.out.printf("El indice de Masa Corporal con peso %.2fkg y altura de %.2fcm es %.2f", peso, altura, imc);
		sc.close();
	}
}
