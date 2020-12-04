// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package view;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

import linkedlist.LinkedList;
import model.Patient;

public class PatientTableModel extends AbstractTableModel{
	
	private LinkedList<Patient> db;
	
	private String[] colNames = {"Queue","PID", " Name", "Phone", "Email", "City"};
	
	public PatientTableModel() {
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	public void setData(LinkedList<Patient> db) {
		this.db = db; 
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Patient patient = db.get(row);
		
		switch(col) {
		case 0:
			return row+1;
		case 1:
			return patient.getPid();
		case 2:
			return db.get(row).getFirstName()+" "+db.get(row).getLastName();
		case 3:
			return patient.getMobileNumber();
		case 4:
			return patient.getEmail();
		case 5:
			return patient.getCity();
		}
		
		return null;
	}

}
