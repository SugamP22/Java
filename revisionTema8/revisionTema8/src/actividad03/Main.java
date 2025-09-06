/*Crea un programa que permita al usuario eliminar un archivo y un directorio. 
 * El programa debe solicitar al usuario el nombre del archivo y del
 *  directorio a eliminar, y luego eliminarlos.*/
package actividad03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Introduce nombre de directorio: ");
			String nombreDir = br.readLine();
			System.out.println("Introduce nombre del archivo: ");
			String nombreArchivo = br.readLine();
			File dir = new File(nombreDir);
			if (dir.exists() && dir.isDirectory()) {
				File archivo = new File(dir.getPath() + "/" + nombreArchivo);
				if (archivo.exists() && archivo.isFile()) {
					if (archivo.delete()) {
						System.out.println("Archivo eliminado con exitó!!");
						System.out.println("¿Quieres elimar directorio tambien(s/n)?");
						if (br.readLine().equalsIgnoreCase("s")) {
							if (dir.delete()) {
								System.out.println("Directorio eliminado con exitó!!");
							} else {
								throw new IllegalArgumentException("Tuvo problema al hora de eliminar directorio!!");
							}
						}
					} else {
						throw new IllegalArgumentException("Tuvo problema al hora de eliminar archivo!!");
					}
				} else {
					throw new IllegalArgumentException("No existe archivo con esa nombre!!");
				}
			} else if (dir.exists() && dir.isFile()) {
				throw new IllegalArgumentException("Ya existe un archivo con ese nombre!!");
			} else {
				throw new IllegalArgumentException("No existe un directorio con esa nombre!!");
			}
			System.out.println("Saliendo del programa...");

		} catch (IOException e) {
			System.err.println("Error al manejar bufferReader!!" + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
