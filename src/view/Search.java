// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controller;
import util.util;

public class Search extends JPanel implements ActionListener {

	private formListener panelListener;
	private SearchListener searchListener;

	private JButton editButton;
	private JButton cancelButton;
	private JButton searchButton;
	private JTextField searchField;
	private JComboBox searchCombo;
	private JLabel pidLabel;
	private JLabel queueLabel;
	private JLabel nameLabel;
	private JLabel ppsLabel;
	private JLabel mobileLabel;
	private JLabel emailLabel;
	private JLabel cityLabel;
	private String msg;

	public Search() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);

		pidLabel = new JLabel();
		queueLabel = new JLabel();
		nameLabel = new JLabel();
		ppsLabel = new JLabel();
		mobileLabel = new JLabel();
		emailLabel = new JLabel();
		cityLabel = new JLabel();
		editButton = new JButton("Edit");
		cancelButton = new JButton("Cancel");
		searchButton = new JButton("Search");
		searchField = new JTextField(10);
		searchCombo = new JComboBox();
		msg = "";

		editButton.addActionListener(this);
		searchButton.addActionListener(this);

		// Set up combo box.
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("PID");
		empModel.addElement("Queue");
		searchCombo.setModel(empModel);
		searchCombo.setSelectedIndex(0);

		layoutControls();

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clearLabels();
			}
		});
	}

	private void layoutControls() {

		JPanel controlsPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		int space = 15;
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorder = BorderFactory.createTitledBorder("Search for a Patient");

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
		controlsPanel.add(new JLabel("Search by: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(searchCombo, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(searchButton, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(searchField, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("PID: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(pidLabel, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("Queue: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(queueLabel, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("Name: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(nameLabel, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("PPS: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(ppsLabel, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("Mobile: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(mobileLabel, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("eMail: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(emailLabel, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("City: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(cityLabel, gc);

		// ////////// Buttons Panel ///////////////

		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(editButton);
		buttonsPanel.add(cancelButton);

		Dimension btnSize = cancelButton.getPreferredSize();
		editButton.setPreferredSize(btnSize);

		// Add sub panels to dialog
		setLayout(new BorderLayout());
		add(controlsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	public void setInfo(String pid, String pps, String firstName, String lastName, String mobileNumber, String email,
			String city, String queue) {

		this.pidLabel.setText(pid);
		this.ppsLabel.setText(pps);
		this.nameLabel.setText(firstName + " " + lastName);
		this.mobileLabel.setText(mobileNumber);
		this.emailLabel.setText(email);
		this.cityLabel.setText(city);
		this.queueLabel.setText(queue);
	}

	public void setAddPanelListener(formListener listener) {
		this.panelListener = listener;
	}

	public void setSearchlListener(SearchListener searchListener) {
		this.searchListener = searchListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		if (clicked == searchButton) {

			if (validFild()) {
				searchListener.actionSearch(Integer.parseInt(searchField.getText()), searchCombo.getSelectedIndex());
			} else {
				
				JOptionPane.showConfirmDialog(this,
						msg, "WARNING!",
						JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}

		}
		if (clicked == editButton) {

			searchListener.actionEdit(Integer.parseInt(queueLabel.getText()));
			clearLabels();
		}
	}
	
	public void clearLabels() {
		msg = "";
		pidLabel.setText(""); 
		queueLabel.setText("");
		nameLabel.setText("");
		ppsLabel.setText("");
		mobileLabel.setText("");
		emailLabel.setText("");
		cityLabel.setText("");
		searchField.setText("");
	}
	
	public boolean validFild() {
		boolean result = true;

		if (result) {
			result = util.validFild(searchField.getText());
			msg = "Field Search is empty, please check it.";
		}
		
		if (result) {
			result = util.checkNumber(searchField.getText());
			msg = "Field Search must be filled ONLY with numbers.";
		}
		
		return result;
	}
}
