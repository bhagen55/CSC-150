/**
 * Runs tests to see if insertAtTail and add work.
 * I'm giving you the tests this time around.
 * 
 * @author Aaron Cass and Chris Fernandes and Blair Hagen
 * @version 5/26/16
 *
 */
public class LabTests {
	
	public static void main(String[] args) 
    {
        Testing.startTests();
        Testing.setVerbose(true);
		
        testInsertAtTail();
        testAdd();
        
        Testing.finishTests();
    }
	
    private static void testInsertAtTail()
    {
    	Testing.testSection("LL Testing: insertAtTail");
    	
    	LinkedList L = new LinkedList();
    	L.insertAtTail(7);
    	
    	Testing.assertEquals("insert into empty list", "(7)", L.toString());
    	
    	L = new LinkedList();
    	L.insertAtTailPast(1);
    	
    	L.insertAtTail(2);
    	
    	Testing.assertEquals("insert into one-node list", "(1, 2)", L.toString());
    	
    	L = new LinkedList();
    	L.insertAtTailPast(1);
    	L.insertAtTailPast(2);
    	L.insertAtTailPast(3);
    	
    	L.insertAtTail(4);
    	
    	Testing.assertEquals("insert into multi-node list", "(1, 2, 3, 4)", L.toString());
    }
    
    private static void testAdd()
    {
        Testing.testSection("BST Testing: add");
		
        BST<String> bst = new BST<String>();

        Testing.assertFalse("Fred should not be found in an empty tree",
                            bst.search("Fred"));
		
        bst.add("Fred");
        Testing.assertTrue("Fred is now added, so should be found",
                           bst.search("Fred"));
		
        bst.add("Bob");
        Testing.assertTrue("Bob is now added, so should be found",
                           bst.search("Bob"));
        Testing.assertTrue("After adding Bob, Fred should still be found",
                           bst.search("Fred"));
		
        bst.add("Carol");
        Testing.assertTrue("Carol is now added, so should be found",
                           bst.search("Carol"));
        Testing.assertTrue("After adding Carol, Fred should still be found",
                           bst.search("Fred"));
        Testing.assertTrue("After adding Carol, Bob should still be found",
                           bst.search("Bob"));
		
        bst.add("Heloise");	
        Testing.assertTrue("Heloise is now added, so should be found",
                           bst.search("Heloise"));
        Testing.assertTrue("After adding Heloise, Bob should still be found",
                           bst.search("Bob"));
        Testing.assertTrue("After adding Heloise, Fred should still be found",
                           bst.search("Fred"));
        Testing.assertTrue("After adding Heloise, Carol should still be found",
                           bst.search("Carol"));
		
        bst.add("George");
        Testing.assertTrue("George is now added, so should be found",
                           bst.search("George"));
        Testing.assertTrue("After adding George, Bob should still be found",
                           bst.search("Bob"));
        Testing.assertTrue("After adding George, Fred should still be found",
                           bst.search("Fred"));
        Testing.assertTrue("After adding George, Carol should still be found",
                           bst.search("Carol"));
        Testing.assertTrue("After adding George, Heloise should still be found",
                           bst.search("Heloise"));
		
        bst.add("Bob");
        Testing.assertTrue("Bob is added again, should still be found",
                           bst.search("Bob"));
        Testing.assertTrue("After re-adding Bob, Carol should still be found",
                           bst.search("Carol"));
    }
}
