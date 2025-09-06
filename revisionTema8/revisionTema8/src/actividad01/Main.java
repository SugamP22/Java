/*Crea un programa que permita al usuario crear un archivo y 
 * un directorio. El programa debe solicitar al usuario el
 *  nombre del archivo y del directorio y luego crear ambos en 
 *  el sistema de archivos.*/
package actividad01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		boolean salir = false;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (!salir) {
				try {

					System.out.println("Introduce nombre del directorio:");
					String nombreDirectorio = br.readLine();
					File directorio = new File(nombreDirectorio);

					if (directorio.exists()) {
						if (directorio.isFile()) {
							throw new IllegalArgumentException("Error: Existe un archivo con este mismom nombre!!");
						} else {
							throw new IllegalArgumentException("Error: ya existe un directorio con esa mismo nombre!!");
						}
					} else {
						if (directorio.mkdir()) {
							System.out.println("Directorio creado con exito!!");
						} else {
							System.err.println("Error: Tuvo un problema al hora de crear esa directorio!!");
						}
					}

					System.out.println("Quieres crear un narchivo en esa carpeta(s/n)");
					if (br.readLine().equalsIgnoreCase("s")) {
						System.out.println("Introduce nombre del archivo: ");
						String nombreArchivo = br.readLine();
						File archivo = new File(directorio.getPath() + "/" + nombreArchivo);
						if (archivo.exists()) {
							if (archivo.isFile()) {
								throw new IllegalArgumentException("Error: Existe un archivo con este mismom nombre!!");
							} else {
								throw new IllegalArgumentException(
										"Error: ya existe un directorio con esa mismo nombre!!");
							}
						} else {
							if (archivo.createNewFile()) {
								System.out.println("Archivo creado con exito!!");
							} else {
								System.err.println("Error: Tuvo un problema al hora de crear esa directorio!!");
							}
						}
					}
					System.out.println("¿Deseas crear otro directorio? (s/n):");
					if (!br.readLine().equalsIgnoreCase("s")) {
						salir = true;
						System.out.println("Programa finalizado.");
					}

				} catch (IOException e) {
					e.printStackTrace();

				} catch (IllegalArgumentException e) {
					System.err.println("Error: " + e.getMessage());
				}
			}

		} catch (IOException e) {
			System.err.println("Error en manejar bufferReader" + e.getMessage());
		}

	}
}
