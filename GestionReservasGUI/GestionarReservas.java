package activivdadJOption;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class GestionarReservas {
	public static HashSet<Reservas> reserva;

	public GestionarReservas() {
		reserva = new HashSet<Reservas>();
	}

	public boolean añadirReserva(Reservas r1) {
		return reserva.add(r1);
	}

	public void eliminarReserva(String nombre, int id) {
		if (reserva.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: No hay ningun reserva registrado", "Error",
					JOptionPane.ERROR_MESSAGE);

		}

		Iterator<Reservas> it = reserva.iterator();
		if (it.hasNext()) {
			Reservas reserva = it.next();
			if (reserva.getHuespeda().getNombre().equalsIgnoreCase(nombre) && reserva.getHuespeda().getId() == id) {
				it.remove();
				JOptionPane.showMessageDialog(null, "Eliminado con éxito!!", "Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		} 

			JOptionPane.showMessageDialog(null, "Error: Reserva no encontrado!!", "Error", JOptionPane.ERROR_MESSAGE);
			return;

	}
}
