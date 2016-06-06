/**
 * Class representing a right parenthesis
 * 
 * Because this is not a mathematical operator, precedence is set
 * to a negative number so other operators can recognize this fact
 * 
 * @author Blair Hagen
 * @version 5-19-2016
 *
 */
public class RightParen implements Token {

    private String toString;
    private int precedence; 
    private StringBuilder strBuild;
    
    private final int DEFAULT_PRECEDENCE = -1;
    private final String DEFAULT_STRING = ")";
    
    /**
     * Default Constructor
     * sets string and precedence to default values of ) and -1
     */
    public RightParen() {
        toString = DEFAULT_STRING;
        precedence = DEFAULT_PRECEDENCE;
        strBuild = new StringBuilder();
    }
    
    /**
     * Returns string representation
     */
    public String toString() {
        return toString;
    }
    
    /**
     * Determines whether to push this operator onto stack
     * or pop operators off of stack and add to string based
     * on precedence, size of stack, or what is next on the stack
     */
    public String handle(Stack<Token> s) {
        while (!s.peek().toString().equals("(")) {
            strBuild.append(s.pop().toString());
        }
        s.pop();
        
        return strBuild.toString();
    }
    
    /**
     * Returns the precedence of this operator
     */
    public int getPrecedence() {
        return precedence;
    }
}
