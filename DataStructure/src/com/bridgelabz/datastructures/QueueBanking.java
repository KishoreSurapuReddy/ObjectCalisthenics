/**QueueBanking is used to add the elements into Queue
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file QueueBanking.java
*/
package com.bridgelabz.datastructures;
import java.util.Scanner;

import com.bridgelabz.util.Queue;

public class QueueBanking {
	private static int bankAmount = 100000;
	static Scanner scanner = new Scanner(System.in);
	
	public static void bankingCounter(String customerName) {
		System.out.println("customer name :" + customerName);
		int choice = 0;
		int amount = 0;
		try {
			System.out.println("select the choice 1.WithdrawMoney 2.DepositMoney ");
			choice = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Enter details correctly... ");
		}
		switch (choice) {
		case 1:
			try {
				System.out.println("Enter the amount to withdraw :");
				amount = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("enter amount digits...");
			}
			if (amount <= 50000) {
				System.out.println(customerName + " has withdraw from account ");
				withDrawCash(customerName, amount);
				System.out.println(customerName + " withdraw amount is :" + amount);
				System.out.println("Final bank amount is : " + bankAmount);
				break;
			} else {
				System.out.println("daily withdraw amount limit is < 50000 only");
			}
		case 2:
			try {
				System.out.println("Enter the amount to depost :");
				amount = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("enter amount in digits...");
			}
			System.out.println(customerName + " has deposited amount into bank ");
			depositCash(customerName, amount);
			System.out.println(customerName + " deposited amount is :" + amount);
			System.out.println("Final bank amount is : " + bankAmount);
			break;
		default:
			System.out.println("Select only range between 1 - 2");
			break;
			}
	}
	
	/**
	 * function to implement deposit amount
	 * @param customername
	 * @param amount
	 * @return total amount
	 */
	public static int depositCash(String customername, int amount) {
		bankAmount += amount;
		return bankAmount;
	}

	/**
	 * function to implement withdraw cash
	 * @param customername
	 * @param amount
	 * @return total amount
	 */
	public static int withDrawCash(String customername, int amount) {
		bankAmount -= amount;
		return bankAmount;
	}
	
	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		System.out.println("---------------------");
		System.out.println("  Welcome to Bank    ");
		System.out.println("how many memebers are in queue:");
		int members = 0;
		try {
			members = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter int type of data");
		}
		for (int memeber = 1; memeber <= members; memeber++) {
			System.out.println("enter the name :");
			String customer = scanner.next();
			queue.enQueue(customer);
		}
		do {
			String customerName = queue.deQueue();
			bankingCounter(customerName);
		}
		while (!queue.isQueueEmpty());
	}
}
