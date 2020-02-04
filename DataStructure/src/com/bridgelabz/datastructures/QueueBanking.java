/**QueueBanking is used to add the elements into Queue
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file QueueBanking.java
*/
package com.bridgelabz.datastructures;
import com.bridgelabz.util.Queue;

public class QueueBanking {

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		System.out.println("---------------------");
		System.out.println("  Welcome to Bank    ");
		System.out.println("how many memebers are in queue:");
		int members = queue.scanner.nextInt();
		for (int memeber = 1; memeber <= members; memeber++) {
			System.out.println("enter the name :");
			queue.enQueue(queue.scanner.next());
		}
		do {
			queue.deQueue();
		}
		/*
		 * Repeat until queue get null
		 */
		while (!queue.isQueueEmpty());
	}
}
