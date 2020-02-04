/** FileOrderedList class used to add the elements into list and arranging in oreder
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file FileOrderedList.java
*/
package com.bridgelabz.datastructures;
import com.bridgelabz.util.OrderedList;

public class FileOrderedList {

	public static void main(String[] args) {
		OrderedList<Integer> list = new OrderedList<Integer>();
		int number = 0;
		try {
			System.out.println("enter the number how many numbers want to add :");
			number = list.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter in digits only...");
		}
		System.out.println("enter number :");
		for (int index = 0; index < number; index++) {
			System.out.println("enter " + index + " no");
			try {
				list.addOrderedElement(list.scanner.nextInt());
			} catch (Exception e) {
				System.out.println("enter only int type of data...");
			}
		}
		// printing the list
		list.printList();
		// asking user to enter the element to search in the list
		int searchnum = 0;
		try {
			System.out.println("enter number to search :");
			searchnum = list.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter only int type of data...");
		}
		// calling function for adding and removing elements from list
		OrderedList.addRemove(searchnum, list);
		list.scanner.close();
	}
}
