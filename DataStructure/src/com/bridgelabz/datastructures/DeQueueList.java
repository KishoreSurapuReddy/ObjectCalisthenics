/** DeQueue class implement the palindrome of elements
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file DeQueueList.java
 */
package com.bridgelabz.datastructures;

import com.bridgelabz.util.DeQueue;

public class DeQueueList {

	public static void main(String[] args) {
		DeQueue<Character> dequeue = new DeQueue<Character>(); 
		String name = null;
		try {
			System.out.println("Enter the  String :");
			name = dequeue.scanner.next();
		} catch (Exception e) {
			System.out.println("enter string type only..");
		}
		for (int index = 0; index < name.length(); index++) {
			dequeue.addRear(name.charAt(index));
		}
		System.out.println(dequeue.deQueueSize());
		System.out.println("given string is palindrome :" + dequeue.isPalindrome());
	}
}
