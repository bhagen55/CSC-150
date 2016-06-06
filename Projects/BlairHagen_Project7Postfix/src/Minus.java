/**
 * Class representing a minus sign
 * 
 * @author Blair Hagen
 * @version 5-19-2016
 *
 */
public class Minus implements Token {

    private String toString;
    private int precedence;
    private StringBuilder strBuild;
    
    private final int DEFAULT_PRECEDENCE = 1; //precedence of this sign in relation to other operators
    private final String DEFAULT_STRING = "-";
    
    /**
     * Default Constructor
     * sets string and precedence to default values of - and 1
     */
    public Minus() {
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
        while (s.getLength() > 0 && !s.peek().toString().equals("(") && s.peek().getPrecedence() >= precedence) {
            strBuild.append(s.pop().toString());
        }
        s.push(this);
        return strBuild.toString();
    }
    
    /**
     * Returns the precedence of this operator
     */
    public int getPrecedence() {
        return precedence;
    }

}
