// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package view;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import linkedlist.LinkedList;
import model.Patient;

public class TablePanel extends JPanel {

	private formListener addPanelListener;
	private JTable table;
	private PatientTableModel tableModel;
	private JPopupMenu popop;
	private PatientTableListener patientTableListener;
	private TableColumn column;

	public TablePanel() {
		
		column = new TableColumn();
		
		tableModel = new PatientTableModel();
		table = new JTable(tableModel);
		popop = new JPopupMenu();
		
		table.setRowHeight(23);
		for (int i=0; i < 6; i++) {
			  TableColumn column = table.getColumnModel().getColumn(i);
			  if (i==0) column.setPreferredWidth(1);
			  if (i==1) column.setPreferredWidth(1);
			  if (i==2) column.setPreferredWidth(40);
			  if (i==3) column.setPreferredWidth(50);
			  if (i==4) column.setPreferredWidth(120);
			  if (i==5) column.setPreferredWidth(10);
			}
	
		JMenuItem removeItem = new JMenuItem("Remove");
		JMenuItem moveUp = new JMenuItem("Move Up");
		JMenuItem moveDown = new JMenuItem("Move Down");
		JMenuItem moveToFirst = new JMenuItem("Move To First");
		popop.add(removeItem);
		popop.add(moveUp);
		popop.add(moveDown);
		popop.add(moveToFirst);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON3) {
					popop.show(table, e.getX(), e.getY());
				}
			}
			
			public void mouseClicked(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				if(e.getClickCount() == 2) {
					
					FormEvent ev = new FormEvent(this, String.valueOf(row+1));

					if (addPanelListener != null) {
						addPanelListener.addFormOccurred(ev);
					}

				}
			}
		});
		
		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(patientTableListener != null) {
					patientTableListener.rowDeleted(row);
					tableModel.fireTableRowsDeleted(row, row);
				}
			}
		});
		
		moveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(patientTableListener != null) {
					patientTableListener.moveRowUp(row);
					refresh();
				}
			}
		});
		
		moveDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(patientTableListener != null) {
					patientTableListener.moveRowDown(row);
					refresh();
				}
			}
		});
		
		moveToFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(patientTableListener != null) {
					patientTableListener.moveRowToFirst(row);
					refresh();
				}
			}
		});

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(LinkedList<Patient> db) {
		tableModel.setData(db);
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}
	
	public void setPatientTableListener(PatientTableListener listener) {
		this.patientTableListener = listener;
	}
	
	public void setAddPanelListener(formListener listener) {
		this.addPanelListener = listener;
	}
	
}
