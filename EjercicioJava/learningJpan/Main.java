package learningJpan;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		//JOptionPane.showMessageDialog(null, "hello my name is sugam", "Page-1", JOptionPane.PLAIN_MESSAGE);
		//JOptionPane.showMessageDialog(null, "He is still learning", "Page-1", JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Welcome to the program!! ¿How are you feeling today?", "Page-1",
			//	JOptionPane.QUESTION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "HE MIGHT NOT BE READY", "Page-1", JOptionPane.WARNING_MESSAGE);
		//JOptionPane.showMessageDialog(null, "User not found", "Page-1", JOptionPane.ERROR_MESSAGE);
		int num=JOptionPane.showConfirmDialog	(null, "are u robot", "Question", JOptionPane.YES_NO_CANCEL_OPTION);
if(num==1) {
	System.out.println("Eres un puto para no sectionar");
}else {
	System.out.println("Macho!!");
}
	}
}
