public class TestThePerson {

  public static void main(String[] args) {

    Testing.setVerbose(true);
    System.out.println("Starting Tests");

    testCreate();
    
    testGetSet();

    testToStringAndPrettyString();
    
    testCompare();

    // Add more tests for the other methods of the Sequence class.

    System.out.println("Tests Complete");
  }

  private static void testCreate() {
    Testing.testSection("Creation tests");

    Person p1 = new Person("Obama", "Barack");
    Testing.assertEquals("Person created with a last and first name", "Obama, Barack", p1.toString());

    Person p2 = new Person("Bush");
    Testing.assertEquals("Person created with just a last name", "Bush", p2.toString());
  }
  
  private static void testGetSet() {
	Testing.testSection("Testing getting and setting");
	
	Person p1 = new Person("Obama");
	Testing.assertEquals("Getting name", "Obama", p1.getName());
	Testing.assertEquals("Get Last name", "Obama", p1.getLast());
	Testing.assertEquals("Get First name", null, p1.getFirst());
	p1.setFirst("Barack");
	Testing.assertEquals("Set First name", "Barack", p1.getFirst());
	p1.setLast("Baracks");
	Testing.assertEquals("Set Last name", "Baracks", p1.getLast());
	p1.setAddress("White House");
	Testing.assertEquals("Set Address", "White House", p1.getAddress());
	p1.setEmail("baracko@union.edu");
	Testing.assertEquals("Set Email Address", "baracko@union.edu", p1.getEmail());
	p1.setPhone("555-555-5555");
	Testing.assertEquals("Set Phone Number", "555-555-5555", p1.getPhone());
	p1.setBirthday("08/08/0008");
	Testing.assertEquals("Set Birthday", "08/08/0008", p1.getBirthday());
  }

  private static void testToStringAndPrettyString() {
    Testing.testSection("Testing toString and prettyString");

    Person p1 = new Person("Obama", "Barack");
    p1.setAddress("White House");
    p1.setPhone("202-456-1111");
    p1.setEmail("president@whitehouse.gov");
    p1.setBirthday("08/04/1961");

    Testing.assertEquals("toString output:", "Obama, Barack", p1.toString());

    String expected = "NAME: Obama, Barack\n" + "-----\n" + "address: White House\n" + "phone: 202-456-1111\n"
        + "email: president@whitehouse.gov\n" + "birthday: 08/04/1961";
    Testing.assertEquals("prettyString output:", expected, p1.prettyString());

    Person p2 = new Person("Claus", "Santa");
    p2.setAddress("Northpole");
    expected = "NAME: Claus, Santa\n" + "-----\n" + "address: Northpole";
    Testing.assertEquals("prettyString output:", expected, p2.prettyString());
  }
  
  private static void testCompare() {
	Testing.testSection("Testing comparing");
	
	Person p1 = new Person("bbb", "bbb");
	Person p2 = new Person("aaa", "aaa");
	Testing.assertEquals("Compare bbb,bbb to aaa,aaa", 1, p1.compareTo(p2));
	
	p1 = new Person("aaa", "aaa");
	p2 = new Person("aaa", "aaa");
	Testing.assertEquals("Compare aaa,aaa to aaa,aaa", 0, p1.compareTo(p2));
	
	p1 = new Person("aaa", "bbb");
	p2 = new Person("bbb", "bbb");
	Testing.assertEquals("Compare aaa,bbb to bbb,bbb", -1, p1.compareTo(p2));
	
	Business b1 = new Business("tesla");
	Testing.assertEquals("Compare Business: Tesla to Person: aaa, bbb", 1, b1.compareTo(p1));
	Testing.assertEquals("Reverse comparison", -1, p1.compareTo(b1));
	
	Business b2 = new Business("faraday future");
	Testing.assertEquals("Compare Business: Tesla to Business: Faraday Future", 1, b1.compareTo(b2));
	Testing.assertEquals("Reverse comparison", -1, b2.compareTo(b1));
	
	
	
  }

}
