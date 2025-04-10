package tema01;

import java.util.Scanner;

public class ComparasionNumeros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		int num1 = sc.nextInt();
		System.out.print("Introduce segundo numero: ");
		int num2 = sc.nextInt();
		System.out.print("Introduce tercer numero: ");
		int num3 = sc.nextInt();
		// sin la condicion es verdadero aplica la primera resultado si no la secunda.
		System.out.println(
				(num3 > num2 + num1) ? "Si la tercer numero " + num3 + " es mayor que la suma de otros dos numeros"
						: "No la tercer numero no es mayor que la suma de los dos numeros.");
		sc.close();
	}
}
