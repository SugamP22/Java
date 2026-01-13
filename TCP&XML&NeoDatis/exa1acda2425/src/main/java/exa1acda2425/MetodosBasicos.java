package exa1acda2425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MetodosBasicos {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String leerString(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				String res = br.readLine().trim();
				if (!res.isEmpty())
					return res;
				System.err.println("Error: No puede ser vació!!");
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public static int leerInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				String res = br.readLine().trim();
				if (!res.isEmpty()) {
					int num = Integer.parseInt(res);
					return num;
				}
				System.err.println("Error: No puede ser vació!!");
			} catch (IOException | NumberFormatException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public static Integer leerInteger(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				String res = br.readLine().trim();
					Integer num = Integer.parseInt(res);
					return num;
			} catch (IOException | NumberFormatException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public static String leerStringOpcional(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				String res = br.readLine().trim();

				return res;
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

}
