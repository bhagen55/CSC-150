/**
 * Tests new (and old?) LinkedList methods.
 * 
 * @author Blair Hagen, Aaron Cass, and Chris Fernandes 
 * @version 4/28/16
 */
public class LinkedListTester
{
    public static void main(String[] args)
    {
        Testing.setVerbose(true); // use false for less testing output
        
        Testing.startTests();

    	testInsertAtHead();
    	
    	testRemoveHead();
    	
    	testInsertAtTail();

    	testSearch();
    	
        Testing.finishTests();
    }

    private static void testInsertAtHead()
    {
    	Testing.testSection("insertAtHead");
	
        LinkedList list = new LinkedList();
        Event E1 = new Event("chess club", 2013, 2, 25, 1900, 1930);
        Event E2 = new Event("boy scouts", 2013, 2, 23, 900, 1000);
		
        list.insertAtHead(E1);

        Testing.assertEquals("Inserting at head of an empty list",
                             "(" + E1 + ")",
                             list.toString());

        Testing.assertEquals("Inserting at head of an empty list, "
                             + "length should change",
                             1,
                             list.getLength());

        list.insertAtHead(E2);

        Testing.assertEquals("Inserting at head of a 1-element list",
                             "(" + E2 + ",\n" + E1 + ")",
                             list.toString());

        Testing.assertEquals("Inserting at head of a 1-element list, "
                             + "length should change",
                             2,
                             list.getLength());
    }
    
    private static void testRemoveHead()
    {
    	Testing.testSection("removeHead");
    	
    	LinkedList list = new LinkedList();
    	
    	Testing.assertEquals("Removing head of empty list", 
			    			null, 
			    			list.removeHead());
    	
    	Event E1 = new Event("chess club", 2013, 2, 25, 1900, 1930);
    	Event E2 = new Event("boy scouts", 2013, 2, 23, 900, 1000);   	
    	list.insertAtHead(E1);
    	list.insertAtHead(E2);    	
    	Event result = list.removeHead();
    	
    	Testing.assertEquals("Removing head of list with two items", 
    						"(" + E1 + ")", 
    						list.toString());
    	
    	Testing.assertEquals("Length should change", 
    						1, 
    						list.getLength());
    	
    	Testing.assertEquals("Should return removed event", 
			    			E2, 
			    			result);
			    	
    	LinkedList list2 = new LinkedList();   	
    	list2.insertAtHead(E1);    	
    	list2.removeHead();
    	
    	Testing.assertEquals("Removing head from list with one element", "()", list2.toString());
    	
    	Testing.assertEquals("Length should change", 0, list2.getLength());

    }
    
    private static void testInsertAtTail()
    {
    	Testing.testSection("insertAtTail");
    	
    	LinkedList list = new LinkedList();
    	
    	Event E1 = new Event("chess club", 2013, 2, 25, 1900, 1930);
    	Event E2 = new Event("boy scouts", 2013, 2, 23, 900, 1000);
    	Event E3 = new Event("end event", 2013, 2, 23, 900, 1000);   	
    	list.insertAtHead(E1);
    	list.insertAtHead(E2);    	
    	list.insertAtTail(E3);
    	
    	Testing.assertEquals("Adding event to end of list (called 'end event')", 
			    			"(" + E2 + ",\n" + E1 + ",\n" + E3 + ")", 
			    			list.toString());
			    	
    	Testing.assertEquals("Length should change", 
			    			3, 
			    			list.getLength());
    	
    	LinkedList list2 = new LinkedList();    	
    	list2.insertAtTail(E1);
    	
    	Testing.assertEquals("Inserting a tail in an empty list", "(" + E1 + ")" , list2.toString());
			    	
    	
    }
    
    private static void testSearch()
    {
    	Testing.testSection("search");
    	
    	LinkedList list = new LinkedList();
    	
    	Event E1 = new Event("chess club", 2013, 2, 25, 1900, 1930);
    	Event E2 = new Event("boy scouts", 2013, 2, 23, 900, 1000);
    	Event E3 = new Event("police academy", 2013, 2, 22, 700, 1000);
    	
    	list.insertAtHead(E1);
    	list.insertAtHead(E2);
    	list.insertAtHead(E3);
    	
    	Testing.assertEquals("Search for event in middle of list", 
			    			900, 
			    			list.search("boy scouts"));
    	
    	Testing.assertEquals("searching for event in the first position of list", 
			    			1900, 
			    			list.search("chess club"));
    	Testing.assertEquals("searching for event in last position of list" , 
			    			700, 
			    			list.search("police academy"));
    	
    	Testing.assertEquals("Should return -1 if event doesnt exist", 
			    			-1, 
			    			list.search("Nonexistent"));
    	
    	LinkedList list2 = new LinkedList();
    	
    	Testing.assertEquals("Should return -1 if linked list is empty", -1, list2.search("Event"));
    	
    	
    }
}
