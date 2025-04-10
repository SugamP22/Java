package ejeFor;

import java.util.Scanner;

public class Fibo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un numero:::>");
		int num = sc.nextInt();
		int a = 0;
		int b = 1;
		System.out.print(a + ", " + b + ", ");
		for (int i = 3; i <= num; i++) {
			int c = a + b;
			System.out.print(c + ((i == num) ? "" : ", "));
			a = b;
			b = c;

			sc.close();
		}

	}
}
