/*- Calculadora Avanzada:
    
    Diseña una Calculadora lo  más parecido a la calculadora de windows, utiliza para ello diferentes layout para diferentes paneles. 
    
    Dale funcionalidad a los botones más relevantes.*/
package calculadoraAvanzado;

import java.awt.BorderLayout;	
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main {
	public static JFrame frame = new JFrame("Calculadora");
	public static JPanel panel1 = new JPanel();
	public static JPanel panel2 = new JPanel();
	public static JPanel panel3 = new JPanel();
	static Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);

	public static void main(String[] args) {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		// panel 1
		panel1.setPreferredSize(new Dimension(400, 100));
		
		frame.add(panel1, BorderLayout.NORTH);

		// panel 2
		panel2.setPreferredSize(new Dimension(400, 50));
		panel2.setLayout(new GridLayout(1, 5));
		panel2.add(crearButton1("M"));
		panel2.add(crearButton1("M-"));
		panel2.add(crearButton1("M+"));
		panel2.add(crearButton1("ME"));
		panel2.add(crearButton1("CE"));
		frame.add(panel2);

		// panel 3
		panel3.setPreferredSize(new Dimension(400, 400));
		panel3.setLayout(new GridLayout(5,4,1,1));
		frame.add(panel3, BorderLayout.SOUTH);
		panel3.add(crearButton2("1"));
		panel3.add(crearButton2("2"));
		panel3.add(crearButton2("3"));
		panel3.add(crearButton2("+"));
		panel3.add(crearButton2("4"));
		panel3.add(crearButton2("5"));
		panel3.add(crearButton2("6"));
		panel3.add(crearButton2("-"));
		panel3.add(crearButton2("7"));
		panel3.add(crearButton2("8"));
		panel3.add(crearButton2("9"));
		panel3.add(crearButton2("*"));
		panel3.add(crearButton2("0"));
		panel3.add(crearButton2("."));
		panel3.add(crearButton2("("));
		panel3.add(crearButton2(")"));
		panel3.add(crearButton2("1/2"));
		panel3.add(crearButton2("&"));
		panel3.add(crearButton2("%"));
		panel3.add(crearButton2("="));
		frame.setVisible(true);
		frame.pack();

	}

	private static JButton crearButton1(String string) {
		JButton button=new JButton(string);
		button.setBackground(Color.white);
		button.setBorder(null);
		return button;
	}
	private static JButton crearButton2(String string) {
		JButton button=new JButton(string);
		button.setBackground(Color.white);	
		button.setBorder(border);
		return button;
	}
}
