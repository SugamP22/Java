package tema01;

import java.util.Scanner;

public class RadioEsfera {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un valor de radio: ");

		double radio = sc.nextDouble();

		// Volume formula: (4/3) * π * r³
		// usamos Math.pow para usar potencia
		// usamos Math.PI para pie
		// Math.round para redondear
		double volumen = Math.round((4.0 / 3.0) * Math.PI * Math.pow(radio, 3));

		System.out.println("El volumen de la esfera con el radio introducido es: " + volumen);
		sc.close();
	}
}
