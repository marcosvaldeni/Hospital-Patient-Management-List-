// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package view;

public interface PatientTableListener {
	public void rowDeleted(int row);
	public void moveRowUp(int row);
	public void moveRowDown(int row);
	public void moveRowToFirst(int row);
}
