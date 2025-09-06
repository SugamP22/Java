package pracPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Panel {
	static JFrame frame = new JFrame();
	static Border border = BorderFactory.createLineBorder(Color.black, 1);

	public static void main(String[] args) {
		frame.setLayout(new GridLayout(2,0));
		JPanel topPanel = new JPanel();
		JTextField texto = new JTextField();
		texto.setBackground(Color.white);
		texto.setBorder(border);
		topPanel.add(texto);
		frame.add(topPanel);
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new GridLayout(4, 4));
		downPanel.setPreferredSize(new Dimension(500, 600));
		JPanel red1 = createPanel(Color.ORANGE);
		JPanel red2 = createPanel(Color.ORANGE);
		JPanel red3 = createPanel(Color.ORANGE);
		JPanel red4 = createPanel(Color.ORANGE);
		JPanel cya1 = createPanel(Color.ORANGE);
		JPanel cya2 = createPanel(Color.ORANGE);
		JPanel cya3 = createPanel(Color.ORANGE);
		JPanel cya4 = createPanel(Color.ORANGE);
		JPanel yel1 = createPanel(Color.ORANGE);
		JPanel yel2 = createPanel(Color.ORANGE);
		JPanel yel3 = createPanel(Color.ORANGE);
		JPanel yel4 = createPanel(Color.ORANGE);
		JPanel twq1 = createPanel(Color.ORANGE);
		JPanel twq2 = createPanel(Color.ORANGE);
		JPanel twq3 = createPanel(Color.ORANGE);
		JPanel twq4 = createPanel(Color.ORANGE);

		downPanel.add(red1);
		downPanel.add(red2);
		downPanel.add(red3);
		downPanel.add(red4);
		downPanel.add(cya1);
		downPanel.add(cya2);
		downPanel.add(cya3);
		downPanel.add(cya4);
		downPanel.add(yel1);
		downPanel.add(yel2);
		downPanel.add(yel3);
		downPanel.add(yel4);
		downPanel.add(twq1);
		downPanel.add(twq2);
		downPanel.add(twq3);
		downPanel.add(twq4);

		frame.add(downPanel);
		frame.setVisible(true);
		frame.pack();

	}

	public static JPanel createPanel(Color color) {
		JPanel panel = new JPanel();
		panel.setBackground(color);
		panel.setOpaque(true);
		panel.setBorder(border);
		return panel;
	}
}
