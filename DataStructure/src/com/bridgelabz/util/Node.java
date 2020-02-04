package com.bridgelabz.util;

public class Node<T> {
	T data;
	Node<T> next;
	Node<T> left, right;
	Node<T> prev;

	// constructor for Node class
	public Node(T data) {
		this.data = data;
		this.next = null;
		this.left = this.right = null;
	}
}
