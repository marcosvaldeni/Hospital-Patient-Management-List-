// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package linkedlist;

public class LinkedList<E> implements InterfaceLinkedList<E> {

	private Node<E> head;
	
    /**
     * To clear the list.
     */
	@Override
	public void clearAll() { 
		head = null;
	}
	
    /**
     * Append the specified item to the end of the list
     * @param item The item to be appended
     */
	@Override
	public void add(E data) {
		
		Node<E> node = new Node<E>();
		node.data = data;
		
		if(head == null) {
			head = node;
		} else {
			
			Node<E> temp = head;
			
			while(temp.next != null) {
				temp = temp.next;
			}
			
			temp.next = node;
		}
	}
	
    /**
     * Get the data value at index
     * @param index The index of the element to return
     * @returns The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public E get(int index) {
		
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
		
		Node<E> n = head;
		
		for(int i = 0; i <= index-1; i++) {
			n = n.next;
		}
		return n.data;
	}
	
    /**
     * Query the size of the list
     * @return The number of objects in the list
     */
	@Override
	public int size() {
		
		int count = 1;
		
		if(head == null) {
			return 0;
		} else {
			Node<E> temp = head;
			
			while(temp.next != null) {
				temp = temp.next;
				count++;
			}
		}
		return count;
	}
	
    /**
     * Find the item at a specified index
     * @param index The index of the node sought
     * @returns The item at index or null if it does not exist
     */
	@Override
	public E getFirst() {
		Node<E> temp = head;
		return temp.data;
	}
	
    /**
     * Get the data value at the end of the list
     * @returns The last item of the list
     */
	@Override
	public E getLast() {
		Node<E> temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

    /**
     * Remove the item at the specified position in the list. Shifts
     * any consequent items to the left (subtracts one from their
     * Indices). 
     * @param index The index of the item to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

		if (index == 0) {
			
			head = head.next;
			
		} else {
			
			Node<E> n1 = null;
			Node<E> n = head;
			
			for(int i = 0; i < index-1; i++) {
				
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
		}
	}

    /**
     * Insert the specified item at the specified position in the list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices)
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public void add(int index, E e) {
		
		Node<E> node = new Node<E>();
		node.data = e;
		
		if (index == 0) {
			
			node.next = head;
			head = node;
		} else {
			
			Node<E> n = head;
			for(int i = 0; i < index-1; i++) {
				
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}

    /** Insert an item as the first item of the list.
     *	@param item The item to be inserted
     */
	@Override
	public void addFirst(E e) {
		Node<E> newHead = new Node<E>();
		newHead.data = e;
		newHead.next = head;
		head = newHead;
	}

    /** Move a item up (up = near to 0) one position.
     *	@param item The item to be moved
     */
	@Override
	public void moveUp(E e) {
		if (getFirst() != e) {
			int position = findPosition(e);
			add(position-1, removeAndReturn(position));
		}
	}

    /** Move a item down (down = near to bigger number of the list) one position.
     *	@param item The item to be moved
     */
	@Override
	public void moveDown(E e) {
		if (getLast() != e) {
			int position = findPosition(e);
			add(position+1, removeAndReturn(position));
		}
	}

    /** Move a item to the first position of the list.
     *	@param item The item to be moved
     */
	@Override
	public void moveToFirst(E e) {
		int position = findPosition(e);
		add(0, removeAndReturn(position));
	}

    /**
     * Remove the item at the specified position in the list. Shifts
     * any consequent items to the left (subtracts one from their
     * Indices).
     * @param item The item to be removed
     */
	@Override
	public void remove(E element) {
		removeAndReturn(findPosition(element));
	}
	
    /**
     * This is an intern method.
     * Remove the item at the specified position in the list. Shifts
     * any consequent items to the left (subtracts one from their
     * Indices)
     * @param item The item to be removed
     * @return the position of the informed item.
     */
	private E removeAndReturn(int index) {
		Node<E> n1 = null;
		Node<E> n = head;
		
		if (index == 0) {
			
			n1 = head;
			head = head.next;
		} else {
			
			for(int i = 0; i < index-1; i++) {
				
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
		}
		return n1.data;
	}
	
    /**
     * This method finds the object informed in the list and return its position
     * @param item The item to be removed
     * @return index of a item.
     */
	@Override
	public int findPosition(E e) {
		
		int cout = 0;
		Node<E> element = new Node<E>();
		element.data = e;
		Node<E> temp = head;
		
		while(element.data != temp.data) {
			cout++;
			temp = temp.next;
		}
		
		return cout;
	}
	
	/**
	 * Remove the last item into the list
	 */
	@Override
	public void remove() {
		remove(size()-1);
	}

	/**
	 * Remove a number of items at list's end
     * @param number of numbers that will be deleted.
     */
	@Override
	public void deleteGroup(int number) {
		for (int i = 0; i < number; i++) {
			remove();
		}
	}

	/**
	 * Update an item into the list
     * @param index of the item that was modified.
     * @param e object already modified.
     */
	@Override
	public void update(int index, E e) {
		remove(index);
		add(index, e);
	}
}
