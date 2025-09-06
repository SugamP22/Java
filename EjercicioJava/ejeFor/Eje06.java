package ejeFor;

import java.util.Scanner;

public class Eje06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número:::>");
		int num = sc.nextInt();
		for (int i =1; i<=num; i++) {
			for (int j =num ; j >=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
