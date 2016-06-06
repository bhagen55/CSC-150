/**
 * Class for testing the LinkedList class. Tests each
 * method with edge and unusual cases.
 * 
 * @author Blair Hagen
 * @version 5-5-2016
 *
 */

public class TestTheLinkedList {

		public static void main(String[] args) {
			Testing.setVerbose(true);
			System.out.println("\nStarting Tests");
			
			testConstructor();
			
			testAdding();
			
			testGetting();
			
			testSetting();
			
			testRemoving();
		}
		
		private static void testConstructor() {
			Testing.testSection("Testing constructor");
			LinkedList l1 = new LinkedList();
			
			Testing.assertEquals("Create an empty list: length", 0, l1.size());
			Testing.assertEquals("Create an empty list: toString", "{}", l1.toString());
		}
		
		private static void testAdding() {
			LinkedList l1 = new LinkedList();	
		
			l1.add("zero", 0);
			l1.add("one", 1);
			l1.add("two", 2);
			l1.add("three", 3);
			
			Testing.assertEquals("Adding items to list: length", 4, l1.size());
			Testing.assertEquals("Adding items to list: toString", "{zero, one, two, three}", l1.toString());
			
			l1.add("add", 0);
			Testing.assertEquals("Adding item to start of list", "{add, zero, one, two, three}", l1.toString());
			
			l1.add("add2", 5);
			Testing.assertEquals("Adding item to end of list", "{add, zero, one, two, three, add2}", l1.toString());
		}
		
		private static void testGetting() {
			LinkedList l1 = new LinkedList();	
			
			l1.add("zero", 0);
			l1.add("one", 1);
			l1.add("two", 2);
			l1.add("three", 3);
			
			Testing.assertEquals("Getting item from list", "two", l1.get(2));
			Testing.assertEquals("Get item from beginning of list", "zero", l1.get(0));
			Testing.assertEquals("Get item from end of list", "three", l1.get(3));
		}
		
		private static void testSetting() {
			LinkedList l1 = new LinkedList();	
			
			l1.add("zero", 0);
			l1.add("one", 1);
			l1.add("two", 2);
			l1.add("three", 3);

			l1.set("set1", 2);
			Testing.assertEquals("Set item to 'set'", "{zero, one, set1, three}", l1.toString());
			l1.set("set2", 3);
			Testing.assertEquals("Set item at end of list", "{zero, one, set1, set2}", l1.toString());
			l1.set("set3",  0);
			Testing.assertEquals("Set item at beginning of list", "{set3, one, set1, set2}", l1.toString());
			Testing.assertEquals("Size stays the same", 4, l1.size());
		}
		
		private static void testRemoving() {
			LinkedList l1 = new LinkedList();	
			
			l1.add("zero", 0);
			l1.add("one", 1);
			l1.add("two", 2);
			l1.add("three", 3);
			
			l1.remove(2);
			Testing.assertEquals("Remove item in list", "{zero, one, three}", l1.toString());
			Testing.assertEquals("Size goes down", 3, l1.size());
			l1.remove(0);
			Testing.assertEquals("Remove item from start of list", "{one, three}", l1.toString());
			String retStr = l1.remove(0);
			Testing.assertEquals("Remove item from end of list", "{three}", l1.toString());
			Testing.assertEquals("Removing item returns removed data", "one", retStr);	
		}	
}
