package interfaceGraficos;

import javax.swing.JOptionPane;

public class InputMensaje {
	public static void main(String[] args) {
		String respuesta = JOptionPane.showInputDialog("¿Cuál es tu nombre?");
		JOptionPane.showMessageDialog(null, "Hola, " + respuesta + "!");
	}
}
