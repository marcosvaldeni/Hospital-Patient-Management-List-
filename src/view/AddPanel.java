package view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import util.util;

public class AddPanel extends JPanel{
	
	private formListener panelListener;
	private JTextField PPSnumber;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField mobileNumber;
	private JTextField eMail;
	private JTextField city;
	private JButton okBtn;
	private JCheckBox alterQueuePosition;
	private JLabel queuePositionLabel;
	private JTextField queuePosition;
	private String msg;
	
	public AddPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		
		PPSnumber = new JTextField(10);
		firstName = new JTextField(10);
		lastName = new JTextField(10);
		mobileNumber = new JTextField(10);
		eMail = new JTextField(10);
		city = new JTextField(10);
		alterQueuePosition = new JCheckBox();
		queuePosition = new JTextField(10);
		queuePositionLabel = new JLabel("Queue Position: ");
		
		// Set up Queue Position
		queuePosition.setEnabled(false);
		queuePositionLabel.setEnabled(false);
		
		alterQueuePosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queuePositionLabel.setEnabled(alterQueuePosition.isSelected());
				queuePosition.setEnabled(alterQueuePosition.isSelected());
			}
		});
		
		okBtn = new JButton("OK");
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (validFild()) {
					
					FormEvent ev = new FormEvent(this,
							PPSnumber.getText(), 
							firstName.getText(), 
							lastName.getText(), 
							mobileNumber.getText(), 
							eMail.getText(), 
							city.getText(), 
							queuePosition.getText(), 
							alterQueuePosition.isSelected());

					if (panelListener != null) {
						panelListener.addFormOccurred(ev);
					}
					
					PPSnumber.setText("");
					firstName.setText("");
					lastName.setText("");
					mobileNumber.setText("");
					eMail.setText("");
					city.setText("");
					queuePosition.setText("");
					
				} else {
					
					JOptionPane.showConfirmDialog(AddPanel.this,
							msg, "WARNING!",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
					
				}

			}
		});
		
		Border innerBonner = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBonner));

		layoutComponets();

	}
	
	public void layoutComponets() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		///////////////////////////// Next row ////////////////////////////////
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Position: "), gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(alterQueuePosition, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(queuePositionLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(queuePosition, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Fist Name: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(firstName, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Last Name: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(lastName, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("PPS Number: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(PPSnumber, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Mobile Number: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(mobileNumber, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("e-Mail "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(eMail, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("City: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(city, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);
	}
	
	public void setAddPanelListener(formListener listener) {
		this.panelListener = listener;
	}
	
	public boolean validFild() {
		boolean result = true;

		if (result) {
			result = util.validFild(firstName.getText());
			msg = "First Name is empty, please check it.";
		}
		
		if (result) {
			result = util.validFild(lastName.getText());
			msg = "Last Name is empty, please check it.";
		}
		
		if (result) {
			result = util.validFild(PPSnumber.getText());
			msg = "PPS is empty, please check it.";
		}
		
		if (result) {
			result = util.validFild(mobileNumber.getText());
			msg = "Mobile Number is empty, please check it.";
		}
		
		if (result) {
			result = util.validFild(eMail.getText());
			msg = "eMail is empty, please check it.";
		}
		
		if (result) {
			result = util.validFild(city.getText());
			msg = "City is empty, please check it.";
		}
		
		if (alterQueuePosition.isSelected()) {
			
			if (result) {
				result = util.checkNumber(queuePosition.getText());
				msg = "Field Queue Possition must be filled ONLY with numbers.";
			}
			
			if (result) {
				result = util.validFild(queuePosition.getText());
				msg = "Queue Possition is empty, please check it.";
			}
		}
		
		return result;
	}
}