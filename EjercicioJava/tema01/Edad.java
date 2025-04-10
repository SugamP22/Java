package tema01;

import java.util.Scanner;

public class Edad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// pedimos los datos actual y datos de su nacimiento
		int anioAct = 2024;
		System.out.print("Introduce tu año de nacimiento:");
		int anioNaci = sc.nextInt();
		System.out.print("Introduce tu mes de nacimiento:");
		int mesNaci = sc.nextInt();
		System.out.print("Introduce tu dia de nacimiento:");
		int diaNaci = sc.nextInt();
		System.out.print("Introduce el mes actual: ");
		int mesAct = sc.nextInt();
		System.out.print("introduce el dia actual: ");
		int diaAct = sc.nextInt();
		// convirtir todos los datos obtenidos en forma de dias
		int diaTotalNaci = (mesNaci * 30) + (diaNaci) + (anioNaci * 12 * 30);
		int diaTotalAct = (diaAct) + (mesAct * 30) + (anioAct * 12 * 30);
		// calculamos su edad en forma de dias
		int edadConDia = diaTotalAct - diaTotalNaci;
		// dividimos con dias que consiste un anio para sacar su edad
		int edad = edadConDia / (12 * 30);
		// Usamos los dias restantes por un lado dividiendo para sacar mes actual y
		// cogiendo la restante de la division para sacar la dias.
		int Paradia = edadConDia % (12 * 30);
		int mes = Paradia / 30;
		int dia = Paradia % 30;
		System.out.println("*********************************");
		System.out.printf("El persona introducido tiene edad %d años %d mes y %d dias.", edad, mes, dia);
		sc.close();
	}
}
