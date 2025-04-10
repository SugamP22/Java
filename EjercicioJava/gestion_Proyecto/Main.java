package gestion_Proyecto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static Scanner sl = new Scanner(System.in);
	private static Empresa empresa = new Empresa();

	public static void main(String[] args) {
		int opcion = 0;
		do {
			menu();
			try {
				opcion = sc.nextInt();
				switchMain(opcion);

			} catch (InputMismatchException e) {
				sc.next();
			}
		} while (opcion != 5);
		System.out.println("|| Gracias Por su participación❤️❤️ ||");
	}

	private static void switchMain(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("[ Agregar Proyecto ]");
			agregarProyecto();
			break;
		case 2:
			System.out.println("[ Eliminar Proyecto ]");
			eliminarProyecto();
			break;
		case 3:
			System.out.println("[ Listar Proyecto ]");
			listarProyecto();
			break;
		case 4:
			System.out.println("[ Filtrar Proyecto ]");
			filtrarProyecto();
			break;

		case 5:
			System.out.println("Saliendo....");
			break;
		default:
			System.out.println(" Ingresa un numero entre (1-7)");
			break;
		}

	}

	private static void filtrarProyecto() {
		boolean flag = false;
		while (!flag) {

			System.out.println("Introduce Prioridad(BAJO,MEDIA,ALTA)");
			String prioridad = sl.nextLine().toUpperCase();
			try {
				Prioridad p = Prioridad.valueOf(prioridad);
				empresa.filtrarProyecto(p);
				System.out.println("**********************************");
				System.out.println("¿Quieres avanzar el estado de algun Proyecto?(SÍ/NO)");
				System.out.print(">>>>");
				boolean quiero = sc.next().equalsIgnoreCase("sí");
				if (!quiero) {
					flag = true;
				} else {
					System.out.print("Introduce un nombre del proyecto:");
					String nombre = sl.nextLine().trim();
					if (empresa.avanzarestado(nombre)) {
						System.out.printf("!! EL estado del proyecto %s yasta Avanzado !!\n", nombre);
					} else {
						System.out.println("no hay ningun Proyecto con este nombre");
					}
					flag = true;

				}
			} catch (IllegalArgumentException e) {
				System.err.println("|| Valores Correcto (NO_INICIADO, EN_PROGRESO, COMPLETADO) Y (BAJO,MEDIA,ALTA) ||");
			}
		}

	}

	private static void listarProyecto() {
		System.out.println("===== Lista de Proyectos =============");
		empresa.listarProyecti();

	}

	private static void eliminarProyecto() {
		System.out.println("Ingresa un nombre del proyecto");
		String nombre = sl.nextLine().toUpperCase().trim();
		int resultado = empresa.eliminarProyecto(nombre);
		if (resultado == 1) {
			System.out.println("No tiene ningun Proyecto registrada Para Eliminar!! ");
		} else if (resultado == 2) {
			System.out.println("El proyecto eliminado con exito!!");
		} else {
			System.out.println("no ningun Proyecto con este nombre!! ");
		}
		;

	}

	private static void agregarProyecto() {
		boolean flag = false;
		System.out.println("Introduce el nombre del producto");
		String nombre = sl.nextLine().toUpperCase();
		while (!flag) {
			System.out.println("Introduce el tipo de prioridad");
			String input = sl.nextLine().toUpperCase();
			try {
				Prioridad p = Prioridad.valueOf(input);
				empresa.agregarProyecto(new Proyecto(nombre, p));
				System.out.println("EL proyecto añadido con exito!!");
				flag = true;

			} catch (IllegalArgumentException e) {
				System.err.println("Valores Valido(ALTA,Bajo,Medio)");

			}
		}

	}

	private static void menu() {
		System.out.println(":::: Menú Principal ::::");
		System.out.println("1. Agregar Proyecto ");
		System.out.println("2. Eliminar Proyecto");
		System.out.println("3. Listar Proyectos");
		System.out.println("4. Filtrar Proyectos");
		System.out.println("5. Salir");
		System.out.print(">>>>>>>>>> ");
	}
}
