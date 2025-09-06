package timeDAte;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class Evento {
	private LocalDate dateOfBirth;

	public Evento(String dateOfBirth) {
		setDateOfBirth(dateOfBirth);
	}

	public void setDateOfBirth(String dateOfBirth) {
		LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

	}

	@Override
	public String toString() {
		return "Date of Birth: " + dateOfBirth;
	}
}

public class Prac01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Solicitar al usuario ingresar una fecha
		System.out.print("Enter date of birth (MM/dd/yyyy): ");
		String userInput = scanner.nextLine();

		try {
			// Crear un objeto Evento usando la fecha ingresada
			Evento evento = new Evento(userInput);
			System.out.println(evento); // Mostrar la fecha de nacimiento
		} catch (IllegalArgumentException e) {
			// Mostrar mensaje de error si el formato es incorrecto
			System.out.println(e.getMessage());
		}

		scanner.close();
	}
}
