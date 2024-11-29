package starting;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.ContainersPanel;

public class StartProgram {

	public static void main(String[] args) {
		//Creating and Setting up the JFrame
		JFrame frame = new JFrame();
		JPanel panel = new ContainersPanel();
		frame.add(panel);

		frame.setSize(500, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
