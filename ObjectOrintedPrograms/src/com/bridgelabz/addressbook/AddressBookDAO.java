/**AddressBookDAO interface have abstract methods to implement
 * @author kishorereddy
 * @version 1.0
 * @since 05-03-2020
 * @file AdressBookDAO.java
*/
package com.bridgelabz.addressbook;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface AddressBookDAO {
	//abstract methods
	public void addPerson(Person person,String firstName) throws IOException, ParseException;
	public void deletePerson(String firstName) throws IOException, ParseException;
	public void editPerson(String firstName) throws IOException, ParseException;
	public void searchEntries(String firstname) throws IOException, ParseException;
	public void saveAddressBook(String addressBookName) throws IOException, ParseException;
}
