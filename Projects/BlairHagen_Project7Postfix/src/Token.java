/** 
 * Describes the methods that must be defined in order for an object
 * to be considered a token.  Every token must be able to be processed
 * (handle) printable (toString), and have a precedence value.
 * 
 * @author Chris Fernandes and modified by Blair Hagen
 * @version 5/19/16
 */
public interface Token
{
       
    /** 
     * Processes the current token.  Since every token will handle
     * itself in its own way, handling may involve pushing or popping
     * from the given stack and/or appending more tokens to the output
     * string.
     * 
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return String to be appended to the output
     */
    public String handle(Stack<Token> s);
    
    /** 
     * Returns the token as a printable String.
     * 
     * @return the String version of the token.  For example, ")" for
     * a right parenthesis.
     */
    public String toString();
    
    /**
     * Returns precedence of operator as int.
     * 
     * @return precedence of operator. Either 1, 2, 3, or -1 if operator 
     * is not a mathematical operator
     */
    public int getPrecedence();
}
