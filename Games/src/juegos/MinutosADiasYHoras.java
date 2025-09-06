package Juegos;

import java.util.Scanner;

public class MinutosADiasYHoras {
	public static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Introduce una cantidadde minutos:::>");
		int cantidadMinutos = sc.nextInt();
		int minutos = cantidadMinutos % 60;
		int horas = ((cantidadMinutos - minutos) / 60) % 24;
		int dias = ((cantidadMinutos - minutos) / 60) / 24;
		System.out.printf("Dias: %d | Horas: %d | Minutos: %d", dias, horas, minutos);

	}
}
