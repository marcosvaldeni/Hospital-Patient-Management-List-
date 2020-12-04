// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package view;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {

	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}
}
