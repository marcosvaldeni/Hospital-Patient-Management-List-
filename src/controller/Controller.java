// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package controller;

import java.sql.SQLException;

import linkedlist.LinkedList;
import model.Database;
import model.Patient;
import view.FormEvent;

public class Controller {
	
	Database db = new Database();

	public void starts() throws Exception {
		
		db.connect();
		db.load();
	}
	
	public Patient getPatientPID(int PID) {
		
		int count = 0;
		
		while(db.getPatient(count).getPid() != PID) {		
			count++;
		}
		return db.getPatient(count);
	}
	
	public Patient getPatient(int queue) {
		
		return db.getPatient(queue);
	}
	
	public int findPosition(Patient p) {

		return db.findPosition(p);
	}
	
	public void addPatient(FormEvent ev) {
		
		int n = 0;
		Patient patient = new Patient(ev.getPps(), ev.getFirstName(), ev.getLastName(), ev.getMobileNumber(), ev.getEmail(), ev.getCity());
		
		try {
			db.connect();
			db.insert(patient);
			n = db.lastId();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		patient.setPid(n);
		
		if (ev.isPossiton()) {
			db.addPatient(Integer.parseInt((ev.getQueue()))-1, patient);
		} else {
			db.addPatient(patient);
		}
	}
	
	public void removePatient(int n) {

		try {
			db.remove(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void moveUp(int n) {
		db.moveUp(n);
	}
	
	public void moveDown(int n) {
		db.moveDown(n);
	}
	
	public void moveToFirst(int n) {
		db.moveToFirst(n);
	}
	
	public LinkedList<Patient> getPeople() {
		return db.getPeople();
	}
	
	public void deleteGroup(int n) throws SQLException {
		db.deleteGroup(n);
	}
	
	public void updatePossition(int queue, int newQueue) {
		db.updatePossition(queue, newQueue);
	}
	
	public void update(int queue, int pid, String pps, String fistName, String lastName, String mobileNumber, String email, String city) {
		Patient p = new Patient(pid, pps, fistName, lastName, mobileNumber, email, city);
		db.updatePatient(queue, p);
	}
	
	public void updatePossitionAndPatient(int queue, int newQueue, int pid, String pps, String fistName, String lastName, String mobileNumber, String email, String city) {
		Patient p = new Patient(pid, pps, fistName, lastName, mobileNumber, email, city);
		db.updatePossition(queue, newQueue);
		db.updatePatient(newQueue, p);
	}

}
