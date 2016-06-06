/**
 * Class to store data of a person's contact information
 * 
 * @author Blair Hagen
 * @version 5-12-2016
 *
 */
public class Person implements Contact {

	private String firstName;		// first name of contact
	private String lastName;		// last name of contact
	private String address;			// home address of contact
	private String emailAddress;	// email address of contact
	private String phoneNumber;		// phone number of contact
	private String birthDay;		// birthday of contact
	
	/**
	 * Non-default constructor
	 * 
	 * @param firstName first name of contact
	 * @param lastName last name of contact
	 * 
	 */
	public Person(String lastName, String firstName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Non-default constructor
	 * 
	 * @param lastName last name of contact
	 */
	public Person(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Getter methods for contact information
	 * @return firstName, lastName, address, emailAddress, phoneNumber, birthDay
	 */
	public String getFirst() {return firstName;}
	public String getLast() {return lastName;}
	public String getAddress() {return address;}
	public String getEmail() {return emailAddress;}
	public String getPhone() {return phoneNumber;}
	public String getBirthday() {return birthDay;}
	
	/**
	 * Setter for first name
	 * @param firstName desired first name
	 */
	public void setFirst(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Setter for last name
	 * @param lastName desired last name
	 */
	public void setLast(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Setter for address
	 * @param address desired address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Setter for email address
	 * @param emailAddress desired email address
	 */
	public void setEmail(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/**
	 * Setter for phone number
	 * @param phoneNumber desired phone number
	 */
	public void setPhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Setter for birthday
	 * @param birthDay desired birth day
	 */
	public void setBirthday(String birthDay) {
		this.birthDay = birthDay;
	}
	
	
	/**
	 * Returns the full name of the person as a string
	 * @return fullName full name of person
	 */
	public String getName() {
		if (firstName == null)
		{
			return(lastName);
		}
		else
		{
		return(lastName + ", " + firstName);
		}
	}

	/**
	 * Compares this person to a contact object
	 * @return -1 if this person is alphabetically before compared
	 * 			0 if the same
	 * 			1 if this person is after compared
	 */
	public int compareTo(Contact otherContact) {
		int rawComp = getName().compareToIgnoreCase(otherContact.getName());
		if (rawComp < 0) return -1;
		else if (rawComp > 0) return 1;
		else return 0;
	}
	
	/**
	 * Returns the person's name
	 * @return lastName, firstName if first name exists
	 * 			lastName if no first name exists
	 */
	public String toString() {
		if (firstName != null)
		{
			return (lastName + ", " + firstName);
		}
		else
		{
			return (lastName);
		}
	}

	/**
	 * Returns a nicer looking string representation of the person
	 * @return pretty string representation
	 */
	public String prettyString() {
		StringBuilder strBuild = new StringBuilder();
		
		if (firstName == null)
		{
			strBuild.append("NAME: " + lastName + "\n"
					+ "-----");
		}
		else
		{
			strBuild.append("NAME: " + lastName + ", " + firstName + "\n"
					+ "-----");
		}
		if (address != null)
		{
			strBuild.append("\n" + "address: " + address);
		}
		if (phoneNumber != null)
		{
			
			strBuild.append("\n" + "phone: " + phoneNumber);
		}
		if (emailAddress != null)
		{
			strBuild.append("\n" + "email: " + emailAddress);
		}
		if (birthDay != null)
		{
			strBuild.append("\n" + "birthday: " + birthDay);
		}
			
		return (strBuild.toString());		
	}

}
