/**
 * Class for testing the sequence class. Tests each
 * method with edge and unusual cases.
 * 
 * @author Blair Hagen
 * @version 4-28-2016
 *
 */

public class TestTheSequence {

	public static void main(String[] args) {

		Testing.setVerbose(true);
		System.out.println("Starting Tests");

		
		testToString();
		
		testCreate();

		testAddBefore();
		
		testAddAfter();
		
		testAddAll();
		
		testAdvance();
		
		testClone();
		
		testConcatenation();
		
		testEnsureCapacity();
		
		testGetCapacity();
		
		testGetCurrent();
		
		testIsCurrent();
		
		testRemoveCurrent();
		
		testSize();

		testStart();
		
		testTrimToSize();
		
		testEquals();


		System.out.println("Tests Complete");
	}
	
	private static void testToString() {
		Testing.testSection("Testing toString");
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		
		Testing.assertEquals("toString of simple sequence", "{A, >B} (capacity = 10)", s1.toString());
	}

	private static void testCreate() {
		Testing.testSection("Creation tests");

		Sequence s1 = new Sequence();
		Testing.assertEquals("Default constructor", "{} (capacity = 10)", s1.toString());
		Testing.assertEquals("Default constructor, initial size", 0, s1.size());

		Sequence s2 = new Sequence(20);
		Testing.assertEquals("Non-default constructor", "{} (capacity = 20)", s2.toString());
		Testing.assertEquals("Non-default constructor, initial size", 0, s2.size());
		
		String[] testString = {"one", "two", "three"};
		Sequence s3 = new Sequence(testString, 1);
		Testing.assertEquals("Second Non-default constructor with no empty space", "{one, >two, three} (capacity = 3)", s3.toString());
		
		String[] secondTestStr = new String[15];
		secondTestStr[0] = "one";
		secondTestStr[1] = "two";
		secondTestStr[2] = "three";
		Sequence s4 = new Sequence(secondTestStr, 1);
		Testing.assertEquals("Second Non-default constructor with empty space at end of array", "{one, >two, three} (capacity = 15)", s4.toString());
		
	}

	private static void testAddBefore() {
		Testing.testSection("Testing addBefore");
		
		Sequence s1 = new Sequence();
		s1.addBefore("A");
		Testing.assertEquals("Adding A to empty sequence.\n> indicates the current element in the string output", "{>A} (capacity = 10)", s1.toString());
		Testing.assertEquals("Size after adding one item", 1, s1.size());

		s1.addBefore("B");
		Testing.assertEquals("Adding A and then B to empty sequence", "{>B, A} (capacity = 10)", s1.toString());
		Testing.assertEquals("Size after adding two items", 2, s1.size());

		Sequence s2 = new Sequence();
		for (int i = 0; i < 10; i++)
		{
			s2.addBefore("filler");
		}
		s2.addBefore("moreThanTen");
		Testing.assertEquals("Adding an element to a full sequence", "{>moreThanTen, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler} (capacity = 21)", s2.toString());
		Testing.assertEquals("Size after adding to full sequence", 11, s2.size());
		
	}
	
	private static void testAddAfter() {
		Testing.testSection("Testing addAfter");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		Testing.assertEquals("Adding A to empty sequence.", "{>A} (capacity = 10)", s1.toString());
		
		s1.addAfter("B");
		Testing.assertEquals("Adding A and then B to empty sequence", "{A, >B} (capacity = 10)", s1.toString());
		Testing.assertEquals("Size after adding two items", 2, s1.size());
		
		Sequence s2 = new Sequence();
		for (int i = 0; i < 10; i++)
		{
			s2.addAfter("filler");
		}
		s2.addAfter("moreThanTen");
		Testing.assertEquals("Adding an element to a full sequence", "{filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, >moreThanTen} (capacity = 21)", s2.toString());
		Testing.assertEquals("Size after adding to full sequence", 11, s2.size());
	}
	
	private static void testAddAll() {
		Testing.testSection("Testing addAll");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		Sequence s2 = new Sequence();
		s2.addAfter("a");
		s2.addAfter("b");
		
		s1.addAll(s2);
		Testing.assertEquals("Adding a sequence with two elements to a sequence with two elements", "{A, >B, a, b} (capacity = 10)", s1.toString());
		
		Sequence s3 = new Sequence();
		s3.addAll(s2);
		Testing.assertEquals("Adding a sequence with two elements to an empty sequence", "{a, b} (capacity = 10)", s3.toString());
		
		Sequence s4 = new Sequence();
		s2.addAll(s4);
		Testing.assertEquals("Adding an empty sequence to a sequence with two elements", "{a, >b} (capacity = 10)", s2.toString());
		
		Sequence s5 = new Sequence();
		for (int i = 0; i < 10; i++)
		{
			s5.addAfter("filler");
		}
		s5.addAll(s2);
		Testing.assertEquals("Adding sequence to a full array", "{filler, filler, filler, filler, filler, filler, filler, filler, filler, >filler, a, b} (capacity = 12)", s5.toString());
		Testing.assertEquals("Size after adding to full sequence", 12, s5.size());
	}
	
	private static void testClone() {
		Testing.testSection("Test clone");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");

		Sequence s2 = s1.clone();
		Testing.assertEquals("Clone simple sequence", "{A, >B} (capacity = 10)", s2.toString());
		
		Sequence s3 = new Sequence();
		s3.addAfter("a");
		s3.addAfter("b");
		s2.addAll(s3);
		s2.advance();
		Testing.assertEquals("Edit clone sequence and check template sequence for edits", "{A, >B} (capacity = 10)", s1.toString());
		
		s1.advance();
		Testing.assertEquals("Advance past end of array", null , s1.getCurrent());
	}

	private static void testAdvance() {
		Testing.testSection("Testing advance");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		Sequence s2 = new Sequence();
		s2.addAfter("a");
		s2.addAfter("b");
		s1.addAll(s2);
		
		s1.advance();
		Testing.assertEquals("Advance a simple sequence", "{A, B, >a, b} (capacity = 10)", s1.toString());
		
		s1.advance();
		s1.advance();
		Testing.assertEquals("Advance past end of sequence", "{A, B, a, b} (capacity = 10)", s1.toString());
	}
	
	private static void  testConcatenation() {
		Testing.testSection("Testing concatenation");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		Sequence s2 = new Sequence();
		s2.addAfter("a");
		s2.addAfter("b");
		
		Sequence concatSeq = Sequence.concatenation(s1, s2);
		Testing.assertEquals("Concatenate two simple sequences", "{A, B, a, b} (capacity = 20)", concatSeq.toString());
		Testing.assertEquals("Current element must be null", null, concatSeq.getCurrent());
		
		Sequence s3 = new Sequence();
		Sequence concatSeq2 = Sequence.concatenation(s1, s3);
		Testing.assertEquals("Concatenate a simple sequence with an empty sequence", "{A, B} (capacity = 20)", concatSeq2.toString());
		
		Sequence concatSeq3 = Sequence.concatenation(s3, s1);
		Testing.assertEquals("Concatenate an empty sequence with a simple sequence", "{A, B} (capacity = 20)", concatSeq3.toString());
	}
	
	private static void testEnsureCapacity() {
		Testing.testSection("Testing EnsureCapacity");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		
		s1.ensureCapacity(100);
		Testing.assertEquals("Ensure capacity of simple sequence", "{A, >B} (capacity = 100)", s1.toString());
		
		Sequence s2 = new Sequence();
		s2.addAfter("a");
		s2.addAfter("b");
		s2.ensureCapacity(1);
		Testing.assertEquals("Try to make capacity smaller than number of elements in sequence", "{a, >b} (capacity = 10)", s2.toString());
	}
	
	private static void testGetCapacity() {
		Testing.testSection("Testing getCapacity");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		Testing.assertEquals("Get capacity of simple sequence", 10, s1.getCapacity());
		
		Sequence s2 = new Sequence();
		Testing.assertEquals("Get capacity of empty sequence", 10, s2.getCapacity());
	}
	
	private static void testGetCurrent() {
		Testing.testSection("Testing getCurrent");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		Testing.assertEquals("Get current of simple sequence", "B", s1.getCurrent());
		
		Sequence s2 = new Sequence();
		Testing.assertEquals("Get current of empty sequence", null, s2.getCurrent());
	}
	
	private static void testIsCurrent() {
		Testing.testSection("Testing iscurrent");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		Testing.assertEquals("Check if simple sequence has a current element", true, s1.isCurrent());
		
		Sequence s2 = new Sequence();
		Testing.assertEquals("Check if empty sequence has a current element", false, s2.isCurrent());
	}
	
	private static void testRemoveCurrent() {
		Testing.testSection("Testing removeCurrent");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		s1.addBefore("C");
		s1.removeCurrent();
		Testing.assertEquals("Remove current of simple sequence with no following element", "{A, >B} (capacity = 10)", s1.toString());
		
		Sequence s2 = new Sequence();
		s2.removeCurrent();
		Testing.assertEquals("Remove current of empty sequence", "{} (capacity = 10)", s2.toString());
		
		Sequence s3 = new Sequence();
		s3.addAfter("a");
		s3.addAfter("b");
		s3.addAfter("c");
		
		Sequence s4 = new Sequence();
		s4.addAfter("A");
		s4.addAfter("B");
		s4.addAfter("C");
		
		s3.addAll(s4);
		s3.removeCurrent();
		Testing.assertEquals("Remove current of larger array", "{a, b, >A, B, C} (capacity = 10)", s3.toString());
	}
	
	private static void testSize() {
		Testing.testSection("Testing size");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		Testing.assertEquals("Check size of simple sequence", 2, s1.size());
		
		s1.addAfter("C");
		Testing.assertEquals("Check size of sequence after adding element", 3, s1.size());
		
		s1.removeCurrent();
		Testing.assertEquals("Check size of sequence after removing current element", 2, s1.size());
		
	}
	
	private static void testStart() {
		Testing.testSection("Testing start");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		s1.start();
		Testing.assertEquals("Start simple sequence", "{>A, B} (capacity = 10)", s1.toString());
		
		Sequence s2 = new Sequence();
		s2.start();
		Testing.assertEquals("Start empty sequence and check if current element exists", false, s2.isCurrent());
	}
	
	private static void testTrimToSize() {
		Testing.testSection("Testing trimToSize");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		s1.trimToSize();
		Testing.assertEquals("Trim simple sequence", "{A, >B} (capacity = 2)", s1.toString());
		
		s1.trimToSize();
		Testing.assertEquals("Trim already full sequence", "{A, >B} (capacity = 2)", s1.toString());
	}
	
	private static void testEquals() {
		Testing.testSection("Tesing equals");
		
		Sequence s1 = new Sequence();
		s1.addAfter("A");
		s1.addAfter("B");
		Sequence s2 = new Sequence();
		s2.addAfter("A");
		s2.addAfter("B");
		Testing.assertEquals("Compare two identical sequences", true, s1.equals(s2));
		
		Sequence s3 = new Sequence(100);
		s3.addAfter("A");
		s3.addAfter("B");
		Testing.assertEquals("Compare two identical sequences with varying capacity", true, s1.equals(s3));
		
		Sequence s4 = new Sequence();
		s4.addAfter("C");
		s4.addAfter("D");
		Testing.assertEquals("Compare two different sequences", false, s1.equals(s4));
		
		Sequence s5 = new Sequence();
		Sequence s6 = new Sequence();
		Testing.assertEquals("Compare two empty sequences", true, s5.equals(s6));
	}
}
