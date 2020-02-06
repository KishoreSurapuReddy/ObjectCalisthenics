package com.bridgelabz.addressbook;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface AddressBookDAO {
	public void addPerson(Person person,String firstName) throws IOException, ParseException;
	public void deletePerson(String firstName) throws IOException, ParseException;
	public void editPerson(String firstName) throws IOException, ParseException;
	public void searchEntries(String firstname) throws IOException, ParseException;
	public void saveAddressBook(String addressBookName) throws IOException, ParseException;
}
