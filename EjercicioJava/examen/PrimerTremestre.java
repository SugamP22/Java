package examen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimerTremestre {

	private static Scanner sc = new Scanner(System.in);

	public static String nombre() {
		System.out.print("::::>");
		String nombre1 = sc.nextLine();
		return nombre1;
	}

	public static void conversacion() {
		System.out.println("Vecino. Vecino. Vecino.");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("Eh... hola, ¿puedo ayudarte?");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("¡Ah, excelente! Me presento: soy el Dr. Sheldon Cooper, fisico teórico del insituto\n"
				+ " Technológico de California. Según las normas del edificio, es mi deber conocer a los nuevos inquilinos. \n¿Cuál es tu nombre?!");
		String realNombre = nombre();
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.printf("oh, eh ....soy %s\n", realNombre);
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.printf(
				"Perfecto, %s. Ahora que hemos establecido una relación cordial basada en normas \n sociales minimas, creo que es momento adecuado para desafiarte intelectualmente.\n Tengo Preparado un par de actividades para poner a prueba tus habilidades.\n ¿Estas listo?\n",
				realNombre);

		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("Supongo que si. ¿Que tienes en mente?");
	}

	public static void main(String[] args) {
		conversacion();
		int opcion = 0;
		do {
			menu();
			try {
				opcion = sc.nextInt();
				switchMain(opcion);
			} catch (InputMismatchException e) {
				System.out.println("Entrada Inválido!!");
				sc.nextLine();
			}
		} while (opcion != 5);
		System.out.println("\033[35mGracias Por Su Visita\033[0m");
	}

	private static void switchMain(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("***** Apostar ******");
			apostar();
			break;
		case 2:
			System.out.println("***** Adivinar ******");
			adivinar();
			break;
		case 3:
			System.out.println("***** Jugar ******");
			jugar();
			break;
		case 4:
			System.out.println("***** Pelear ******");
			pelear();

			break;
		case 5:
			System.out.println("Saliendo....");
			break;
		default:
			System.out.println("Entrada Inválido!!, Ingresa un numero entre 1 y 5");
			break;
		}

	}

	private static void pelear() {
		// TODO Auto-generated method stub

	}

	private static void jugar() {
		// TODO Auto-generated method stub

	}

	private static void adivinar() {
		// TODO Auto-generated method stub

	}

	private static void rellanar(int[] num) {
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 100) + 1;
		}
	}

	private static void apostar() {

		int[] num = new int[10];
		rellanar(num);
		System.out.println("Turno Sheldon, eligir una posicion para adivinar:");
		int numSheldon = sc.nextInt();
		sc.nextLine();
		String name = nombre();
		System.out.printf("Turno %s, eligir una posicion para adivinar\n", name);
		try {
			int numSugam = sc.nextInt();

			if (num[numSheldon - 1] < num[numSugam - 1]) {
				System.out.printf("Ganador %s\n", name);

			} else if (num[numSheldon - 1] > num[numSugam - 1]) {
				System.out.println("Ganador Sheldon ");

			} else {
				System.out.println("EMPATE!!");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Entrada invalido");
			sc.next();
		}

	}

	private static void menu() {
		System.out.println("::::: Menú Principal ::::::::");
		System.out.println("1. Apostar");
		System.out.println("2. Adivinar");
		System.out.println("3. Jugar ");
		System.out.println("4. Pelear");
		System.out.println("5. Salir");
		System.out.print(":::::::>");

	}
}
