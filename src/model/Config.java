// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package model;

public class Config {
	
	private final String ADDRESS;
	private final String USER;
	private final String PASS;
	private final String DB;
	private final String PORT;
	
	public Config() {
		this.DB = "hospital";
		this.USER = "marcos";
		this.PASS = "12345678";
		this.PORT = "3306";
		this.ADDRESS = "35.196.34.183";
	}

	public String getAddress() {
		return ADDRESS;
	}

	public String getUser() {
		return USER;
	}

	public String getPass() {
		return PASS;
	}

	public String getDbName() {
		return DB;
	}

	public String getPort() {
		return PORT;
	}
	
}