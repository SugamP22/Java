package peval3acda2526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MetodosBasicos {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String leerStringOpcional(String prompt) {
		while (true) {
			System.out.print(prompt);
			String res;
			try {
				res = br.readLine();
				return res;
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public static String leerString(String prompt) {
		while (true) {
			System.out.print(prompt);
			String res;
			try {
				res = br.readLine();
				if (!res.isEmpty())
					return res;
				System.err.println("Error: No puede ser un nulo");
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public static int leerInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			String res;
			try {
				res = br.readLine();
				if (!res.isEmpty()) {
					int num = Integer.parseInt(res);
					return num;
				}
				System.err.println("Error: No puede ser un nulo");
			} catch (IOException | NumberFormatException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public static double leerDouble(String string) {
		while (true) {
			System.out.print(string);
			String res;
			try {
				res = br.readLine();
				if (!res.isEmpty()) {
					double num = Double.parseDouble(res);
					return num;
				}
				System.err.println("Error: No puede ser un nulo");
			} catch (IOException | NumberFormatException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
}
