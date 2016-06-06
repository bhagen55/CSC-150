/**
 * Testing class for the generic stack class
 * @author Blair Hagen
 * @version 5-19-16
 *
 */
public class TestTheStack {

    public static void main(String[] args) {
        Testing.setVerbose(true);
        System.out.println("Starting Tests");
        
        testPush();
        
        testToString();
        
        testPeek();
        
    }

    private static void testToString() {
      Testing.testSection("Testing toString");
      
      Stack<String> stack = new Stack<String>();
      Testing.assertEquals("An empty stack. (> indicates the top of the stack)", "{>}", stack.toString());
      
      stack.push("A");
      Testing.assertEquals("A stack with one item", "{>A}", stack.toString());
      
      stack.push("B");
      stack.push("C");
      Testing.assertEquals("A stack with several items", "{>C,B,A}", stack.toString());
    }
    
    private static void testPush() {
        Testing.testSection("Testing Push");
        
        Stack<String> stack = new Stack<String>();
        stack.push("A");
        stack.push("C");
        stack.push("D");
        
        Testing.assertEquals("Push three items","{>D,C,A}", stack.toString());
        
        String returnData = stack.pop();
        Testing.assertEquals("Pop returns item", "D", returnData);

        stack.pop();
        stack.pop();
        Testing.assertEquals("Popping stack with no item", null, stack.pop());
    }
    
    private static void testPeek() {
        Testing.testSection("Testing Peek");
        
        Stack<String> stack = new Stack<String>();
        stack.push("A");
        stack.push("B");
        Testing.assertEquals("Peeking in stack with two items", "B", stack.peek());
        stack.push("C");
        Testing.assertEquals("Peeking in stack with three items", "C", stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        String returnData = stack.peek();
        Testing.assertEquals("Peeking in stack with one item", null, returnData);
        
    }
    
}