package actividad06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			boolean salir = false;
			System.out.println("Escrbir salir para salir del loop: ");
			while (!salir) {
				System.out.println("--------------->");
				String texto = br.readLine().trim();
				if (!texto.equalsIgnoreCase("salir")) {
					for (int i = texto.length() - 1; i >= 0; i--) {
						System.out.print(texto.charAt(i));
					}
					System.out.println();
				}else {
					salir=true;
				}

			}
			System.out.println("Gracias por su participación!!");
		} catch (IOException e) {
			System.err.println("ERROR: tuvo un problema al manejar bufferreader" + e.getMessage());
		}
	}
}
