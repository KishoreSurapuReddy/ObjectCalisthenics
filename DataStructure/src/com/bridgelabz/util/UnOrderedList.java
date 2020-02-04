/** UnOrderedList class implementing LinkedList functions
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file UnOrderedList.java
*/
package com.bridgelabz.util;
import java.util.Scanner;

public class UnOrderedList<T> {
	Node<String> head;
	public int size = 0;
	public Scanner scanner = new Scanner(System.in);

	/**function for inserting element at particular position in the list
	 * @param <T>
	 * @param position
	 * @param data
	 */
	@SuppressWarnings({ "hiding" })
	public <T> void insertParticularPosition(int position, T data) {
		if (position > size || position < 0) {
			System.out.println("we can not insert at this position ");
			return;
		}
		int index = 0;
		Node<String> node = (Node<String>) head;
		Node<String> new_node =  new Node<String>((String) data);
		if (head == null) {
			new_node.next = (Node<String>) head;
			head = new_node;
			return;
		}
		while (position != index) {
			node = node.next;
			index++;
		}
		new_node.next = node.next;
		node.next = new_node;
	}

	/** function for size of list
	 * @return size
	 */
	public int sizeOfList() {
		return size;
	}

	/**function for reading the data from list 
	 * @return toString
	 */
	@SuppressWarnings("unchecked")
	public String toString() {
		StringBuffer stringbuffer = new StringBuffer();
		Node<T> node = (Node<T>) head;
		stringbuffer.append("[ ");
		while (node != null) {
			stringbuffer.append(node.data);
			node = node.next;
			stringbuffer.append(" , ");
		}
		stringbuffer.append(" ]");
		return stringbuffer.toString();
	}

	//function for printing list elements
	public void printList() {
		System.out.println(toString());
	}

	/** function for know weather list is empty or not
	 * @return empty or not
	 */
	@SuppressWarnings("unchecked")
	public boolean isListEmpty() {
		Node<T> node = (Node<T>) head;
		if (node == null) {
			return true;
		}
		return false;
	}

	/** function for finding the index position
	 * @param <T>
	 * @param data
	 * @return index position
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> int index(T data) {
		int index = 0;
		Node<T> node = (Node<T>) head;
		while (!node.data.equals(data)) {
			node = node.next;
			index++;
		}
		return index;
	}

	/**function for adding elements to list at end position
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public void addElement(T data) {
		Node<T> new_node = new Node<T>(data);
		if (head == null) {
			head = (Node<String>) new_node;
			size++;
			return;
		}
		Node<T> node = (Node<T>) head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new_node;
		size++;
	}

	/**function for removing particular element
	 * @param find
	 */
	@SuppressWarnings("unchecked")
	public void removeElement(T find) {
		Node<T> node = (Node<T>) head;
		Node<T> previous = null;
		if (head.data.equals(find)) {
			head = head.next;
			size -= 1;
		}
		while (!node.data.equals(find)) {
			previous = node;
			node = node.next;
		}
		node = node.next;
		previous.next = node;
		node = null;
		size -= 1;
	}

	/** function for removing the particular position and
	 * @param position
	 * @return pop element
	 */
	@SuppressWarnings("unchecked")
	public T pop(int position) {
		int index = 0;
		Node<T> node = (Node<T>) head;
		if (position == 0) {
			head = head.next;
			size--;
			return (T) node.data;
		}
		Node<T> prev = null;
		while (index != position) {
			prev = node;
			node = node.next;
			index++;
		}
		prev.next = node.next;
		size -= 1;
		return (T) node.data;
	}

	/**function for removing the last index element of list
	 * @return pop element
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		Node<T> node = (Node<T>) head;
		if (size == 1) {
			head = head.next;
			size--;
			return (T) node.data;
		}
		while (node.next != null) {
			node = node.next;
		}
		T res = (T) node.data;
		node = node.next;
		size--;
		return res;
	}

	/**function for searching the element in the list
	 * @param find
	 * @return if it is present or not
	 */
	@SuppressWarnings("unchecked")
	public boolean searchElement(T find) {
		Node<T> node = (Node<T>) head;
		while (node != null) {
			if (node.data.equals(find)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
}
