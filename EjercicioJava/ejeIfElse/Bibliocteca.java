package ejeIfElse;

import java.util.Scanner;

public class Bibliocteca {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("¿El libro introducido ya esta prestado?(sí/no):::>");
		boolean prestado = sc.next().equalsIgnoreCase("sí");
		if (prestado) {
			System.out.println("La libro no esta disponible durante este momento, Gracias por contactar!!");
		} else {
			System.out.print("¿Usted tiene un membersia premium?(true/false):::>");
			boolean membersia = sc.nextBoolean();
			if (membersia) {
				System.out.println("La libro ya esta prestado corecctamente, Gracias por su visita!!");
			} else {
				System.out.print("¿El libro es eun ejemplar raro o antiguo?(true/false):::>");
				boolean raro = sc.nextBoolean();
				if (raro) {
					System.out.println("Tiene que ser un miembreo antes de prestar este tipo del libro, Gracias!!");
				} else {
					System.out.println("La libro ya esta prestado corecctamente, Gracias por su visita!!");

				}

			}
		}

		sc.close();

	}
}
