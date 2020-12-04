// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package view;

import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private int pid;
	private String pps;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String city;
	private String queue;
	private String newQueue;
	private boolean possiton;
	private boolean data;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String queue) {
		super(source);
		this.queue = queue;
	}
	
	public FormEvent(Object source, String queue, String newQueue, boolean possiton, boolean data) {
		super(source);
		this.queue = queue;
		this.newQueue = newQueue;
		this.possiton = possiton;
		this.data = data;
	}

	public FormEvent(Object source, String pps, String firstName, String lastName, String mobileNumber, String email,
			String city, String queue, boolean possiton) {
		super(source);
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.city = city;
		this.queue = queue;
		this.possiton = possiton;
	}

	public FormEvent(Object source, int pid, String pps, String firstName, String lastName, String mobileNumber,
			String email, String city, String queue) {
		super(source);
		this.pid = pid;
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.city = city;
		this.queue = queue;
	}

	public FormEvent(Object source, int pid, String pps, String firstName, String lastName, String mobileNumber,
			String email, String city, String queue, String newQueue, boolean possiton, boolean data) {
		super(source);
		this.pid = pid;
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.city = city;
		this.queue = queue;
		this.possiton = possiton;
		this.data = data;
		this.newQueue = newQueue;
	}
	
	

	public FormEvent(Object source, int pid, String queue, boolean possiton) {
		super(source);
		this.pid = pid;
		this.queue = queue;
		this.possiton = possiton;
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

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public boolean isPossiton() {
		return possiton;
	}

	public void setPossiton(boolean possiton) {
		this.possiton = possiton;
	}

	public boolean isData() {
		return data;
	}

	public void setData(boolean data) {
		this.data = data;
	}

	public String getNewQueue() {
		return newQueue;
	}

	public void setNewQueue(String newQueue) {
		this.newQueue = newQueue;
	}
	
	
}
