/*Crea un programa que pida por consola que se introduzca un texto en varias 
 * líneas y que deje de recoger datos cuando pongamos la palabra fin.
 *   Deberemos conocer el número de líneas, de palabras y caracteres.*/
package actividad05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String paraguardar = "";
			int contadorlineas = 0;
			int contadorpalabras = 0;
			int contadorCaracters = 0;
			boolean salir = false;
			while (!salir) {
				System.out.println("Introduce texto:");
				paraguardar = br.readLine();
				if (!paraguardar.equalsIgnoreCase("fin")) {
					contadorlineas+=1;
					String[] palabras = paraguardar.trim().split("\\s");
					contadorpalabras += palabras.length;
					for(String p:palabras) {
						contadorCaracters+=p.length();
					}
				} else {
					System.out.printf("Numero total se lineas es %d\n", contadorlineas);
					System.out.printf("Numero total se palabras es %d\n", contadorpalabras);
					System.out.printf("Numero total se caracteres es %d\n", contadorCaracters);
					salir = true;
				}

			}

		} catch (IOException e) {
			System.err.println("Error al manejar buffereader: " + e.getMessage());
		}
	}
}
