package actividad02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		boolean continuar = true;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (continuar) {
				try {
					// Renombrar directorio
					System.out.println("Introduce el nombre del directorio que deseas cambiar:");
					String nombreDirectorio = br.readLine();
					System.out.println("Introduce el nuevo nombre del directorio:");
					String nuevoNombreDirectorio = br.readLine();

					File directorio = new File(nombreDirectorio);
					File nuevoDirectorio = new File(nuevoNombreDirectorio);

					if (directorio.exists() && directorio.isDirectory()) {
						if (!nuevoDirectorio.exists()) {
							if (directorio.renameTo(nuevoDirectorio)) {
								System.out.println("Nombre del directorio cambiado con éxito!");
							} else {
								throw new IllegalArgumentException("Error: No se pudo renombrar el directorio.");
							}
						} else {
							throw new IllegalArgumentException("Error: Ya existe un directorio con ese nuevo nombre.");
						}
					} else if (nuevoDirectorio.exists()) {
						throw new IllegalArgumentException("Error: Ya existe un directorio con ese nombre.");
					} else {
						throw new IllegalArgumentException("Error: No existe un directorio con ese nombre.");
					}

					// Renombrar archivo dentro del directorio
					System.out.println("¿Deseas cambiar el nombre de un archivo dentro de esta carpeta? (s/n):");
					if (br.readLine().equalsIgnoreCase("s")) {
						System.out.println("Introduce el nombre del archivo que deseas cambiar:");
						String nombreArchivo = br.readLine();
						System.out.println("Introduce el nuevo nombre del archivo:");
						String nuevoNombreArchivo = br.readLine();

						File archivo = new File(nuevoDirectorio.getPath() + "/" + nombreArchivo);
						File nuevoArchivo = new File(nuevoDirectorio.getPath() + "/" + nuevoNombreArchivo);

						if (archivo.exists() && archivo.isFile()) {
							if (!nuevoArchivo.exists()) {
								if (archivo.renameTo(nuevoArchivo)) {
									System.out.println("Nombre del archivo cambiado con éxito!");
								} else {
									throw new IllegalArgumentException("Error: No se pudo renombrar el archivo.");
								}
							} else {
								throw new IllegalArgumentException("Error: Ya existe un archivo con ese nuevo nombre.");
							}
						} else if (nuevoArchivo.exists()) {
							throw new IllegalArgumentException("Error: Ya existe un archivo con ese nombre.");
						} else {
							throw new IllegalArgumentException("Error: No existe un archivo con ese nombre.");
						}
					}

					// Preguntar si desea continuar o salir
					System.out.println("¿Deseas renombrar otro archivo o directorio? (s/n):");
					String respuesta = br.readLine();
					if (respuesta.equalsIgnoreCase("n")) {
						continuar = false;
						System.out.println("Saliendo del programa...");
					}

				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			System.err.println("Error al manejar el BufferedReader: " + e.getMessage());
		}
	}
}
