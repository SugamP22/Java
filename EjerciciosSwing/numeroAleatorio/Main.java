package numeroAleatorio;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static JFrame frame = new JFrame("Datos");
	public static JPanel panel1 = new JPanel();
	public static JPanel panel2 = new JPanel();
	public static JPanel panel3 = new JPanel();
	public static JPanel panel4 = new JPanel();

	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(new GridLayout(4, 1));

		panel1.setPreferredSize(new Dimension(400, 80));
		frame.add(panel1);
		JLabel label1 = new JLabel("Ingresa primer número:");
		JTextField texto = new JTextField();
		texto.setPreferredSize(new Dimension(100, 35));
		panel1.add(label1);
		panel1.add(texto);

		panel2.setPreferredSize(new Dimension(400, 80));
		frame.add(panel2);
		JLabel label2 = new JLabel("Ingresa secundo número:");
		JTextField texto2 = new JTextField();
		texto2.setPreferredSize(new Dimension(100, 35));
		panel2.add(label2);
		panel2.add(texto2);

		panel3.setPreferredSize(new Dimension(400, 80));
		frame.add(panel3);
		JButton button = new JButton("Crear");
		panel3.add(button);
		
		
		panel4.setPreferredSize(new Dimension(400, 80));
		frame.add(panel4);
		JTextField texto3 = new JTextField();
		texto3.setPreferredSize(new Dimension(100, 35));
		panel4.add(texto3);
		
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(texto.getText());
				int num2 = Integer.parseInt(texto2.getText());
				int res = (int) (Math.random() * num2) + num1;
				JOptionPane.showMessageDialog(null, "El numero aleatorio es : " + res, "Aleatorio",
						JOptionPane.INFORMATION_MESSAGE);
				texto3.setText(String.valueOf(res));

			}
		});
		

		frame.setVisible(true);
		frame.pack();

	}


}
