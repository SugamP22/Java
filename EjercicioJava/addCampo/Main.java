package addCampo;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static JFrame frame = new JFrame();

	public static void main(String[] args) {
		frame.setSize(300,300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JLabel labelUna = new JLabel("Ingresa Primer numero");
		panel.add(labelUna);
		TextField textoUno = new TextField(10);
		panel.add(textoUno);
		JLabel labelDos = new JLabel("Ingresa Primer numero");
		panel.add(labelDos);
		TextField textoDos = new TextField(10);
		panel.add(textoDos);
		JButton button = new JButton("Crear");
		TextField textoTres = new TextField(10);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int primerNumero = Integer.parseInt(textoUno.getText());
				int secundoNumero = Integer.parseInt(textoDos.getText());
				int numeroAliatorio = (int) (Math.random() * secundoNumero) + primerNumero;
				System.out.printf("El numero aleatorio es: %d\n", numeroAliatorio);
				textoTres.setText(""+numeroAliatorio);
			}
		});
		panel.add(button);
		panel.add(textoTres);
		frame.add(panel);
		frame.setVisible(true);
	}
}
