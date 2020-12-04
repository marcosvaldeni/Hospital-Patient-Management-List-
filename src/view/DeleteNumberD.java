package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import util.util;

public class DeleteNumberD extends JDialog {

	private JButton okButton;
	private JButton cancelButton;
	private JTextField number;
	private String msg;

	private GroupListener groupListener;

	public DeleteNumberD(JFrame parent) {
		super(parent, "Delete Group", false);

		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		number = new JTextField(10);

		layoutControls();

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(checkEmpty()) {
					
					int n = Integer.parseInt(number.getText());

					if (groupListener != null) {
						groupListener.groupSet(n);
					}

					setVisible(false);
				} else {
					
					JOptionPane.showConfirmDialog(DeleteNumberD.this,
							msg, "WARNING!",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				}
				
				

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		setSize(450, 230);
		setLocationRelativeTo(parent);
	}

	private void layoutControls() {
		
		JPanel controlsPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		
		int space = 15;
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorder = BorderFactory.createTitledBorder("This tool will delete a number of Patient at the end of the list");
		
		controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		
		controlsPanel.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridy = 0;
		
		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);

		// ///// First row /////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("Number of Patient: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(number, gc);

		// ////////// Buttons Panel ///////////////

		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(okButton);
		buttonsPanel.add(cancelButton);
		
		Dimension btnSize = cancelButton.getPreferredSize();
		okButton.setPreferredSize(btnSize);
		
		// Add sub panels to dialog
		setLayout(new BorderLayout());
		add(controlsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}


	public void setGroupListener(GroupListener groupListener) {
		this.groupListener = groupListener;

	}
	
	public boolean checkEmpty() {
		boolean result = true;
		
		if (result) {
			result = util.checkSpaces(number.getText());
			msg = "Number of Patient is empty, please check it.";
		}
		
		
		if (result) {
			result = util.checkNumber(number.getText());
			msg = "Field Number of Patient must be filled ONLY with numbers.";
		}
		
		return result;
	}
}
