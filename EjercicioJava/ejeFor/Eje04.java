package ejeFor;

import java.util.Scanner;

public class Eje04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un numero::::>");
		int num = sc.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d\n" + "", num, i, (num * i));
		}
		sc.close();
	}
}
