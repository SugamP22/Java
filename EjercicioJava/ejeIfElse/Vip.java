package ejeIfElse;

import java.util.Scanner;

public class Vip {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tu edad:::::>");
		int edad = sc.nextInt();
		if (edad < 12) {
			System.out.println("Eres muy chiquito para subir esat attarcion!!");
		} else if (edad >= 12 && edad <= 15) {
			System.out.print("¿Estas acompañado con un adulto(sí/no)::>");
			boolean adulto = sc.next().equalsIgnoreCase("sí");
			if (adulto) {
				System.out.println("Disfruta la atracción!!");
			} else {
				System.out.print("Tiene una pase Vip(sí/no)?::>");
				boolean vip = sc.next().equalsIgnoreCase("sí");
				if (!vip) {
					System.out.print("¿Cuando mides?::>");
					float medida = sc.nextInt();
					if (medida >= 130) {
						System.out.println("Disfruta la atracción!!");
					} else {
						System.out.println("Tiene que medir al menos 130 para subir sin pase Vip!!");
					}
				} else {
					System.out.println("Disfruta la atracción!!");
				}
			}
		} else {
			System.out.print("Tiene una pase Vip(sí/no)?::>");
			boolean vip = sc.next().equalsIgnoreCase("sí");
			if (!vip) {
				System.out.print("¿Cuando mides?::>");
				float medida = sc.nextInt();
				if (medida >= 130) {
					System.out.println("Disfruta la atracción!!");
				} else {
					System.out.println("debes medir al menos 130 para subir sin pase Vip!!");
				}
			} else {
				System.out.println("Disfruta la atracción!!");
			}
		}
		sc.close();
	}
}