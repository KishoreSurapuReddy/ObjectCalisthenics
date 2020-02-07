/**Person class have the details about person 
 * @author kishorereddy
 * @version 1.0
 * @since 05-03-2020
 * @file Person.java
*/
package com.bridgelabz.addressbook;

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private long phoneNumber;
	
	//zero parameterised constructor
	public Person() {
		
	}
	
    //parameterised construdtor
	public Person(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", phoneNumber=" + phoneNumber;
	}
}
