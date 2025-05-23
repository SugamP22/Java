package actividad12;

public class Main {
	public static void main(String[] args) {
		for (int i = 2; i <= 500; i++) {
			if (primenumber(i)) {
				System.out.println(i);
			}
		}
	}

	private static boolean primenumber(int num) {
		int contador = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				contador++;
			}
		}
		if (contador > 2) {

			return false;
		}
		return true;
	}
}
