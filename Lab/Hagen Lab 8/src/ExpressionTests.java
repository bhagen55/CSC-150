/**
 * Runs tests to be sure you created the expression tree correctly.
 * 
 * @author Blair Hagen and Aaron Cass and Chris Fernandes
 * @version 5/18/16
 *
 */
public class ExpressionTests
{
    public static void main(String [] args) 
    {
        Testing.startTests();
        Testing.setVerbose(true);
        
        testNoOperator();
        testOneOperator();
        testTwoOperators();
        testThreeOperators();
        testEightOperators();
        testRightTree();
        testLeftTree();
	
        Testing.finishTests();
    }
    
    private static void printResults(String input, String expected) {
    	ExpressionTree e = new ExpressionTree(input);
        Testing.assertEquals(input + " was input, prefix string should match",
                             input,
                             e.prefixString());
        Testing.assertEquals(input + " was input, infix string should be " + expected,
                             expected,
                             e.infixString());
    }
	
    private static void testNoOperator()
    {
    	Testing.testSection("Expressions with One Operand");
    	
    	String prefixInput = "8";
    	String expectedInfix = "8";
    	printResults(prefixInput, expectedInfix);
    }
    
    private static void testOneOperator()
    {
        Testing.testSection("Expressions with one operator");
	
        String prefixInput = "+56";
        String expectedInfix = "(5+6)";
        printResults(prefixInput, expectedInfix);
		
        prefixInput = "-23";
        expectedInfix = "(2-3)";
        printResults(prefixInput, expectedInfix);
    }
	
    private static void testTwoOperators()
    {
        Testing.testSection("Expressions with two operators");
	
        String prefixInput = "/-123";
        String expectedInfix = "((1-2)/3)";
        printResults(prefixInput, expectedInfix);
	
        prefixInput = "/1-23";
        expectedInfix = "(1/(2-3))";
        printResults(prefixInput, expectedInfix);
    }
    
    private static void testThreeOperators()
    {
    	Testing.testSection("Expressions with three operators");
    	
    	String prefixInput = "*/235";
    	String expectedInfix = "((2/3)*5)";
    	printResults(prefixInput, expectedInfix);
    	
    	prefixInput = "/*235";
    	expectedInfix = "((2*3)/5)";
    	printResults(prefixInput, expectedInfix);
    }
    
    private static void testEightOperators()
    {
    	Testing.testSection("Expressions with eight operators");
    	
    	String prefixInput = "-*32+/54/+-19*876";
    	String expectedInfix = "((3*2)-((5/4)+(((1-9)+(8*7))/6)))";
    	printResults(prefixInput, expectedInfix);
    }
    
    private static void testRightTree()
    {
    	Testing.testSection("Make a left heavy tree");
    	
    	String prefixInput = "*9/8+7*6-54";
    	String expectedInfix = "(9*(8/(7+(6*(5-4)))))";
    	printResults(prefixInput, expectedInfix);
    }
    
    private static void testLeftTree()
    {
    	Testing.testSection("Make a right heavy tree");
    	
    	String prefixInput = "*/+*-456789";
    	String expectedInfix = "(((((4-5)*6)+7)/8)*9)";
    	printResults(prefixInput, expectedInfix);
    }
}