/**Stack class implementing the functions of Stack
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file Stack.java
*/
package com.bridgelabz.util;

public class Stack<T> {
	Node<T> top;
	int size = 0;

	public Stack() {
		top = null;
	}

	/**
	 * function to implement push the element to the stack
	 * @param character
	 */
	public void pushCharacter(T character) {
		Node<T> newNode = new Node<T>(character);
		if (top == null) {
			top = newNode;
			newNode.next = null;
			size++;
			return;
		}
		newNode.next = top;
		top = newNode;
		size++;
	}

	/**
	 * function to implement pop the element from the stack
	 * @param character
	 * @return pop element
	 * @throws Exception 
	 */
	public T popCharacter(T character){
		Node<T> current = top;
		Node<T> previous = top;
		if (isEmptyStack()) {
			throw new NullPointerException("stack is empty");
		}
		T element = null;
		current = top;
		while (current.data != character) {
			System.out.println(current.data);
			previous = current;
			current = current.next;
		}
		if(top.data == character) {
			element = current.data;
			previous.next = current.next;
			size--;
			return element;
		}
		return element;
	}

	/**
	 * function to implement peek the top of element from stack
	 */
	public T peekStack() {
		if (top == null) {
			throw new NullPointerException("stack is empty");
		}
		return top.data;
	}

	/**
	 * function to implement size of stack
	 * @return size of stack
	 */
	public int sizeOfStack() {
		return size;
	}

	/**
	 * function to implement weather stack is empty or not
	 * @return weather empty or not
	 */
	public boolean isEmptyStack() {
		if (top.data == null) {
			return true;
		}
		return false;
	}
}
