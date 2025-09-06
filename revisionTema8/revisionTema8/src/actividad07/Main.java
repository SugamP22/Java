/*El usuario va escribiendo números 
 * (uno por línea) y el programa va sumando. 
 * Termina cuando se escribe "fin".*/
package actividad07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int sumaTotal = 0;
			String numeros = "";
			while (true) {
				System.out.println("Introduce un numero:");
				numeros = br.readLine().trim();
				if (numeros.equalsIgnoreCase("fin")) {
					System.out.printf("| SumaTotal: %10d |\n", sumaTotal);
					return;
				} else {
					try {
						sumaTotal += Integer.parseInt(numeros);
						
					} catch (NumberFormatException e) {
						System.err.println("Error: Numero introducido es invalido!!");
					}
				}
			}

		} catch (IOException e) {
			System.err.println("Error: tuvo problema al manejar bufferReader, " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
