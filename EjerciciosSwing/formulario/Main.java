import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Main {
	public static JFrame frame = new JFrame("FORMULARIO");
	public static Border border = BorderFactory.createLineBorder(Color.BLACK, 3, true);

	public static void main(String[] args) {
		// quiero 9 row y solo 1 columno que tenga un espacio vertical 2 y horizontal 2
		frame.setLayout(new GridLayout(9, 1, 2, 2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		// panel 1 = Nombre
		JPanel panelNombre = crearPanel();
		JTextField inputNombre = crearInput();
		JLabel labelNombre = crearLabel("Nombre");
		panelNombre.add(labelNombre, BorderLayout.WEST);
		panelNombre.add(inputNombre);

		// panel 2 = Apellido
		JPanel panelApellido = crearPanel();
		JTextField inputApellidos = crearInput();
		JLabel labelApellidos = crearLabel("Apellido");
		panelApellido.add(labelApellidos, BorderLayout.WEST);
		panelApellido.add(inputApellidos);

		// panel 3 = Genero
		JPanel panelGenero = crearPanel();
		JPanel subPanel = new JPanel();
		// Como no quiero que se rompa la estructura, vamos a crear otro panel.
		// Los contenidos ocuparán el mismo espacio que los demás paneles y se verá
		// bien.
		// Si no usamos un panel separado, lo que pasará es que la etiqueta intentará
		// ajustarse
		// al tamaño de los checkboxes, y eso se verá feo.

		subPanel.setBorder(border);
		subPanel.setLayout(new FlowLayout());
		JLabel labelGenero = crearLabel("Genéro");
		panelGenero.add(labelGenero, BorderLayout.WEST);
		JCheckBox musculino = new JCheckBox("Masculino");
		JCheckBox feminino = new JCheckBox("Femenino");
		JCheckBox noContestar = new JCheckBox("No contestar");
		subPanel.add(musculino);
		subPanel.add(feminino);
		subPanel.add(noContestar);
		panelGenero.add(subPanel);

		// panel 4 = Usuario
		JPanel panelUsuario = crearPanel();
		JTextField inputUsuario = crearInput();
		JLabel labelUsuario = crearLabel("Usuario");
		panelUsuario.add(labelUsuario, BorderLayout.WEST);
		panelUsuario.add(inputUsuario);

		// panel 5 = Contraseña
		JPanel panelContraseña = crearPanel();
		JLabel labelContrasenia = crearLabel("Contraseña");
		panelContraseña.add(labelContrasenia, BorderLayout.WEST);
		JPasswordField contrasenia = new JPasswordField();
		contrasenia.setBorder(border);
		panelContraseña.add(contrasenia);

		// panel 6 = Telefono
		JPanel panelTelefono = crearPanel();
		JTextField inputTelefono = crearInput();
		JLabel labelTelefono = crearLabel("Telefono");
		panelTelefono.add(labelTelefono, BorderLayout.WEST);
		panelTelefono.add(inputTelefono);

		// panel 7 = Destino
		JPanel panelDestino = crearPanel();
		JLabel labelDestino = crearLabel("Destino");
		panelDestino.add(labelDestino, BorderLayout.WEST);
		String destino[] = { "Elija su destino", "España", "Francia", "Japón", "Brasil", "Canadá", "Alemania", "Italia",
				"Argentina", "México", "India" };
		JComboBox<String> inputDestino = new JComboBox<>(destino);
		panelDestino.add(inputDestino);

		// panel 8 = Vacuna
		JPanel panelVacuna = crearPanel();
		JLabel labelVacuna = crearLabel("Vacuna");
		panelVacuna.add(labelVacuna, BorderLayout.WEST);
		JPanel subPanelVacuna = new JPanel();
		subPanelVacuna.setBorder(border);
		subPanelVacuna.setLayout(new FlowLayout());
		JCheckBox vacuna1 = new JCheckBox("Covid-19");
		JCheckBox vacuna2 = new JCheckBox("Maleria");
		JCheckBox vacuna3 = new JCheckBox("Common-Flu");
		subPanelVacuna.add(vacuna1);
		subPanelVacuna.add(vacuna2);
		subPanelVacuna.add(vacuna3);
		panelVacuna.add(subPanelVacuna);

		// panel 9 = btn enviar,oscuro y btn borrar
		JPanel panelBtns = new JPanel();
		panelBtns.setLayout(new FlowLayout());
		JCheckBox cbOscuro = new JCheckBox("Oscuro");
		JButton btnEnviar = new JButton("ENVIAR");
		JButton btnBorrar = new JButton("BORRAR");
		panelBtns.add(cbOscuro);
		panelBtns.add(btnEnviar);
		panelBtns.add(btnBorrar);

		// vamos a ,odificar los funciones de cada botones usando actionListener

		// btn Borar
		btnBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputNombre.setText("");
				inputApellidos.setText("");
				musculino.setSelected(false);
				feminino.setSelected(false);
				noContestar.setSelected(false);
				inputUsuario.setText("");
				contrasenia.setText("");
				inputTelefono.setText("");
				inputDestino.setSelectedIndex(0);
				vacuna1.setSelected(false);
				vacuna2.setSelected(false);
				vacuna3.setSelected(false);

			}
		});
		// en este actionlister controlamos los cosas invalidos empiezando con
		// nombre: que no puede container numeros
		// apellidos tambien sin numero y un espacio para denominar que son dos palabras
		// telefono: que no puede ser numero
		// vacunas: que sean al menos 3
		btnEnviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (inputNombre.getText().equals("") || inputUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ERROR: Nombre y Usuario no puede estar Vacio!!", "Error",
							JOptionPane.ERROR_MESSAGE);

					return;
				}

				if (!inputNombre.getText().matches("[A-Za-z]+")) {
					JOptionPane.showMessageDialog(null, "ERROR: Nombre Inválido!!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!inputApellidos.getText().matches("[A-Za-z]+\\s[A-Za-z]+")) {
					JOptionPane.showMessageDialog(null, "ERROR: Apellido Inválido!!", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if ((musculino.isSelected() && feminino.isSelected() && noContestar.isSelected())
						|| (musculino.isSelected() && feminino.isSelected())
						|| (musculino.isSelected() && noContestar.isSelected())
						|| (noContestar.isSelected() && musculino.isSelected())
						|| (feminino.isSelected() && noContestar.isSelected())) {
					JOptionPane.showMessageDialog(null, "ERROR: Inválido Género!!", "Error", JOptionPane.ERROR_MESSAGE);
					return;

				}
				if (!inputTelefono.getText().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Inválido Telefono introduce al menos 9 numeros!!\ni.e. Numero valido: 123456789",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;

				}
				if (inputDestino.getSelectedIndex() == 0) {
				    JOptionPane.showMessageDialog(null, "ERROR: Debes seleccionar un destino.");
				    return;
				}


				if (!(vacuna1.isSelected() && vacuna2.isSelected() && vacuna3.isSelected())) {
					JOptionPane.showMessageDialog(null, "ERROR: Necesitas al menos 3 vacunas!!", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}
				frame.setVisible(false);

				JOptionPane.showMessageDialog(null,
						"Nombre: " + inputNombre.getText() + "\nAppelido: " + inputApellidos.getText() + "\nGenéro: "
								+ (musculino.isSelected() ? "Musculino"
										: (feminino.isSelected() ? "Feminino" : "otros"))
								+ "\nUsuario: " + inputUsuario.getText() + "\nContraseña: "
								+ new String(contrasenia.getPassword()) + "\nTelefono: " + inputTelefono.getText()
								+ "\nDestino: " + inputDestino.getSelectedItem() + "\nVacuna: "
								+ (vacuna1.isSelected() ? "Covid-19, " : "") + (vacuna2.isSelected() ? "Maleria, " : "")
								+ (vacuna3.isSelected() ? "Common-flu" : ""),
						"Info", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		cbOscuro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Color bgcolor = cbOscuro.isSelected() ? (Color.gray) : (Color.white);
				Color textocolor = cbOscuro.isSelected() ? (Color.white) : (Color.blue);

				// color frame
				frame.getContentPane().setBackground(bgcolor);

				// color contenidos de nombre Panel
				inputNombre.setBackground(bgcolor);
				cambiarColor(labelNombre, bgcolor, textocolor);

				// color contenidos apellidos panel
				inputApellidos.setBackground(bgcolor);
				cambiarColor(labelApellidos, bgcolor, textocolor);

				// color contenidos de panel Genero
				subPanel.setBackground(bgcolor);
				cambiarColor(labelGenero, bgcolor, textocolor);

				// color contenidos de panel Usuario
				inputUsuario.setBackground(bgcolor);
				cambiarColor(labelUsuario, bgcolor, textocolor);

				// color contenidos de panel Contraseña
				contrasenia.setBackground(bgcolor);
				cambiarColor(labelContrasenia, bgcolor, textocolor);

				// color contenidos de telefonon panel
				inputTelefono.setBackground(bgcolor);
				cambiarColor(labelTelefono, bgcolor, textocolor);

				// color contenidos destino
				cambiarColor(labelDestino, bgcolor, textocolor);

				// color vacuna

				subPanelVacuna.setBackground(bgcolor);
				cambiarColor(labelVacuna, bgcolor, textocolor);

				// ultimo label
				panelBtns.setBackground(bgcolor);

			}
		});

		frame.add(panelNombre);
		frame.add(panelApellido);
		frame.add(panelGenero);
		frame.add(panelUsuario);
		frame.add(panelContraseña);
		frame.add(panelTelefono);
		frame.add(panelDestino);
		frame.add(panelVacuna);
		frame.add(panelBtns);
		frame.setVisible(true);
		// no hemos dado ningun tamaño a nuestro frame pero si que tengo dado tamaño a
		// cada panel y quiero que mi tamañao de frame se adjusta directamente con la
		// tamaños de panel por eso usamos.pack()
		frame.pack();//

	}

	// creamos un metodo para crear Panel ya que necesitamos crear panel varios
	// veces
	private static JPanel crearPanel() {
		JPanel panel = new JPanel();
		// quiero que los contenidos tengan un espacios vertical de 2 y horizontal de 2
		panel.setLayout(new BorderLayout(2, 2));
		panel.setPreferredSize(new Dimension(450, 50));
		panel.setBorder(border);
		return panel;
	}

	// creamos un metodo para crear Label por que vamos a crear label varios veces
	private static JLabel crearLabel(String name) {
		JLabel label = new JLabel(name);
		label.setForeground(Color.blue);
		label.setPreferredSize(new Dimension(150, 30));
		label.setBorder(border);
		return label;
	}

	// creamos un metodo para crear text field por que vamos a crear textField
	// varios veces
	private static JTextField crearInput() {
		JTextField textField = new JTextField();
		textField.setForeground(Color.black);
		textField.setBorder(border);

		return textField;
	}

	// para modificar color de background in label
	private static void cambiarColor(JLabel label, Color color, Color color2) {
		label.setBackground(color);
		label.setOpaque(true);
		label.setForeground(color2);
	}
}