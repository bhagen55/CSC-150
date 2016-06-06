
public class TestTheAddressBook {

	public static void main(String[] args) {
			
			Testing.setVerbose(true);
			System.out.println("Starting Address Book Tests");
			
			testFind();
	}
	
	private static void testFind() {
		Testing.testSection("Find test");
		
		GenericLinkedList<Contact> cb = new GenericLinkedList<Contact>();
		
		Person p2 = new Person("Bobama");
		p2.setFirst("Barack");
		p2.setAddress("White House");
		p2.setBirthday("Birthday Date");
		p2.setEmail("obama@whitehouse.gov");
		p2.setPhone("555-555-5555");
		Person p3 = new Person("Abama");
		Business b1 = new Business("Dell");
		b1.setAddress("Somewhere is the address");
		b1.setEmail("dell@dell.com");
		Business b2 = new Business("Nell");
		Business b3 = new Business("Opell");
		  
		cb.insertSorted(p2);
		cb.insertSorted(p3);
		cb.insertSorted(b1);
		cb.insertSorted(b2);
		cb.insertSorted(b3);
		 
		
		AddressBook ab = new AddressBook(cb);
		
		System.out.println("Searching for business");
		ab.find("Dell");
		
		System.out.println("\n\n---------\nSearching for person:");
		ab.find("Bobama, Barack");
		
		System.out.println("\n\n---------\nSearching for something that doesnt exist:");
		ab.find("nonexistant");
		
		System.out.println("\n\n\n---------\nRemoving a business");
		ab.remove("Nell");
		
		System.out.println("\n\n\n---------\nRemoving a person");
		ab.remove("Abama");
		
		System.out.println("\n\n---------\nRemoviing something that doesnt exist:");
		ab.remove("nonexistant");
		
	}
		
		
}
