package learningLabels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {
	public static void main(String[] args) {
		ImageIcon img = new ImageIcon("Top-removebg-preview.png");
		Border border = BorderFactory.createLineBorder(Color.RED, 10);
		JLabel label = new JLabel();
		label.setText("i'm in!!");
		label.setIcon(img);
		label.setHorizontalTextPosition(JLabel.CENTER);// positioning text to center
		// ______
		label.setVerticalTextPosition(JLabel.TOP);// positioning text to top VERTICAL
		// ||
		label.setForeground(new Color(0x12356));// color for string types
		label.setFont(new Font("Impact", Font.ITALIC, 90));// for styling font
		label.setIconTextGap(-60);// gap between text and the Icon
		label.setBackground(Color.BLACK);// to change label backgroud color but setopaque is required as true to work
		label.setOpaque(true);
		label.setBorder(border);
		label.setVerticalAlignment(JLabel.CENTER); // moving the whole content to the
		// center
		label.setHorizontalAlignment(JLabel.CENTER);// moving the whole content
		// vertically to the center
		// label.setBounds(200, 200, 400, 400);// x,y,width,height, this will make the
		// content saty in the specific place(fram.setLayout(null) is needed)
		JFrame frame = new JFrame();
		frame.setTitle("Learning Labels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0x123456));
		 //frame.setSize(400, 400);
		// frame.setLayout(null);
		frame.setIconImage(img.getImage());
		frame.setVisible(true);
		frame.add(label);
		frame.pack();// modify the frame size according to the content that it contains so that u dont need

	}
}
