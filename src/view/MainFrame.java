// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package view;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;

public class MainFrame extends JFrame {

	private AddPanel addPanel;
	private EditPanel editPanel;
	private ToolBar toolbar;
	private Controller controller;
	private TablePanel tablePanel;
	private DeleteNumberD deleteGroup;
	private Search search;

	public MainFrame() {
		super("Hospital Patient Management List");

		setLayout(new BorderLayout());

		addPanel = new AddPanel();
		editPanel = new EditPanel();
		toolbar = new ToolBar();
		tablePanel = new TablePanel();
		controller = new Controller();
		deleteGroup = new DeleteNumberD(this);
		search = new Search();

		editPanel.setVisible(false);

		try {
			controller.starts();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(MainFrame.this, "Cannot connect to database", "Database Error",
					JOptionPane.ERROR_MESSAGE);
		}

		tablePanel.setData(controller.getPeople());
		
		deleteGroup.setGroupListener(new GroupListener() {
			public void groupSet(int n) {
				
				try {
					controller.deleteGroup(n);
					tablePanel.refresh();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(MainFrame.this, "Number to be deleted is too big!", "Database Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		search.setSearchlListener(new SearchListener() {
			public void actionSearch(int n, int type) {
				
				if (type == 1) {
					
					try {
						n--;
						search.setInfo(String.valueOf(controller.getPatient(n).getPid()),
								controller.getPatient(n).getPps(), controller.getPatient(n).getFirstName(),
								controller.getPatient(n).getLastName(), controller.getPatient(n).getMobileNumber(),
								controller.getPatient(n).getEmail(), controller.getPatient(n).getCity(), String.valueOf(n+1));
					} catch (Exception e) {
						System.out.println(e);
					}
					
					
				} else if(type == 0) {
					
					try {
						
						int queue = 0;
						for (int i = 0; i < 8; i++) {
							if (controller.getPatient(i).getPid() == n) {
								queue = controller.findPosition(controller.getPatient(i))+1;
							}
						}
						
						search.setInfo(String.valueOf(
								controller.getPatientPID(n).getPid()),
								controller.getPatientPID(n).getPps(), 
								controller.getPatientPID(n).getFirstName(),
								controller.getPatientPID(n).getLastName(), 
								controller.getPatientPID(n).getMobileNumber(),
								controller.getPatientPID(n).getEmail(), 
								controller.getPatientPID(n).getCity(), 
								String.valueOf(queue));
						
					} catch (Exception e) {
						System.out.println(e);
					}

				}
			}

			public void actionEdit(int queue) {
				
				add(editPanel, BorderLayout.WEST);
				addPanel.setVisible(false);
				search.setVisible(false);
				editPanel.setVisible(true);
				
				queue--;
				editPanel.setInfo(String.valueOf(controller.getPatient(queue).getPid()),
						controller.getPatient(queue).getPps(), controller.getPatient(queue).getFirstName(),
						controller.getPatient(queue).getLastName(), controller.getPatient(queue).getMobileNumber(),
						controller.getPatient(queue).getEmail(), controller.getPatient(queue).getCity(),
						String.valueOf(queue+1));
				
			}
		});

		addPanel.setAddPanelListener(new formListener() {
			public void addFormOccurred(FormEvent e) {
				System.out.println(e.getQueue());
				controller.addPatient(e);
				tablePanel.refresh();
			}
		});

		tablePanel.setAddPanelListener(new formListener() {
			public void addFormOccurred(FormEvent e) {
				int queue = Integer.parseInt(e.getQueue()) - 1;

				addPanel.setVisible(false);
				search.setVisible(false);
				editPanel.setVisible(true);
				add(editPanel, BorderLayout.WEST);

				editPanel.setInfo(String.valueOf(controller.getPatient(queue).getPid()),
						controller.getPatient(queue).getPps(), controller.getPatient(queue).getFirstName(),
						controller.getPatient(queue).getLastName(), controller.getPatient(queue).getMobileNumber(),
						controller.getPatient(queue).getEmail(), controller.getPatient(queue).getCity(), e.getQueue());

			}
		});

		tablePanel.setPatientTableListener(new PatientTableListener() {
			public void rowDeleted(int row) {
				controller.removePatient(row);
			}

			public void moveRowUp(int row) {
				controller.moveUp(row);
			}

			public void moveRowDown(int row) {
				controller.moveDown(row);
			}

			public void moveRowToFirst(int row) {
				controller.moveToFirst(row);
			}
		});

		toolbar.setNumberListener(new ButtonListener() {
			public void actionButton(int n) {

				switch (n) {
				case 1:
					add(addPanel, BorderLayout.WEST);
					editPanel.setVisible(false);
					search.setVisible(false);
					addPanel.setVisible(true);
					break;

				case 2:
					add(editPanel, BorderLayout.WEST);
					editPanel.setVisible(true);
					addPanel.setVisible(false);
					search.setVisible(false);
					break;

				case 3:
					deleteGroup.setVisible(true);
					break;

				case 4:
					editPanel.setVisible(false);
					addPanel.setVisible(false);
					add(search, BorderLayout.WEST);
					search.setVisible(true);
					break;
				}
			}
		});

		editPanel.setAddPanelListener(new formListener() {
			public void addFormOccurred(FormEvent e) {
				
				try {
					
					if (e.isData() == true && e.isPossiton() == true) {
						
						controller.updatePossitionAndPatient(Integer.parseInt(e.getQueue())-1, Integer.parseInt(e.getNewQueue())-1, e.getPid(), e.getPps(), e.getFirstName(), e.getLastName(), e.getMobileNumber(), e.getEmail(), e.getCity());
						
					} else if(e.isData() == true && e.isPossiton() == false) {

						controller.update(Integer.parseInt(e.getQueue())-1, e.getPid(), e.getPps(), e.getFirstName(), e.getLastName(), e.getMobileNumber(), e.getEmail(), e.getCity());
						
					} else if(e.isData() == false && e.isPossiton() == true) {
						
						controller.updatePossition(Integer.parseInt(e.getQueue())-1, Integer.parseInt(e.getNewQueue())-1);
					}
					tablePanel.refresh();
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(MainFrame.this, "Position at queue does not exist", "Queue Error",
							JOptionPane.ERROR_MESSAGE);
				}


			}
		});

		add(addPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);

		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public int getButtonN(int n) {
		return n;
	}

}
