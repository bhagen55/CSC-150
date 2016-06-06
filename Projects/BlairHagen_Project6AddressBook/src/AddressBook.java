/**
 * User interface for managing an address book
 * Deals with a generic linked list
 * 
 * @author Blair Hagen
 * @version 5-12-2016
 *
 */
import java.util.Scanner;

	

public class AddressBook {
	
	
	GenericLinkedList<Contact> contactBook;
	
	/**
	 * Default Constructor
	 * Creates empty contact linkedlist
	 */
	public AddressBook() {
		contactBook = new GenericLinkedList<Contact>();
	}
	
	/**
	 * Non-default Constructor
	 * Creates contact linked list with given linked list
	 * 
	 * (used for testing)
	 * @param contactBook
	 */
	public AddressBook(GenericLinkedList<Contact> contactBook)
	{
		this.contactBook = contactBook;
	}
	
	/**
	 * Using user input, address a new person/business
	 * 
	 */
	public void add() {
		Scanner scanner = new Scanner(System.in);
		int rawInt = 0;
		
		do
		{
			System.out.println("Adding new Contact:\n"
					+ "1. Person\n"
					+ "2. Business");
			rawInt = Integer.parseInt(scanner.nextLine());
			
			// Person creation
			if (rawInt == 1)
			{
				String lastName;
				String firstName;
				String address;
				String email;
				String phone;
				String birthday;
				
				do
				{
					System.out.println("Enter Last Name (Required):");
					lastName = scanner.nextLine();
				} while (lastName.equals(""));
				Person person = new Person(lastName);
				
				System.out.println("Enter First Name:");
				firstName = scanner.nextLine();
				if (!firstName.equals(""))
				{
					person.setFirst(firstName);
				}
				
				System.out.println("Enter Address:");
				address = scanner.nextLine();
				if (!address.equals(""))
				{
					person.setAddress(address);
				}
				
				System.out.println("Enter Email:");
				email = scanner.nextLine();
				if (!email.equals(""))
				{
					person.setEmail(email);
				}
				
				System.out.println("Enter Phone Number:");
				phone = scanner.nextLine();
				if (!phone.equals(""))
				{
					person.setPhone(phone);
				}
				
				System.out.println("Enter Birthday:");
				birthday = scanner.nextLine();
				if (!birthday.equals(""))
				{
					person.setBirthday(birthday);
				}
				
				contactBook.insertSorted(person);
				System.out.println("Contact " + person.toString() + " has been added!");
			}
			
			// Business creation
			else if (rawInt == 2)
			{
				String businessName;
				String address;
				String emailAddress;
				String phoneNumber;
				String businessHours;
				
				do
				{
					System.out.println("Enter Name (Required):");
					businessName = scanner.nextLine();
				} while (businessName.equals(""));
				
				Business business = new Business(businessName);
				
				System.out.println("Enter Address:");
				address = scanner.nextLine();
				if (!address.equals(""))
				{
					business.setAddress(address);
				}
				
				System.out.println("Enter Email:");
				emailAddress = scanner.nextLine();
				if (!emailAddress.equals(""))
				{
					business.setEmail(emailAddress);
				}
				
				System.out.println("Enter Phone Number:");
				phoneNumber = scanner.nextLine();
				if (!phoneNumber.equals(""))
				{
					business.setPhone(phoneNumber);
				}
				
				System.out.println("Enter Hours:");
				businessHours = scanner.nextLine();
				if (!businessHours.equals(""))
				{
					business.setPhone(businessHours);
				}
				
				contactBook.insertSorted(business);
				System.out.println("Business " + business.toString() + " has been added!");
			}
			// If person/business selection input is incorrect
			else
			{
				System.out.println("Invalid input, please try again");
			}
		} while (rawInt < 1 || rawInt > 2);
		scanner.close();
	}
	
	/**
	 * Searches for person/business based on the given name
	 * Searches for persons first, then searches for businesses
	 * if a person with the name is not found.
	 * 
	 * Prints out the contact details.
	 * If no contact is found, user will be informed.
	 * @param name contact name to search for
	 */
	public void find(String name) {
		Person searchPerson = new Person(name);
		Business searchBusiness = new Business(name);
		
		Contact searchResult = contactBook.find(searchPerson);
		if (searchResult == null)
		{
			searchResult = contactBook.find(searchBusiness);
		}
		
		if (searchResult == null)
		{
			System.out.println("Contact by the name of " + name + " WAS NOT FOUND.");
		}
		else
		{
			System.out.println("Found Contact! Displaying details: \n" + searchResult.prettyString());
		}
	}
	
	/**
	 * Searches for a person/business based on the given name and
	 * removes it/them from the addressbook.
	 * 
	 * If no contact is found, user will be informed.
	 * @param name contact name to search for and remove
	 */
	public void remove(String name) {
		Person searchPerson = new Person(name);
		Business searchBusiness = new Business(name);
		
		Contact searchResult = contactBook.find(searchPerson);
		if (searchResult == null)
		{
			searchResult = contactBook.find(searchBusiness);
		}
		
		if (searchResult == null)
		{
			System.out.println("Contact by the name of " + name + " WAS NOT FOUND.");
		}
		else
		{
			contactBook.remove(searchResult);
			System.out.println("Contact by the name of " + searchResult.getName() + " was removed");
		}
		
	}
	
}
