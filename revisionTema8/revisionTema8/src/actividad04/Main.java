/*Crea un programa que pida al usuario el nombre de la carpeta padre y 
 * el nombre de la carpeta hija, con el método mkdirs() 
 * crea las dos carpetas en una sola sola sentencia.*/
package actividad04;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Introduce nombre de carpeta padre: ");
			String nombrePadre = br.readLine();
			File carpetaPadre = new File(nombrePadre);
			if (carpetaPadre.exists()) {
				if (carpetaPadre.exists()) {
					throw new IllegalArgumentException(carpetaPadre.isFile() ? "Ya existe un archivo con ese nombre!!"
							: "Ya existe una carpeta con ese nombre!!");
				}

			} else {
				if (carpetaPadre.mkdirs()) {
					System.out.println("Carpeat padre creado con exitó!!");
					System.out.println("¿Quieres crear un carpeta dentro del esa carpeta(s/n)?");
					if (br.readLine().equalsIgnoreCase("s")) {
						System.out.println("Introduce nombre de carpeta hijo: ");
						String nombrehijo = br.readLine();
						File carpetaHijo = new File(carpetaPadre,nombrehijo);
						if (carpetaHijo.mkdirs()) {
							System.out.println("Carpeta hijo creado con exito!!");
						} else {

							throw new IllegalArgumentException("Tuvo un problema al crear carpeta hijo!!");
						}
					}
					
				} else {
					throw new IllegalArgumentException("Tuvo un problema al crear carpeta padre!!");
				}

			}
			System.out.println("Saliendo del programa...");
		} catch (IOException e) {
			System.err.println("Error al manejar bufferReader " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
