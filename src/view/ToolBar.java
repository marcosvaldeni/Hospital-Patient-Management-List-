// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {
	
	private JButton addPatient;
	private JButton editPatient;
	private JButton deleteGroup;
	private JButton search;
	
	private ButtonListener number;

	public ToolBar() {
		setBorder(BorderFactory.createEtchedBorder());
		
		addPatient = new JButton("Add Patient");
		editPatient = new JButton("Edit Patient");
		deleteGroup = new JButton("Delete Group");
		search = new JButton("Search");
		
		addPatient.addActionListener(this);
		editPatient.addActionListener(this);
		deleteGroup.addActionListener(this);
		search.addActionListener(this);
		
		addPatient.setToolTipText("Add New Patient");
		editPatient.setToolTipText("Edit Patient");
		deleteGroup.setToolTipText("Delete Group");
		search.setToolTipText("Search for a New Patient");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(addPatient);
		add(editPatient);
		add(deleteGroup);
		add(search);
	}
	
	public void setNumberListener(ButtonListener listener ) {
		this.number = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == addPatient) {
			
				number.actionButton(1);
				
		}else if(clicked == editPatient) {
			
			number.actionButton(2);
			
		}else if(clicked == deleteGroup) {
			
			number.actionButton(3);
			
		}else if(clicked == search) {
			
			number.actionButton(4);
			
		}

	}


}
