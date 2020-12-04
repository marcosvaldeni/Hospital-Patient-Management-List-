// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package model;

public class Patient {
	
	private int pid;
	private String pps;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String city;
	
	public Patient() {
	}

	public Patient(int pid, String pps, String firstName, String lastName, String mobileNumber, String email, String city) {
		this.pid = pid;
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.city = city;
	}
	
	public Patient(String pps, String firstName, String lastName, String mobileNumber, String email, String city) {
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.city = city;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPps() {
		return pps;
	}

	public void setPps(String pps) {
		this.pps = pps;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
