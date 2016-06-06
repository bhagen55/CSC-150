/**
 * Class representing a left parenthesis
 * 
 * Because this is not a mathematical operator, precedence is set
 * to a negative number so other operators can recognize this fact
 * 
 * @author Blair Hagen
 * @version 5-19-2016
 *
 */
public class LeftParen implements Token {

    private String toString;
    private int precedence;
    
    private final int DEFAULT_PRECEDENCE = -1;
    private final String DEFAULT_STRING = "(";
    
    /**
     * Default Constructor
     * sets string and precedence to default values of ; and -1
     */
    public LeftParen() {
        toString = DEFAULT_STRING;
        precedence = DEFAULT_PRECEDENCE;
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
        s.push(this);
        return null;
    }
    
    /**
     * Returns the precedence of this operator
     */
    public int getPrecedence() {
        return precedence;
    }

}
