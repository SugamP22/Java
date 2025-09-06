package Juegos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegodeLaVida {
	private static Scanner sc = new Scanner(System.in);
	private static int[] filaCelula = new int[10];
	private static int[] nuevofilaCelula = new int[10];

	public static void main(String[] args) {

		inciarMain();
	}

	private static void inciarMain() {
		int opcion = 0;
		do {

			menu();
			try {
				opcion = sc.nextInt();
				mainSwitch(opcion);
			} catch (InputMismatchException e) {
				System.err.println("Error: Numero introducido invalido!!");
				sc.next();
			}
		} while (opcion != 5);

	}

	private static void filaInicialManual() {
		System.out.println("Rellanar la fila inicial 1 para vivo y 0 para muerta!!");
		System.out.println("-------------------");
		for (int i = 0; i < filaCelula.length; i++) {
			boolean valid = false;
			while (!valid) {
				System.out.printf("celula %d (1 para viva Y 0 para muerta):", i + 1);
				try {
					filaCelula[i] = sc.nextInt();
					if (filaCelula[i] > 1 || filaCelula[i] < 0) {
						throw new IllegalArgumentException("Error: Numero introducicdo invalido!!");
					}
					valid = true;

				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.err.println("Error: Introduce un munero valido!!");
				}
			}

		}
		System.out.print("Fila inicial:");
		for (int i = 0; i < filaCelula.length; i++) {
			System.out.print(filaCelula[i] + " ");
		}
		System.out.println();

	}

	private static void mainSwitch(int opcion) {
		switch (opcion) {
			case 1 -> modoBasico();
			case 2 -> modoAleatorio();
			case 3 -> modoPersonalizado();
			case 4 -> modoAvanzado();
			case 5 -> {
				System.out.println("Saliendo de la sistema!!");
				sc.close();
			}
			default -> System.err.println("Error: Numero Introducido es incorrecto!!");
		}
	}

	private static void modoAvanzado() {
		System.out.println("--- Modo Avanzado ----");
		filaInicialManual();
		for (int i = 0; i < 10; i++) {
			System.out.printf("Turno %d : ", i + 1);
			for (int j = 0; j < filaCelula.length; j++) {
				if (j != 0 && j != filaCelula.length - 1) {
					nuevofilaCelula[j] = (filaCelula[j + 1] + filaCelula[j - 1] >= 1) ? 1 : 0;
				} else if (j == 0) {
					nuevofilaCelula[j] = (filaCelula[j + 1] + filaCelula[filaCelula.length - 1] >= 1) ? 1 : 0;
				} else {
					nuevofilaCelula[j] = (filaCelula[j - 1] + filaCelula[0] >= 1) ? 1 : 0;

				}
				System.out.print(nuevofilaCelula[j]);

			}
			for (int k = 0; k < filaCelula.length; k++) {
				filaCelula[k] = nuevofilaCelula[k];
			}
			System.out.println();
		}
	}

	private static void modoPersonalizado() {
		System.out.println("--- Modo Personalizado ----");
		System.out.print("Cuantas rondas quierew jugar?\n:::>");
		int ronda = sc.nextInt();
		System.out.println("--- Modo Basico ----");
		filaInicialManual();
		for (int i = 0; i < ronda; i++) {
			System.out.printf("Turno %d : ", i + 1);
			for (int j = 0; j < filaCelula.length; j++) {
				if (j == 0) {
					nuevofilaCelula[j] = (filaCelula[j + 1] == 0) ? 0 : 1;

				} else if (j != filaCelula.length - 1) {
					nuevofilaCelula[j] = (filaCelula[j + 1] == 0 && filaCelula[j - 1] == 0) ? 0 : 1;

				} else {
					nuevofilaCelula[j] = (filaCelula[j - 1] == 0) ? 0 : 1;
				}
			}
			for (int k = 0; k < nuevofilaCelula.length; k++) {
				System.out.print(nuevofilaCelula[k] + ((k == nuevofilaCelula.length - 1) ? "\n" : " "));
			}

		}

	}

	private static void modoAleatorio() {
		System.out.println("--- Modo Aleatorio ----");
		filaInicialAleatorio();
		for (int i = 0; i < 10; i++) {
			System.out.printf("Turno %d : ", i + 1);
			for (int j = 0; j < filaCelula.length; j++) {
				if (j == 0) {
					nuevofilaCelula[j] = (filaCelula[j + 1] == 0) ? 0 : 1;

				} else if (j != filaCelula.length - 1) {
					nuevofilaCelula[j] = (filaCelula[j + 1] == 0 && filaCelula[j - 1] == 0) ? 0 : 1;

				} else {
					nuevofilaCelula[j] = (filaCelula[j - 1] == 0) ? 0 : 1;
				}
			}
			for (int k = 0; k < nuevofilaCelula.length; k++) {
				System.out.print(nuevofilaCelula[k] + ((k == nuevofilaCelula.length - 1) ? "\n" : " "));
			}

		}

	}

	private static void filaInicialAleatorio() {
		for (int i = 0; i < filaCelula.length; i++) {
			filaCelula[i] = (int) (Math.random() * 2);

		}
		System.out.print("Fila Aleatorio Creado: ");
		for (int i = 0; i < filaCelula.length; i++) {
			System.out.print(filaCelula[i] + ((i == filaCelula.length - 1) ? "\n" : " "));
		}

	}

	private static void modoBasico() {
		System.out.println("--- Modo Basico ----");
		filaInicialManual();
		for (int i = 0; i < 10; i++) {
			System.out.printf("Turno %d : ", i + 1);
			for (int j = 0; j < filaCelula.length; j++) {
				if (j == 0) {
					nuevofilaCelula[j] = (filaCelula[j + 1] == 0) ? 0 : 1;

				} else if (j != filaCelula.length - 1) {
					nuevofilaCelula[j] = (filaCelula[j + 1] == 0 && filaCelula[j - 1] == 0) ? 0 : 1;

				} else {
					nuevofilaCelula[j] = (filaCelula[j - 1] == 0) ? 0 : 1;
				}
			}
			for (int k = 0; k < nuevofilaCelula.length; k++) {
				System.out.print(nuevofilaCelula[k] + ((k == nuevofilaCelula.length - 1) ? "\n" : " "));
			}

		}

	}

	private static void menu() {
		System.out.println("--- Menú Principal ---");
		System.out.println("1. Modo Basico");
		System.out.println("2. Modo Aleatorio");
		System.out.println("3. Modo Personalizado");
		System.out.println("4. Modo Avanzado");
		System.out.println("5. Salir");
		System.out.print("::::::::::>");

	}
}
