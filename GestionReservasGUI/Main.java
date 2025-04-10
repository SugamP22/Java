package activivdadJOption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Main {
	public static GestionarReservas gestion = new GestionarReservas();
	public static StringBuilder builder;
	public static void main(String[] args) {
		iniciarMain();

	}

	private static void iniciarMain() {
		int opcion = 0;
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Elige una opcion:\n1. Agregar un reserva\n2. Eliminar Reserva\n3. Mostrar Reserva\n4. Salir",
						"Menú", JOptionPane.INFORMATION_MESSAGE));

				switchMain(opcion);

			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Error: Entrada Invalido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while (opcion != 4);

	}

	private static void switchMain(int opcion) {
		switch (opcion) {
		case 1:
			aniadirReserva();
			break;
		case 2:
			eliminarReserva();
			break;
		case 3:
			mostrarReserva();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Gracias por su participación.❤️❤️");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error: Entrada Inválido Ingresa numero entre 1 e 4 ", "Error",
					JOptionPane.ERROR_MESSAGE);
			break;
		}

	}

	private static void mostrarReserva() {
		if (GestionarReservas.reserva.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: No hay ningun reserva registrado", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
	}
		if (GestionarReservas.reserva.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: Resistro sin reserva!!", "Error", JOptionPane.ERROR_MESSAGE);

		}
		 builder = new StringBuilder();
		for (Reservas r : GestionarReservas.reserva) {
			builder.append(r.toString() + "\n");
		}
		JOptionPane.showMessageDialog(null, "Registro de Reservas:\n" + builder.toString(), "Registro",
				JOptionPane.INFORMATION_MESSAGE);
	}
		

		private static void eliminarReserva() {
		while (true) {
			try {
				if (GestionarReservas.reserva.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error: No hay ningun reserva registrado", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} 
					mostrarReserva();
					String nombre = JOptionPane.showInputDialog(null,"Introduce el nombre del huespeda\n"+ builder.toString());
					int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce La id del huespeda\n"+builder.toString()));
					gestion.eliminarReserva(nombre, id);
					return;
				
			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Error: Entrada invalido!!", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	private static void aniadirReserva() {
		boolean flag = false;
		while (!flag) {
			String tipo = JOptionPane.showInputDialog(null, "Introduce el tipo de habitacion\n|SIMPLE|DOBLE|SUITE|");

			try {
				Tipo validoTipo = Tipo.valueOf(tipo.toUpperCase());
				String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre:");
				String preferencia = JOptionPane.showInputDialog(null, "Introduce su preferencia:");
				String fechaEntrada = "Introduce la fecha de Entrada";
				LocalDate fechaEntradaValido = validarFecha(fechaEntrada);
				String fechaSalida = "Introduce la fecha de Salida:";
				LocalDate fechaSalidaValido = validarFecha(fechaSalida);
				if (fechaEntradaValido == null || fechaSalidaValido == null) {
					throw new IllegalArgumentException("La fecha no puede ser null");
				}
				Reservas reserva = new Reservas(fechaEntradaValido, fechaSalidaValido, new Habitacion(validoTipo),
						new Huespeda(nombre, preferencia));
				if (!gestion.añadirReserva(reserva)) {
					JOptionPane.showMessageDialog(null, "No podido añadir la reserva😊😊");
				}
				JOptionPane.showMessageDialog(null, "Reserva añadido con exito😊😊");
				flag = true;

			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Error: Inválido tipo porfavor ingresa:\n|SIMPLE|DOBLE|SUITE|",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

			}
		}

	}

	private static LocalDate validarFecha(String string) {
		LocalDate valido = null;
		boolean flag = false;
		while (!flag) {
			String fecha = JOptionPane.showInputDialog(null, string + "(MM/dd/yyyy)", "Validar fecha",
					JOptionPane.INFORMATION_MESSAGE);
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			try {
				valido = LocalDate.parse(fecha, formato);

				return valido;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error: Inválido fecha porfavor (MM/dd/yyyy)", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return valido;

	}
}
