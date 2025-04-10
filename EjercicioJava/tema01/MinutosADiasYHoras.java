package tema01;

import java.util.Scanner;

//pregunta al usuario un cantidad de minutos y convirtir en dias y horas.
public class MinutosADiasYHoras {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una cantidad del tiempo: ");
		int minutos = sc.nextInt();// un dia tiene 24*60
		int dia = minutos / (24 * 60);
		// para sacar horas
		double horas = (minutos % (24 * 60)) / 60;
		// por que al devidor los minutos con 60 los restante con 0 van a ser horas y
		// los restantes mayor que cero horas.
		int minutosact = minutos % 60;
		System.out.printf("Al convetir los minutos introducido quedas con %d dias, %.2f horas, %d minutos", dia, horas,
				minutosact);
		sc.close();
	}
}
