package ejeFor;

import java.util.Scanner;

public class Eje05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número:::>");
		int res = 1;
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			res *= i;
		}
		System.out.printf("la factorial de numero %d es %d",num,res);
		sc.close();
	}
}
