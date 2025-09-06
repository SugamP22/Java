/*
 * This program creates a simple graphical interface with three panels and a series of buttons.
 * Each button, when clicked, changes the background color of the corresponding panel.
 * The colors available for each panel are: Green, Red, Blue, Gray, Yellow, and Pink.
 */
package swingActividad01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	// Declare the main frame and three panels
	public static JFrame frame = new JFrame("Color Changer");
	public static JPanel panel = new JPanel();
	public static JPanel panel2 = new JPanel();
	public static JPanel panel3 = new JPanel();

	public static void main(String[] args) {
		// Set up the frame's close operation and disable resizing
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
		// Set the preferred size for the first panel (panel at the top)
		panel.setPreferredSize(new Dimension(400, 50));
		// Add the first panel to the frame in the North region
		frame.add(panel, BorderLayout.NORTH);
		// Add buttons to the first panel, each button will change the background of panel
		panel.add(crearButton(Color.green));
		panel.add(crearButton(Color.red));
		panel.add(crearButton(Color.blue));

		// Set the preferred size for the second panel (panel on the left)
		panel2.setPreferredSize(new Dimension(400, 20));
		// Add the second panel to the frame without a specific position (it defaults to the Center region)
		frame.add(panel2);
		// Add buttons to the second panel
		panel2.add(crearButton2(Color.gray));
		panel2.add(crearButton2(Color.blue));
		panel2.add(crearButton2(Color.pink));

		// Set the preferred size for the third panel (panel at the bottom)
		panel3.setPreferredSize(new Dimension(400, 250));
		// Add the third panel to the frame in the South region
		frame.add(panel3, BorderLayout.SOUTH);
		// Add buttons to the third panel
		panel3.add(crearButton3(Color.gray));
		panel3.add(crearButton3(Color.yellow));
		panel3.add(crearButton3(Color.pink));

		// Make the frame visible and adjust it to fit the components
		frame.setVisible(true);
		frame.pack();
	}

	// Creates a button that changes the background color of panel when clicked
	private static JButton crearButton(Color color) {
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Change the background color of the top panel (panel)
				panel.setBackground(color);
			}
		});
		return button;
	}

	// Creates a button that changes the background color of panel2 when clicked
	private static JButton crearButton2(Color color) {
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Change the background color of the left panel (panel2)
				panel2.setBackground(color);
			}
		});
		return button;
	}

	// Creates a button that changes the background color of panel3 when clicked
	private static JButton crearButton3(Color color) {
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Change the background color of the bottom panel (panel3)
				panel3.setBackground(color);
			}
		});
		return button;
	}
}
