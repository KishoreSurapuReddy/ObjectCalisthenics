package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class AddressBookMain {
	
	AddressBookDAOImpl addressbook = new AddressBookDAOImpl();
	Scanner scanner = new Scanner(System.in);
	
	public void menu() throws IOException, ParseException {
		System.out.println("------------------------");
		System.out.println("      ADDRESSBOOK       ");
		System.out.println("     1.Add Person       ");
		System.out.println("     2.update person    ");
		System.out.println("     3.delete person    ");
		System.out.println("     4.save addressbook ");
		System.out.println("     5.search entries   ");
		System.out.println("     6.exit             ");
		System.out.println("select the choice ");
		int choice = 0;
		try {
			choice = addressbook.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter digits only..");
		}
		switchCases(choice);
	}
	
	public void switchCases(int choice) throws IOException, ParseException {
		switch (choice) {
		case 1:
			int loop = 1;
			while (loop == 1) {
				Person person = null;
				String firstName = null;
				try {
					System.out.println("enter the first name :");
					firstName = scanner.nextLine();
					System.out.println("enter last name :");
					String lastName = scanner.nextLine();
					System.out.println("enter address :");
					String address = scanner.nextLine();
					System.out.println("enter city :");
					String city = scanner.nextLine();
					System.out.println("enter state :");
					String state = scanner.nextLine();
					System.out.println("enter zipcode :");
					int zipCode = scanner.nextInt();
					System.out.println("enter phonenumber :");
					long phoneNumber = scanner.nextLong();
					person = new Person(firstName, lastName, address, city, state, zipCode, phoneNumber);
				} catch (Exception e1) {
					System.out.println("enter correct type of data... ");
				}
				addressbook.addPerson(person,firstName);
				try {
					System.out.println("if you want to add another person details press 1 or press any key");
					loop = addressbook.scanner.nextInt();
				} catch (Exception e) {
					System.out.println("enter digits only...");
				}
			}
			menu();
			break;
		case 2:
			String name = null;
			try {
				System.out.println("enter the first name to which record to modify:");
				name = scanner.next();
			} catch (Exception e) {
				System.out.println("enter string type of data...");
			}
			addressbook.editPerson(name);
			menu();
			break;
		case 3:
			String deletename = null;
			try {
				System.out.println("enter the first name to which record to delete ");
				deletename = addressbook.scanner.next();
			} catch (Exception e) {
				System.out.println("enter string type of data..");
			}
			addressbook.deletePerson(deletename);
			menu();
			break;
		case 4:
			System.out.println("enter the name of addressbook to save :");
			String addressBookName = scanner.next();
			addressbook.saveAddressBook(addressBookName);
			menu();
			break;
		case 5:
			try {
				System.out.println("enter the first name :");
				String firstname = addressbook.scanner.next();
				addressbook.searchEntries(firstname);
			} catch (Exception e) {
				System.out.println("enter String type of data..");
			}
			menu();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("enter choice between 1-5 only");
			menu();
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		AddressBookMain address = new AddressBookMain();
		try {
			address.menu();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
