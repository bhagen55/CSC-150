/**
 * Class to store data of a businesses contact information
 * 
 * @author Blair Hagen
 * @version 5-12-2016
 * 
 */


public class Business implements Contact {

	private String businessName;
	private String address;
	private String emailAddress;
	private String phoneNumber;
	private String businessHours;
	
	/**
	 * Non-default constructor
	 * 
	 * @param businessName desired name of business
	 */
	public Business(String businessName) {
		this.businessName = businessName;
	}
	
	/**
	 * Getter methods for business information
	 * @return businessName, address, emailAddress, phoneNumber, businessHours
	 */
	public String getName() {return businessName;}
	public String getAddress() {return address;}
	public String getEmail() {return emailAddress;}
	public String getPhone() {return phoneNumber;}
	public String getHours() {return businessHours;}
	
	/**
	 * Setter for business name
	 * @param businessName desired business name
	 */
	public void setName(String businessName) {
		this.businessName = businessName;
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
	 * Setter for business hours
	 * @param businessHours desired hours
	 */
	public void setHours(String businessHours) {
		this.businessHours = businessHours;
	}
	
	/**
	 * Compares this business to a contact object
	 * @return -1 if this business is alphabetically before compared
	 * 			0 if the same
	 * 			1 if this business is after compared
	 */
	public int compareTo(Contact otherContact) {
		int rawComp = getName().compareToIgnoreCase(otherContact.getName());
		if (rawComp < 0) return -1;
		else if (rawComp > 0) return 1;
		else return 0;
	}
	
	/**
	 * Returns the businesses name
	 * @return businessName name of business
	 */
	public String toString() {
		return(businessName);
	}
	
	/**
	 * Returns a nicer looking string representation of the business
	 * @return pretty string representation
	 */
	public String prettyString() {
		StringBuilder strBuild = new StringBuilder();
		
		strBuild.append("NAME: " + businessName + "\n"
				+ "-----");
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
		if (businessHours != null)
		{
			strBuild.append("\n" + "hours: " + businessHours);
		}
		return(strBuild.toString());
	}
}
