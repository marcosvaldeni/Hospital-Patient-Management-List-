// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

import javax.swing.SwingUtilities;

import view.MainFrame;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
		
	}

}