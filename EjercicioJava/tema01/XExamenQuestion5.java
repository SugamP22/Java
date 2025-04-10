package tema01;

import java.util.Scanner;

public class XExamenQuestion5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tu salario: ");
		float salario = sc.nextInt();
		System.out.print("Introduce el tipo del incremento en tu salrio: ");
		float por = sc.nextFloat();
		System.out.println("***********************");
		float res = (salario * por) + salario;
		System.out.printf("Con el incremento de salario con un porcentaje de %.2f tu nuevo salrio es %.2f",por,res);
		sc.close();
	}
}
