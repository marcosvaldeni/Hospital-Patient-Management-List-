// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package linkedlist;

public interface InterfaceLinkedList<E> {
	public void add(E e);
	public void add(int index, E e);
	public void addFirst(E e);
	public E get(int index);
	public E getFirst();
	public E getLast();
	public void moveUp(E e);
	public void moveDown(E e);
	public void moveToFirst(E e);
	public void remove(E e);
	public void remove(int index);
	public void remove();
	public int findPosition(E e);
	public void deleteGroup(int number);
	public void update(int index, E e);
	public void clearAll();
	public int size();
}
