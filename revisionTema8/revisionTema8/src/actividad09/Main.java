package actividad09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static String nombre = "Persona.txt";

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			File fichero = new File(nombre);
			if (fichero.exists() && fichero.isFile()) {
				System.out.println("Fichero encontrado, Mostrando la data de fichero...");
				FileReader reader = new FileReader(fichero);
				int charater = reader.read();
				while (charater != -1) {
					
					System.out.print((char) charater);
					charater = reader.read();
				}
				reader.close();
			} else {
				FileWriter writer = new FileWriter(fichero);
				System.out.println("Introduce nombre de persona: ");
				String name = br.readLine();
				writer.write(name + "\n");
				System.out.println("Introduce APellido del persona: ");
				String apellido = br.readLine();
				writer.append(apellido + "\n");
				System.out.println("Introduce edad del persona: ");
				int edad = Integer.parseInt(br.readLine());
				writer.append(edad + "\n");
				System.out.println("Creado con exito");
				writer.close();

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
