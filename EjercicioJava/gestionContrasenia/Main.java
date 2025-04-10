package gestionContrasenia;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static Scanner sl = new Scanner(System.in);
	private static ArrayList<Usuario> usuario = new ArrayList<Usuario>();
	private static Administrador administrador = new Administrador();

	public static void main(String[] args) {
		IniciarMain();
		System.out.println("!! Gracais por su Participacion !!");
	}

	private static void IniciarMain() {
		int opcion = 0;
		do {
			menu();
			try {
				opcion = sc.nextInt();
				switchMain(opcion);
			} catch (InputMismatchException e) {
				System.err.println("Entrada Inválido");
				sc.next();
			} catch (IllegalArgumentException e) {
				System.err.println("Error:" + e.getMessage());
			}
		} while (opcion != 5);

	}

	private static void switchMain(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println(" [ Registrar Usuario ] ");
			registrarusuario();
			break;
		case 2:
			System.out.println(" [ Inicair Sesión ] ");
			iniciarSesion();
			break;
		case 3:
			System.out.println(" [ Cambiar Contraseña ] ");
			cambiarContrasenia();
			break;
		case 4:
			System.out.println(" [  Reiniciar Contraseña ] ");
			reinicairContrasenia();
			break;
		case 5:
			System.out.println("||  🥱🥱🥱Saliendo...  ||");
			break;
		default:
			System.err.println("|| Ingresa un numero enter (1 - 5) ||");
			break;
		}

	}

	private static void reinicairContrasenia() {
		// TODO Auto-generated method stub

	}

	private static void cambiarContrasenia() {
		// TODO Auto-generated method stub

	}

	private static void iniciarSesion() {
		// TODO Auto-generated method stub

	}

	private static void registrarusuario() {
		// TODO Auto-generated method stub

	}

	private static void precargasDatos() {

	}

	private static void menu() {
		System.out.println(":::: Menú Principal ::::");
		System.out.println("1. Registrar Usuario");
		System.out.println("2. Iniciar Sesión");
		System.out.println("3. Cambiar Contraseña");
		System.out.println("4. Reiniciar Contraseña");
		System.out.println("5. Salir");
		System.out.print(">>>>>>>>>>>>>>");

	}
}
