package actividadCasa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class GestionDeReservas {
	private static HashSet<Reservas> reservas = new HashSet<>();

	public static void main(String[] args) {
		iniciarMain();
		JOptionPane.showMessageDialog(null, "Gracias POr su Participar❤️❤️!!", null, JOptionPane.PLAIN_MESSAGE);
	}

	private static void iniciarMain() {
		int inputUsuario = 0;
		do {
			try {
				inputUsuario = menu();
				switchMain(inputUsuario);
			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Error: por favor, Ingrese un numero!!🔢", null,
						JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while (inputUsuario != 4);

	}

	private static void switchMain(int inputUsuario) {
		switch (inputUsuario) {
		case 1:
			aniadirReserva();
			break;
		case 2:
			cancelarReserva();
			break;
		case 3:
			mostrarReserva();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Saliendo..", "Salida", JOptionPane.WARNING_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error: Introduce un numero entre 1 e 4", "Error",
					JOptionPane.ERROR_MESSAGE);
			break;
		}

	}

	private static void cancelarReserva() {
		if (reservas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: No hay ningun reserva registrada para eliminar!!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		StringBuilder info = new StringBuilder();
		for (Reservas r : reservas) {
			info.append(r.toString()).append("\n");
		}

		int idHuespede = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Introduce un id de Huespede que deseas cancelar:\n" + info.toString()));
		int idHabitacion = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Introduce un id Habitacion que deseas cancelar:\n" + info.toString()));

		boolean reservaEncontrada = false;
		Iterator<Reservas> iterator = reservas.iterator();
		while (iterator.hasNext() && !reservaEncontrada) {
			Reservas r = iterator.next();
			if (r.getHabitaciones().getId() == idHabitacion && r.getHuespedes().getId() == idHuespede) {
				iterator.remove(); // Removes the reservation
				JOptionPane.showMessageDialog(null, "Eliminado con exito!!", null, JOptionPane.INFORMATION_MESSAGE);
				reservaEncontrada = true;
			}
		}

		if (!reservaEncontrada) {
			JOptionPane.showMessageDialog(null, "Reserva con este id habitacion y id huespede no encontrado!!", null,
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private static void mostrarReserva() {
		if (reservas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: No hay ningun reserva registrado para eliminar!!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;

		}
		StringBuilder info = new StringBuilder();
		for (Reservas r : reservas) {
			info.append(r.toString()).append("\n");

		}
		JOptionPane.showMessageDialog(null, info.toString());
	}

	private static void aniadirReserva() {
		boolean flag = false;
		String nombre = JOptionPane.showInputDialog(null, "¿Introduce nombre de huéspedes?", "Detalle",
				JOptionPane.QUESTION_MESSAGE);
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Introduce id de huéspedes?", "Detalle",
				JOptionPane.QUESTION_MESSAGE));

		String preferencia = JOptionPane.showInputDialog(null, "¿Introduce preferencia de huéspedes?", "Detalle",
				JOptionPane.QUESTION_MESSAGE);
		while (!flag) {
			String tipoHuespede = JOptionPane.showInputDialog(null,
					"¿Introduce Tipo de Habitacion?\n1. SIMPLE\n2. DOUBLE\n3. SUITE", "Detalle",
					JOptionPane.QUESTION_MESSAGE);
			try {
				Tipo tipo = Tipo.valueOf(tipoHuespede.toUpperCase());
				LocalDate fechaEntrada = ValidarFecha("fecha de entrada(MM/dd/yyyy)");
				LocalDate fecahSalida = ValidarFecha("fecha de salida(MM/dd/yyyy)");
				if (reservas.add(new Reservas(fechaEntrada, fecahSalida, new Habitaciones(tipo),
						new Huespedes(nombre, id, preferencia)))) {
					JOptionPane.showMessageDialog(null, "Reserva añadido con exito", null,
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					JOptionPane.showMessageDialog(null, "Reservacion duplicado!!", null, JOptionPane.ERROR_MESSAGE);
				}
				flag = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error: Ingresa un tipo valido\n 1.SIMPLE\2.DOUBLE\3.SUITE", null,
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private static LocalDate ValidarFecha(String mensaje) {
		boolean flag = false;
		while (!flag) {
			String fecha = JOptionPane.showInputDialog(null, "¿Introduce la" + mensaje, "Fecha",
					JOptionPane.QUESTION_MESSAGE);
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			try {
				LocalDate fechavalido = LocalDate.parse(fecha, formato);
				return fechavalido;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error: Invalido Formato de Fecha (MM/dd/yyyy)");
			}

		}
		return null;

	}

	private static int menu() {
		return Integer.parseInt(JOptionPane.showInputDialog(null,
				"Eligir una opcion: \n1. Añadir reservar\n2. Cancelar reservas\n3. Mostrar reservas\n4. Salir", "Menú",
				JOptionPane.QUESTION_MESSAGE));

	}
}
