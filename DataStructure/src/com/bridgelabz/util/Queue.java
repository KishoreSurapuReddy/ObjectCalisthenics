/**Queue class implementing the functions of Queue
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file Queue.java
*/
package com.bridgelabz.util;

public class Queue<T> {
	Node<T> left, right;
	int size = 0;

	/**
	 * function to implement enQueue
	 * @param customer
	 */
	public void enQueue(T customer) {
		Node<T> newNode = new Node<T>(customer);
		if (left == null) {
			left = right = (Node<T>) newNode;
			return;
		}
		right.next = (Node<T>) newNode;
		right = (Node<T>) newNode;
		size++;
	}

	/**
	 * function to implement dequeue
	 */
	public T deQueue(){
		@SuppressWarnings("unused")
		Node<T> current;
		if (left == null) {
			throw new NullPointerException("queue is empty");
		}
		T customername = null;
		while (left != null) {
			customername = (T) left.data;	
			current = left;
			left = left.next;
			current = null;
			return customername;
		}
		return customername;
	}

	/**
	 * function to implement isQueueEmpty
	 * @return empty or not
	 */
	public boolean isQueueEmpty() {
		if (left == null) {
			return true;
		}
		return false;
	}

	/**
	 * function to implment size of queue
	 */
	public int sizeOfQueue() {
		return size;
	}
}
