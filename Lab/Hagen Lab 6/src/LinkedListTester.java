/**
 * Tests new (and old?) LinkedList methods.
 * 
 * @author Blair Hagen, Aaron Cass, and Chris Fernandes 
 * @version 5/5/16
 */
public class LinkedListTester
{
    public static void main(String[] args)
    {
        Testing.setVerbose(true);
        
    	Testing.startTests();

    	test21();
    	
    	test221();
    	
    	test2321();
    	
    	testSameTime();
    	
    	testAnotherSameTime();

    	Testing.finishTests();
    }
    
    private static void test21()
    {
    	Testing.testSection("1 -> 21\n"
    			+ "Tests inserting at head with one node");
	
        LinkedList list = new LinkedList();
        
        Event E1 = new Event("chess club", 2016, 5, 25, 1900, 1930);
        Event E2 = new Event("boy scouts", 2016, 5, 23, 900, 1000);
		
        list.insertAtHead(E1);
        list.insertSorted(E2);
	
    	Testing.assertEquals("2-node list contents",
                     "(" + E2 + ",\n" + E1 + ")",
                     list.toString());
    	Testing.assertEquals("2-node list length", 2, list.getLength());
    }
    
    private static void test221()
    {
    	Testing.testSection("2 -> 21\n"
    			+ "Tests inserting at tail with one node");
    	
    	LinkedList list = new LinkedList();
        
        Event E1 = new Event("chess club", 2016, 5, 25, 1900, 1930);
        Event E2 = new Event("boy scouts", 2016, 5, 23, 900, 1000);
        
        list.insertAtHead(E2);
        list.insertSorted(E1);
        
        Testing.assertEquals("2-node list contents", "(" + E2 + ",\n" + E1 + ")", list.toString());
        Testing.assertEquals("2-node list length", 2, list.getLength());
    }
    
    private static void test2321()
    {
    	Testing.testSection("2 -> 321\n"
    			+ "Tests inserting at head and tail with two nodes");
    	
        LinkedList list = new LinkedList();
        
        Event E1 = new Event("chess club", 2016, 5, 25, 1900, 1930);
        Event E2 = new Event("boy scouts", 2016, 5, 23, 900, 1000);
        Event E3 = new Event("janitor", 2016, 5, 22, 0, 1000);
		
        list.insertAtHead(E1);
        list.insertSorted(E2);
        list.insertSorted(E3);
        
        Testing.assertEquals("3-node list contents", "(" + E3 + ",\n" + E2 + ",\n" + E1 + ")", list.toString());
        Testing.assertEquals("3-node list length", 3, list.getLength());
    }
    
    private static void testSameTime()
    {
    	Testing.testSection("Tests inserting an event with the same start time as another");
    	
    	LinkedList list  = new LinkedList();
    	
    	Event E1 = new Event("chess club", 2016, 5, 25, 1900, 1930);
    	Event E2 = new Event("checkers club", 2016, 5, 25, 1900, 1935);
    	
    	list.insertAtHead(E1);
    	list.insertSorted(E2);
    	
    	Testing.assertEquals("2-node list contents", "(" + E1 + ",\n" + E2 + ")", list.toString());
    	Testing.assertEquals("2-node list length", 2, list.getLength());
    }
    
    private static void testAnotherSameTime()
    {
    	Testing.testSection("Tests inserting another event at the same time as the other two events");
    	
    	LinkedList list = new LinkedList();
    	
    	Event E1 = new Event("chess club", 2016, 5, 25, 1900, 1930);
    	Event E2 = new Event("checkers club", 2016, 5, 25, 1900, 1935);
    	Event E3 = new Event("magic club", 2016, 5, 25, 1900, 1920);
    	
    	list.insertAtHead(E1);
    	list.insertSorted(E2);
    	list.insertSorted(E3);
    	
    	Testing.assertEquals("3-node list contents", "(" + E1 + ",\n" + E2 + ",\n" + E3 + ")", list.toString());
    	Testing.assertEquals("3-node list length", 3, list.getLength());
    }
}
