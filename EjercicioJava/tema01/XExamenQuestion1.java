package tema01;

import java.util.Scanner;

public class XExamenQuestion1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = (int) (Math.random() * (100 - 1 + 1)) + 1;
		String res = r1 % 2 != 0 ? "Impar" : "Par";
		if (res.equals("impar")) {
			System.out.println("El numero para mas cerca del " + r1 + " es " + (r1 + 1));
		} else {
			System.out.println("El numero fue " + r1);
		}
		sc.close();
	}
}
