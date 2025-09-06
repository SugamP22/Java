package logicalQuestion;

import java.util.Scanner;

public class NumeroMayor {
	public static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Introduce el primer numero::::>");
		int num1 = sc.nextInt();
		System.out.print("Introduce el segundo numero:::::>");
		int num2 = sc.nextInt();
		System.out.print("Introduce el tercer numero:::::>");
		int num3 = sc.nextInt();
		String resultado = num3 > num2 + num1 ? "El Tercer numero es mayor que otros dos	"
				: "No, la tercerner numero no es mayor que la suma de los primeros!!";
		System.out.println(resultado);

	}
}
