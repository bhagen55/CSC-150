/**
 * Tests the Interface and the LL which uses it
 * 
 * @author Blair Hagen and Chris Fernandes 
 * @version 5/5/16
 */
public class InterfaceTester {

	public static void main(String[] args) {
		Testing.setVerbose(true);
        
    	Testing.startTests();

    	compareToTests();

    	Testing.finishTests();
    	
    	insertTests();
	}
	
	private static void compareToTests() {
		
        Event E1 = new Event("boy scouts", 2016, 6, 5, 900, 1000);
        Event E2 = new Event("book club", 2016, 5, 10, 1500, 1630);
        
        Testing.assertEquals("Event-Event different dates",1,E1.compareTo(E2));
        
        Reminder R1 = new Reminder("take out the trash", "6/5/2016");
        Reminder R2 = new Reminder("take out the recycling", "6/4/2016");
        Reminder R3 = new Reminder("take out the compost", "6/8/2016");
        
        Testing.assertEquals("Compare Reminder to Event: Same Day", 1, E1.compareTo(R1));
        Testing.assertEquals("Compare Event to Reminder: Same Day", -1, R1.compareTo(E1));
        
        Testing.assertEquals("Compare Reminder to Event: Event later", 1, E1.compareTo(R2));
        Testing.assertEquals("Compare Event to Reminder: Event later", -1, R2.compareTo(E1));
        
        Testing.assertEquals("Compare Reminder to Event: Event Earlier", -1, E1.compareTo(R3));
        Testing.assertEquals("Compare Event to Reminder: Event Earlier", 1, R3.compareTo(E1));
        

	}
	
	private static void insertTests() {
		
        LinkedList newList = new LinkedList();
		
		Event E1 = new Event("boy scouts", 2016, 6, 5, 900, 1000);
        Event E2 = new Event("book club", 2016, 7, 10, 1500, 1630);
        
        Reminder R1 = new Reminder("take out the trash", "6/5/2016");
        Reminder R2 = new Reminder("take out the recycling", "6/4/2016");
        Reminder R3 = new Reminder("take out the compost", "6/8/2016");
        
        newList.insertAtHead(E1);
        newList.insertSorted(R2);
        Testing.assertEquals("Inserting Reminder earlier than Event", "(" + R2 + ",\n" + E1 + ")", newList.toString());
        newList.insertSorted(R1);
        Testing.assertEquals("Inserting Reminder on same day as Event", "(" + R2 + ",\n" + R1 + ",\n" + E1 + ")", newList.toString());
        newList.insertSorted(R3);
        Testing.assertEquals("Inserting Reminder later than Event",  "(" + R2 + ",\n" + R1 + ",\n" + E1 + ",\n" + R3 + ")", newList.toString());
        newList.insertSorted(E2);
        Testing.assertEquals("Inserting Event later than all", "(" + R2 + ",\n" + R1 + ",\n" + E1 + ",\n" + R3 + ",\n" + E2 + ")", newList.toString());
	}
	
	
}
