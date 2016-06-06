public class TestTheBusiness {

  public static void main(String[] args) {

    Testing.setVerbose(true);
    System.out.println("Starting Tests");

    testCreate();
    
    testGetSet();

    testToStringAndPrettyString();

    // Add more tests for the other methods of the Sequence class.

    System.out.println("Tests Complete");
  }

  private static void testCreate() {
    Testing.testSection("Creation tests");

    Business b1 = new Business("Rudi's Bike Repair");
    Testing.assertEquals("Newly created business", "Rudi's Bike Repair", b1.toString());
  }

  private static void testGetSet() {
	Testing.testSection("Testing getting and setting");
	
	Business b1 = new Business("RPI");
	Testing.assertEquals("Getting name", "RPI", b1.getName());
	b1.setName("Union");
	Testing.assertEquals("Set name", "Union", b1.getName());
	b1.setAddress("NY");
	Testing.assertEquals("Set Address", "NY", b1.getAddress());
	b1.setEmail("u@union.edu");
	Testing.assertEquals("Set Email Address", "u@union.edu", b1.getEmail());
	b1.setPhone("555-555-5555");
	Testing.assertEquals("Set Phone Number", "555-555-5555", b1.getPhone());
	b1.setHours("24/7");
	Testing.assertEquals("Set hours", "24/7", b1.getHours());
  }
  
  private static void testToStringAndPrettyString() {
    Testing.testSection("Testing toString and prettyString");
    
    Business b1 = new Business("Rudi's Bike Repair");
    b1.setAddress("Somewhere in Florida");
    b1.setPhone("813-997-4121");
    b1.setEmail("rudi@bikerepair.com");
    b1.setHours("Mo-Fri 10-7");

    Testing.assertEquals("toString output:", "Rudi's Bike Repair", b1.toString());

    String expected = "NAME: Rudi's Bike Repair\n" + "-----\n" + "address: Somewhere in Florida\n" + "phone: 813-997-4121\n"
        + "email: rudi@bikerepair.com\n" + "hours: Mo-Fri 10-7";
    Testing.assertEquals("prettyString output:", expected, b1.prettyString());

    Business b2 = new Business("Kangaroo Club");
    b2.setAddress("Australia");
    expected = "NAME: Kangaroo Club\n" + "-----\n" + "address: Australia";
    Testing.assertEquals("prettyString output:", expected, b2.prettyString());
  }

}
