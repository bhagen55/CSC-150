/**
 * Testing class for testing all 8 token classes
 * @author Blair Hagen
 * @version 5-19-16
 */
public class TestOperatorTokens {

    public static void main(String[] args) {
        Testing.setVerbose(true);
        System.out.println("Starting Tests");
        
        testPlus();
        
        testMinus();
        
        testTimes();
        
        testDivide();
        
        testExponent();
        
        testRightParen();
        
        testLeftParen();
        
        testSemicolon();
    }

    private static void testPlus() {
        Testing.testSection("Testing Plus");
        
        Stack<Token> plusSt = new Stack<Token>();
        Plus p1 = new Plus();
        plusSt.push(p1);
        
        Stack<Token> minusSt = new Stack<Token>();
        Minus m1 = new Minus();
        minusSt.push(m1);
        
        Stack<Token> timesSt = new Stack<Token>();
        Times t1 = new Times();
        timesSt.push(t1);
        
        Testing.assertEquals("Handle Plus stack", "+", p1.handle(plusSt));
        p1 = new Plus();
        Testing.assertEquals("Handle Minus stack", "-", p1.handle(minusSt));
        p1 = new Plus();
        Testing.assertEquals("Handle Times stack", "*", p1.handle(timesSt));
    }
    
    private static void testMinus() {
        Testing.testSection("Testing Minus");
        
        Stack<Token> plusSt = new Stack<Token>();
        Plus p1 = new Plus();
        plusSt.push(p1);
        
        Stack<Token> minusSt = new Stack<Token>();
        Minus m1 = new Minus();
        minusSt.push(m1);
        
        Stack<Token> timesSt = new Stack<Token>();
        Times t1 = new Times();
        timesSt.push(t1);
        
        Testing.assertEquals("Handle Plus stack", "+", m1.handle(plusSt));
        m1 = new Minus();
        Testing.assertEquals("Handle Minus stack", "-",m1.handle(minusSt));
        m1 = new Minus();
        Testing.assertEquals("Handle Times stack", "*", m1.handle(timesSt));
    }
    
    private static void testTimes() {
        Testing.testSection("Testing Times");
        
        Stack<Token> plusSt = new Stack<Token>();
        Plus p1 = new Plus();
        plusSt.push(p1);
        
        Stack<Token> minusSt = new Stack<Token>();
        Minus m1 = new Minus();
        minusSt.push(m1);
        
        Stack<Token> timesSt = new Stack<Token>();
        Times t1 = new Times();
        timesSt.push(t1);
        
        Testing.assertEquals("Handle Plus stack", "", t1.handle(plusSt));
        t1 = new Times();
        Testing.assertEquals("Handle Minus stack", "",t1.handle(minusSt));
        t1 = new Times();
        Testing.assertEquals("Handle Times stack", "*", t1.handle(timesSt));
    }
    
    private static void testDivide() {
        Testing.testSection("Testing Divide");
        
        Stack<Token> plusSt = new Stack<Token>();
        Plus p1 = new Plus();
        plusSt.push(p1);
        
        Stack<Token> minusSt = new Stack<Token>();
        Minus m1 = new Minus();
        minusSt.push(m1);
        
        Stack<Token> timesSt = new Stack<Token>();
        Times t1 = new Times();
        timesSt.push(t1);
        
        Divide d1 = new Divide();
        Testing.assertEquals("Handle Plus stack", "", d1.handle(plusSt));
        d1 = new Divide();
        Testing.assertEquals("Handle Minus stack", "",d1.handle(minusSt));
        d1 = new Divide();
        Testing.assertEquals("Handle Times stack", "*", d1.handle(timesSt));
    }
    
    private static void testExponent() {
        Testing.testSection("Testing Exponent");
        
        Stack<Token> plusSt = new Stack<Token>();
        Plus p1 = new Plus();
        plusSt.push(p1);
        
        Stack<Token> minusSt = new Stack<Token>();
        Minus m1 = new Minus();
        minusSt.push(m1);
        
        Stack<Token> timesSt = new Stack<Token>();
        Times t1 = new Times();
        timesSt.push(t1);
        
        Exponent e1 = new Exponent();
        Testing.assertEquals("Handle Plus stack", "", e1.handle(plusSt));
        e1 = new Exponent();
        Testing.assertEquals("Handle Minus stack", "",e1.handle(minusSt));
        e1 = new Exponent();
        Testing.assertEquals("Handle Times stack", "", e1.handle(timesSt));
    }
    
    private static void testRightParen() {
        Testing.testSection("Testing Right Parenthesis");
        
        Stack<Token> parenSt = new Stack<Token>();
        RightParen rParen = new RightParen();
        LeftParen lParen = new LeftParen();
        Plus p1 = new Plus();
        Minus m1 = new Minus();
        //parenSt.push(rParen);
        parenSt.push(lParen);
        parenSt.push(p1);
        parenSt.push(m1);
        
        Testing.assertEquals("Handling stack with two Parentheses", "-+", rParen.handle(parenSt));
    }
    
    private static void testLeftParen() {
        Testing.testSection("Testing Left Parenthesis");
        
        Stack<Token> parenSt = new Stack<Token>();
        LeftParen lParen = new LeftParen();
        lParen.handle(parenSt);
        Testing.assertEquals("Handling with empty stack", "{>(}", parenSt.toString());
        
    }
    private static void testSemicolon() {
        Testing.testSection("Testing Semicolon");
        
        Stack<Token> stack = new Stack<Token>();
        Plus p1 = new Plus();
        stack.push(p1);
        
        Minus m1 = new Minus();
        stack.push(m1);
        
        Times t1 = new Times();
        stack.push(t1);
        
        Semicolon s1 = new Semicolon();
        Testing.assertEquals("Handling stack", "*-+", s1.handle(stack));
    }
}
