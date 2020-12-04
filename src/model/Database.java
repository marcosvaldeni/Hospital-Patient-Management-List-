// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import linkedlist.LinkedList;

public class Database {

	private LinkedList<Patient> people;

	private Connection con;

	public Database() {
		people = new LinkedList<Patient>();
	}
	
	public Patient getPatient(int queue) {
		return people.get(queue);
	}
	
	public int findPosition(Patient p) {
		return people.findPosition(p);
	}

	public void addPatient(Patient patient) {
		people.add(patient);
	}
	
	public void addPatient(int index, Patient patient) {
		people.add(index, patient);
	}

	public LinkedList<Patient> getPeople() {
		return people;
	}
	
	public void moveUp(int n) {
		people.moveUp(people.get(n));
	}
	
	public void moveDown(int n) {
		people.moveDown(people.get(n));
	}
	
	public void moveToFirst(int n) {
		people.moveToFirst(people.get(n));
	}

	public void connect() throws Exception {
		
		if (con != null)
			return;

		try {
			String url = "jdbc:mysql://35.196.34.183:3306/hospital";
			con = DriverManager.getConnection(url, "marcos", "12345678");
		} catch (SQLException ex) {
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			throw new Exception("Error SQL");
		}
	}

	public void disconnect() {
		
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Can't close connection");
			}
			con = null;
		}
	}
	
	public void update(int pid, Patient patient) throws SQLException {

		String insertSql = "update Patient set patient_pps = ?, patient_fname = ?, patient_lname = ?, patient_mobileNumber = ?, patient_email = ?, patient_city = ? WHERE patient_pid = ?";
		PreparedStatement insertStatement = con.prepareStatement(insertSql);
		
		insertStatement.setString(1, patient.getPps());
		insertStatement.setString(2, patient.getFirstName());
		insertStatement.setString(3, patient.getLastName());
		insertStatement.setString(4, patient.getMobileNumber());
		insertStatement.setString(5, patient.getEmail());
		insertStatement.setString(6, patient.getCity());
		insertStatement.setInt(7, pid);

		insertStatement.executeUpdate();
		
		insertStatement.close();
	}
	
	public void delete(int n) throws SQLException {
		
		int pid = people.get(n).getPid();

		String insertSql = "delete from Patient where patient_pid = ?;";
		PreparedStatement insertStatement = con.prepareStatement(insertSql);
		
		insertStatement.setInt(1, pid);
		
		insertStatement.executeUpdate();
		insertStatement.close();
	}
	
	public void remove(int n) throws SQLException {
		
		delete(n);
		people.remove(n);
	}
	
	public void insert(Patient patient) throws SQLException {

		String insertSql = "insert into Patient (patient_pps, patient_fname, patient_lname, patient_mobileNumber, patient_email, patient_city) values (?, ?, ?, ?, ?, ?);";
		PreparedStatement insertStatement = con.prepareStatement(insertSql);
		
		insertStatement.setString(1, patient.getPps());
		insertStatement.setString(2, patient.getFirstName());
		insertStatement.setString(3, patient.getLastName());
		insertStatement.setString(4, patient.getMobileNumber());
		insertStatement.setString(5, patient.getEmail());
		insertStatement.setString(6, patient.getCity());

		insertStatement.executeUpdate();
		insertStatement.close();
	}
	
	public void load() throws SQLException {

		String sql = "SELECT * FROM Patient;";
		Statement selectStatement = con.createStatement();
		
		ResultSet results = selectStatement.executeQuery(sql);
		
		while(results.next()) {
			Patient patient = new Patient(
					results.getInt("patient_pid"),
					results.getString("patient_pps"),
					results.getString("patient_fname"), 
					results.getString("patient_lname"),
					results.getString("patient_mobileNumber"), 
					results.getString("patient_email"),
					results.getString("patient_city"));
			addPatient(patient);
		}
		
		results.close();
		selectStatement.close();
	}
	
	public int lastId() throws SQLException {
		
		int n = 0;
		String sql = "SELECT patient_pid FROM Patient ORDER BY patient_pid DESC LIMIT 1;";
		Statement selectStatement = con.createStatement();
		
		ResultSet results = selectStatement.executeQuery(sql);
		
		if (results.next()) {
			n = results.getInt("patient_pid");
		}
		
		results.close();
		selectStatement.close();
		
		return n;
	}
	
	public void deleteGroup(int n) throws SQLException {

		for (int i = 0; i < n; i++) {
			int queue = people.size() - 1;
			delete(queue - i);
		}
		people.deleteGroup(n);
	}
	
	public void updatePossition(int queue, int newQueue) {
		
		Patient p = people.get(queue);
		people.remove(queue);
		people.add(newQueue, p);
	}
	
	public void updatePatient(int queue, Patient p) {
		
		people.update(queue, p);
		try {
			update(p.getPid(), p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
