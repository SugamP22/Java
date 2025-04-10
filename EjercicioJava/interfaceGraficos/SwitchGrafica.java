package interfaceGraficos;

import javax.swing.JOptionPane;

public class SwitchGrafica {
	public static void main(String[] args) {
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas continuar con el proceso?");

		switch (respuesta) {
		case JOptionPane.YES_OPTION:
			System.out.println("El usuario eligió 'Sí'.");
			// Lógica para continuar con el proceso
			break;
		case JOptionPane.NO_OPTION:
			System.out.println("El usuario eligió 'No'.");
			// Lógica para no continuar
			break;
		case JOptionPane.CANCEL_OPTION:
			System.out.println("El usuario eligió 'Cancelar'.");
			// Lógica para manejar la cancelación
			break;
		case JOptionPane.CLOSED_OPTION:
			System.out.println("El usuario cerró el diálogo.");
			// Lógica para manejar el cierre del diálogo
			break;
		}
	}
}
