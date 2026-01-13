package exa1acad2526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MetodosBasicos {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String leerStringOptional(String prompt) {
		while (true) {
			System.out.print(prompt);
			String res;
			try {
				res = br.readLine().trim();
				return res;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public static String leerString(String prompt) {
		while (true) {
			System.out.print(prompt);
			String res;
			try {
				res = br.readLine().trim();
				if (!res.isEmpty()) {
					return res;
				}
				System.err.println("Error: No puede ser valido!!");
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
				// TODO Auto-generated catch block
			}
		}
	}

	public static int leerInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			String res;
			try {
				res = br.readLine().trim();
				if (!res.isEmpty()) {
					int numeroInt = Integer.parseInt(res);
					return numeroInt;
				}
				System.err.println("Error: No puede ser valido!!");
			} catch (IOException | NumberFormatException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
}
