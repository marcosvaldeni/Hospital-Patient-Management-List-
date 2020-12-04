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

import linkedlist.LinkedList;
import util.util;

public class EditPanel extends JPanel{
	
	private formListener addPanelListener;
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
	private JLabel pidLabel;
	private LinkedList<String> patient;
	private String oldQueue;
	private String msg;
	
	public EditPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);

		patient = new LinkedList<>();
		PPSnumber = new JTextField(10);
		firstName = new JTextField(10);
		lastName = new JTextField(10);
		mobileNumber = new JTextField(10);
		eMail = new JTextField(10);
		city = new JTextField(10);
		alterQueuePosition = new JCheckBox();
		queuePosition = new JTextField(10);
		queuePositionLabel = new JLabel("Queue Position: ");
		pidLabel = new JLabel();
		
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
				
				if (checkEmpty()) {
					
					if (position() && wasEdited()) {
						
						FormEvent ev = new FormEvent(this, Integer.parseInt(pidLabel.getText()), PPSnumber.getText(), firstName.getText(), lastName.getText(), mobileNumber.getText(), eMail.getText(), city.getText(), oldQueue, queuePosition.getText(), alterQueuePosition.isSelected(), true);

						if (addPanelListener != null) {
							addPanelListener.addFormOccurred(ev);
						}						
						
					} else if(wasEdited()) {
						
						FormEvent ev = new FormEvent(this, Integer.parseInt(pidLabel.getText()) ,PPSnumber.getText(), firstName.getText(), lastName.getText(), mobileNumber.getText(), eMail.getText(), city.getText(), oldQueue, queuePosition.getText(), alterQueuePosition.isSelected(), true);

						if (addPanelListener != null) {
							addPanelListener.addFormOccurred(ev);
						}
						
					} else if (position()) {
						
						FormEvent ev = new FormEvent(this, oldQueue, queuePosition.getText(), alterQueuePosition.isSelected(), false);

						if (addPanelListener != null) {
							addPanelListener.addFormOccurred(ev);
						}
					}
					clearFilds();
					
				} else {
					JOptionPane.showConfirmDialog(EditPanel.this,
							msg, "WARNING!",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		Border innerBonner = BorderFactory.createTitledBorder("Edit Patient");
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
		add(new JLabel("PID: "), gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(pidLabel, gc);
		
		///////////////////////////// Next row ////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Position: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
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
		add(new JLabel("Fist Name: : "), gc);
		
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
		add(new JLabel("Last Name: : "), gc);
		
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
		add(new JLabel("eMail:  "), gc);
		
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
	
	public void setInfo(String pid, String pps, String firstName, String lastName, String mobileNumber, String email, String city, String queue) {
		patient.clearAll();
		
		this.pidLabel.setText(pid);
		this.PPSnumber.setText(pps);
		patient.add(pps);
		this.firstName.setText(firstName);
		patient.add(firstName);
		this.lastName.setText(lastName);
		patient.add(lastName);
		this.mobileNumber.setText(mobileNumber);
		patient.add(mobileNumber);
		this.eMail.setText(email);
		patient.add(email);
		this.city.setText(city);
		patient.add(city);
		this.queuePosition.setText(queue);
		patient.add(queue);
		oldQueue = queue;
	}
		
	public boolean wasEdited() {
		boolean result = true;
		
		if (result) {
			result = util.equals(patient.get(0), PPSnumber.getText());
		}
		
		if (result) {
			result = util.equals(patient.get(1), firstName.getText());
		}
		
		if (result) {
			result = util.equals(patient.get(2), lastName.getText());
		}
		
		if (result) {
			result = util.equals(patient.get(3), mobileNumber.getText());
		}
		
		if (result) {
			result = util.equals(patient.get(4), eMail.getText());
		}
		
		if (result) {
			result = util.equals(patient.get(5), city.getText());
		}		
		
		return !result;
	}
	
	public boolean checkEmpty() {
		boolean result = true;
		
		if (result) {
			result = util.checkSpaces(PPSnumber.getText());
			msg = "PPS is empty, please check it.";
		}
		
		if (result) {
			result = util.checkSpaces(firstName.getText());
			msg = "First Name is empty, please check it.";
		}
		
		if (result) {
			result = util.checkSpaces(lastName.getText());
			msg = "Last Name is empty, please check it.";
		}
		
		if (result) {
			result = util.checkSpaces(mobileNumber.getText());
			msg = "Mobile Number is empty, please check it.";
		}
		
		if (result) {
			result = util.checkSpaces(eMail.getText());
			msg = "eMail is empty, please check it.";
		}
		
		if (result) {
			result = util.checkSpaces(city.getText());
			msg = "City is empty, please check it.";
		}
		
		if (result) {
			result = util.checkSpaces(queuePosition.getText());
			msg = "Queue Possition is empty, please check it.";
		}
		
		if (result) {
			result = util.checkNumber(queuePosition.getText());
			msg = "Field Queue Possition must be filled ONLY with numbers.";
		}
		
		return result;
	}
	
	public void setAddPanelListener(formListener listener) {
		this.addPanelListener = listener;
	}
	
	public void clearFilds() {
		pidLabel.setText("");
		PPSnumber.setText("");
		firstName.setText("");
		lastName.setText("");
		mobileNumber.setText("");
		eMail.setText("");
		city.setText("");
		queuePosition.setText("");
		alterQueuePosition.setSelected(false);
		queuePosition.setEnabled(false);
		oldQueue ="";
	}
	
	public boolean position() {
		boolean result = true;
		
		if (result) {
			result = util.equals(patient.get(6), queuePosition.getText());
		}
		
		return !result;
	}
	
	public boolean positionFields() {
		
		return false;
	}
	
	public boolean positionFieldsQueue() {
		return false;
	}
}