package crearArchivo;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce nombre del directory::>");
		String nombreDir = sc.nextLine();
		File crearDir = new File("C:/Users/2DAW/Desktop/" + nombreDir);
		if (!crearDir.exists()) {
			if (crearDir.mkdir()) {
				System.out.println("Directorio creado con exito");
			} else {
				System.out.println("Tuvo problema al hora de crear directorio");
			}
		} else {
			System.out.println("El directorio ya existe");
		}
		System.out.println("¿Quieres crear un archivo dentro de esa directorio?(sí/no)");
		boolean valido = sc.next().equalsIgnoreCase("sí");
		sc.nextLine();
		if (valido) {
			System.out.println("Ingresa nombre del archivo con extension(.ser O .txt) ");
			String file = sc.nextLine();
			File crearFile = new File(crearDir.getPath() + "/" + file);
			try {
				if (crearFile.createNewFile()) {
					System.out.println("Archivo creado con exito");

				} else {
					System.out.println("El fichero ya existe");
				}
			} catch (IOException e) {
				System.out.println("Ha Ocurrido un problema");
				e.printStackTrace();
			}

		}

	}
}
