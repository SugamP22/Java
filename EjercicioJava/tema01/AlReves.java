package tema01;

import java.util.Scanner;

public class AlReves {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dar me un numero con 3 cifras:");
		int num = sc.nextInt();
		int num1 = num / 100; // ya que es un int quedo con un valor sin decimal(es decir con el cifra del
								// posicion uno)
		int num2 = (num % 100) / 10;// primer calculacion me deja con dos numeros(secunda y tercerra cifra) y
									// despues al dividor
									// con 10 quedo con uno solo cifra que va a ser de posicion 2.
		int num3 = (num % 10);// para quedar con la cifra de la ultima posicion.
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		int resultado = num3 * 100 + num2 * 10 + num1;
		System.out.println(resultado);
		sc.close();
	}
}
