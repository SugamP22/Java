package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Mostrar Botones");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		JButton botonUno = new JButton("Azul");
		botonUno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.BLUE);

			}
		});

		panel.add(botonUno);
		JButton botonDos = new JButton("Verde");
		botonDos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.green);

			}
		});
		panel.add(botonDos);
		JButton botonTres = new JButton("Rojo");
		botonTres.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.red);

			}
		});
		panel.add(botonTres);
		frame.add(panel);
		frame.setVisible(true);

	}
}
