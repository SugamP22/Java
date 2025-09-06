//- El usuario introduce una contraseña y el programa verifica si cumple con requisitos:
//    - Mínimo 8 caracteres
//    - Al menos una mayúscula
//    - Al menos un número
package actividad08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String texto = br.readLine();
			if (validarContraseña(texto)) {
				System.out.println("Si se cumple con la contraseña!!");
			} else {
				System.err.println("No cumple con la validacion!!");
			}
		} catch (IOException e) {
			System.err.println("Error: tuvo problema al manejar BufferReader, " + e.getMessage());
		}
	}

	private static boolean validarContraseña(String texto) {
		return texto.matches("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$");
		// TODO Auto-generated m8,ethod stub

	}
}
