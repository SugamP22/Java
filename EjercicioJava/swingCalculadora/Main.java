package swingCalculadora;

import java.awt.Color;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	public static JFrame frame = new JFrame();

	public static void main(String[] args) {
		frame.setTitle("Calculadora");
		
		frame.setForeground(new Color(0x123456));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel("Ingresa primer numero: ");
		panel.add(label1);
		TextField texto1 = new TextField(10);
		panel.add(texto1);
		JLabel label2 = new JLabel("Ingresa Secundo numero: ");
		panel.add(label2);
		TextField texto2 = new TextField(10);
		panel.add(texto2);
		JButton button1 = new JButton(" + ");
		panel.add(button1);
		JButton button2 = new JButton(" - ");
		panel.add(button2);
		JButton button3 = new JButton(" * ");
		panel.add(button3);
		JButton button4 = new JButton(" / ");
		panel.add(button4);
		TextField texto3 = new TextField(10);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(texto1.getText());
				double num2 = Double.parseDouble(texto1.getText());
				JOptionPane.showMessageDialog(null, "Resultado: " + (num1 + num2));
				texto3.setText("" + (num1 + num2));
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(texto1.getText());
				double num2 = Double.parseDouble(texto1.getText());
				JOptionPane.showMessageDialog(null, "Resultado: " + (num1 - num2));
				texto3.setText("" + (num1 - num2));
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(texto1.getText());
				double num2 = Double.parseDouble(texto1.getText());
				JOptionPane.showMessageDialog(null, "Resultado: " + (num1 * num2));
				texto3.setText("" + (num1 * num2));
			}
		});
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(texto1.getText());
				double num2 = Double.parseDouble(texto1.getText());
				JOptionPane.showMessageDialog(null, "Resultado: " + (num1 / num2));
				texto3.setText("" + (num1 / num2));
			}
		});

	
		panel.add(texto3);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();	
	}
}
