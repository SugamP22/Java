package actividad10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			File file = new File("Saludo.txt");
			if (!(file.exists() && file.isFile())) {
				System.out.println("No existe ningun archivo con ese nombre!!");
			} else {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String palabras;
				String nuevoLinea = "";
				while ((palabras = reader.readLine()) != null) {
					if (palabras.contains("Hola mundo")) {
						palabras = palabras.replace("Hola mundo", "adios mundo");

					}
					nuevoLinea += palabras + "\n";

				}
				reader.close();
				System.out.println("Cambiado con exitó ahora vamos a excribir!!");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(nuevoLinea);
				writer.close();
				System.out.println("Cambios modificado con exito");
			}

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
