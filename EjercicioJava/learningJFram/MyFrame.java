package learningJFram;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {
		this.setTitle("Learning");// we give it titlt overirding its default title value
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// normally even we press close icon it wont shut down on
		this.setResizable(false);// we cannot resize it!!
		this.setSize(800, 800);// we give it a x-dimension and y-dimenasion size
		ImageIcon img = new ImageIcon("C:\\Users\\sugam\\Desktop\\Images\\Top-removebg-preview.png");
		this.setIconImage(img.getImage());
		this.setVisible(true);// until and unless i use this line i wont be able to see the screen
								// itself so i nee to set a default to exit on close but on
		this.getContentPane().setBackground(Color.cyan);
		// the typr not the name
	}
}
