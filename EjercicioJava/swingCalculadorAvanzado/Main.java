package swingCalculadorAvanzado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main {
    static JFrame frame = new JFrame();
    static LineBorder roundedLineBorder = new LineBorder(Color.LIGHT_GRAY, 2, true);

    // Panels for the top, middle, and bottom sections
    static JPanel panel3 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel1 = new JPanel();

    public static void main(String[] args) {
        // Set the frame title, close operation, and size
        frame.setTitle("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // Use absolute positioning for the frame

        // Set the frame size
        frame.setSize(400, 800);

        // Panel 3 (Bottom panel with buttons)
        panel3.setLayout(new GridLayout(6, 3, 2, 2));
        panel3.setPreferredSize(new Dimension(400, 450)); // Set panel3 size
        panel3.setBounds(0, 150, 400, 450);  // Position panel3 at (0, 150)

        // Adding buttons to panel3
        JButton button1 = crearButton2("MC");
        JButton button2 = crearButton2("MR");
        JButton button3 = crearButton2("M+");
        JButton button4 = crearButton2("M-");
        JButton button5 = crearButton2("MS");
        JButton button6 = crearButton("%");
        JButton button7 = crearButton("CE");
        JButton button8 = crearButton("C");
        JButton button9 = crearButton("❌");
        JButton button10 = crearButton("1/x");
        JButton button11 = crearButton("x²");
        JButton button12 = crearButton("√");
        JButton button13 = crearButton("÷");
        JButton button14 = crearButton("7");
        JButton button15 = crearButton("8");
        JButton button16 = crearButton("9");
        JButton button17 = crearButton("x");
        JButton button18 = crearButton("4");
        JButton button19 = crearButton("5");
        JButton button20 = crearButton("6");
        JButton button21 = crearButton("-");
        JButton button22 = crearButton("1");
        JButton button23 = crearButton("2");
        JButton button24 = crearButton("3");
        JButton button25 = crearButton("+");
        JButton button26 = crearButton("+/-");
        JButton button27 = crearButton("0");
        JButton button28 = crearButton(".");
        JButton button29 = crearButton("=");

        panel3.add(button6);
        panel3.add(button7);
        panel3.add(button8);
        panel3.add(button9);
        panel3.add(button10);
        panel3.add(button11);
        panel3.add(button12);
        panel3.add(button13);
        panel3.add(button14);
        panel3.add(button15);
        panel3.add(button16);
        panel3.add(button17);
        panel3.add(button18);
        panel3.add(button19);
        panel3.add(button20);
        panel3.add(button21);
        panel3.add(button22);
        panel3.add(button23);
        panel3.add(button24);
        panel3.add(button25);
        panel3.add(button26);
        panel3.add(button27);
        panel3.add(button28);
        panel3.add(button29);

        // Panel 2 (Middle panel with some buttons)
        panel2.setLayout(new GridLayout(1, 5)); // You can customize the number of buttons or layout
        panel2.setPreferredSize(new Dimension(400, 50)); // Set panel2 size
        panel2.setBounds(0, 100, 400, 50);  // Position panel2 at (0, 100)

        // Adding buttons to panel2
        JButton button1Middle = crearButton2("MC");
        JButton button2Middle = crearButton2("MR");
        JButton button3Middle = crearButton2("M+");
        JButton button4Middle = crearButton2("M-");
        JButton button5Middle = crearButton2("MS");
        panel2.add(button1Middle);
        panel2.add(button2Middle);
        panel2.add(button3Middle);
        panel2.add(button4Middle);
        panel2.add(button5Middle);

        // Panel 1 (Top panel, could be for additional functionality like display)
        panel1.setLayout(new GridLayout(1, 1)); // Change as needed
        panel1.setPreferredSize(new Dimension(400, 300)); // Set panel1 size
        panel1.setBounds(0, 0, 400, 300);  // Position panel1 at (0, 0)

        // Add the panels to the frame
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        // Frame settings
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Center the window
    }

    private static JButton crearButton(String string) {
        JButton button = new JButton(string);
        button.setBackground(Color.white);
        button.setOpaque(true);
        button.setBorder(roundedLineBorder);
        return button;
    }

    private static JButton crearButton2(String string) {
        JButton button = new JButton(string);
        button.setBackground(Color.white);
        button.setOpaque(true);
        button.setBorder(null);
        return button;
    }
}


