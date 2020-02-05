/** DeQueue class implement the palindrome of elements
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file DeQueueList.java
 */
package com.bridgelabz.datastructures;

import java.util.Scanner;

import com.bridgelabz.util.DeQueue;

public class DeQueueList {
	static DeQueue<Character> dequeue = new DeQueue<Character>();
	
	/**funcrtion to implement given string is palindrome or not
	 * @return boolean isPalindrome
	 */
	public static boolean isPalindrome() {
		Character name1 = ' ';
		Character name2 = ' ';
		boolean ispalindrome = false;
		int size = dequeue.deQueueSize();
		if (size % 2 == 0) {
			while (size != 0) {
				name1 = (Character) dequeue.removeFront();
				name2 = (Character) dequeue.removeRear();
				size--;
			}
			if (name1.equals(name2)) {
				ispalindrome = true;
			}
		} else if (size % 2 == 1) {
			System.out.println("deque contains insufficient  character ");
		}
		return ispalindrome;
	}

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
		String name = null;
		try {
			System.out.println("Enter the  String :");
			name = scanner.next();
		} catch (Exception e) {
			System.out.println("enter string type only..");
		}
		for (int index = 0; index < name.length(); index++) {
			dequeue.addRear(name.charAt(index));
		}
		scanner.close();
		System.out.println(dequeue.deQueueSize());
		System.out.println("given string is palindrome :" +isPalindrome());
	}
}
