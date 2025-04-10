/*- Calculadora Versión Básica:
    
    Crea una calculadora con dos campos de entrada para recibir dos números.
    
    Crea cuatro botones que representarán las cuatro operaciones básicas.
    
    Crea un campo de salida para mostrar el resultado.*/
package calculadoraBasico;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static JFrame frame = new JFrame("Calculadora Basico");
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
		JTextField texto1 = new JTextField();
		texto1.setPreferredSize(new Dimension(300, 50));
		panel1.add(texto1);

		panel2.setPreferredSize(new Dimension(400, 80));
		frame.add(panel2);
		JTextField texto2 = new JTextField();
		texto2.setPreferredSize(new Dimension(300, 50));
		panel2.add(texto2);

		panel3.setPreferredSize(new Dimension(400, 50));
		
		frame.add(panel3);
		JButton button1 = new JButton("+");
		JButton button2 = new JButton("-");
		JButton button3 = new JButton("*");
		JButton button4 = new JButton("/");
		panel3.add(button1);
		panel3.add(button2);
		panel3.add(button3);
		panel3.add(button4);

		panel4.setPreferredSize(new Dimension(400, 80));
		frame.add(panel4);
		JTextField texto3 = new JTextField();
		texto3.setPreferredSize(new Dimension(300, 50));

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(texto1.getText());
				double num2 = Double.parseDouble(texto2.getText());
				double res= num1 + num2;
				texto3.setText(" "+res);
				

			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(texto1.getText());
				double num2 = Double.parseDouble(texto2.getText());
				double res= num1 - num2;
				texto3.setText(String.valueOf(res));
				
				
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(texto1.getText());
				double num2 = Double.parseDouble(texto2.getText());
				double res= num1 * num2;
				texto3.setText(String.valueOf(res));
				
				
			}
		});
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(texto1.getText());
				double num2 = Double.parseDouble(texto2.getText());
				double res= num1 / num2;
				texto3.setText(String.valueOf(res));
				
				
			}
		});

		panel4.add(texto3);

		frame.setVisible(true);
		frame.pack();
	}
}
