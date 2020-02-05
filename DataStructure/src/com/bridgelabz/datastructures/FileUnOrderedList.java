/** FileUnOrderedList class used add the elements into list and find the element present in list or not
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file FileUnOrderedList.java
*/
package com.bridgelabz.datastructures;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.util.UnOrderedList;

public class FileUnOrderedList {

	public static void main(String[] args) {
		UnOrderedList<String> list = new UnOrderedList<String>();
		Scanner scanner = new Scanner(System.in);
		try {
			File file = new File("/home/user/Desktop/unorderedlist.txt");
			Scanner scannerfile = new Scanner(file);
			while (scannerfile.hasNext()) {
				list.addElement(scannerfile.next());
			}
			list.printList();
			FileWriter filewriter = new FileWriter(file);
			System.out.println("the size of list :" + list.sizeOfList());
			System.out.println("enter the word to search :");
			String findElement = scanner.nextLine();
			// taking the user input element for searching in list
			if (list.searchElement(findElement)) {
				// if u find the element it will return
				list.removeElement(findElement);
				// it will remove the element from the list
				int n = 0;
				while (n < list.sizeOfList()) {
					// it will fetch the element from the list and write into file
					// it will clear the stream by flush
					filewriter.write(list.pop(0) + " ");
					filewriter.flush();
					n++;
				}
				System.out.println("item was founded and deleted ");
			} else {
				list.addElement(findElement);
				// if the element not found in the list it will add to
				// the list
				int n = 0;
				while (n < list.sizeOfList()) {
					filewriter.write(list.pop(0) + " ");
					filewriter.flush();
					n++;
				}
				System.out.println("item was added ");
			}
			scanner.close();
			scannerfile.close();
			filewriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("file was not found ");
			// if file was not found this exception will raise
		} catch (IOException e) {
			System.out.println("io exception raised");
		}
	}
}
