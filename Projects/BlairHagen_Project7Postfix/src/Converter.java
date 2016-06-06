/**
 * Takes a text file containing prefix operations
 * and converts it to postfix
 * 
 * @author Blair Hagen
 *
 */
public class Converter {
    
    private Stack<Token> stack;
    
    private FileReader reader;
    
    StringBuilder strBuild;
    StringBuilder prefixBuild;
    
    /**
     * Non-default constructor
     * 
     * @param fileName file to be processed
     */
    public Converter(String fileName) {
        stack = new Stack<Token>();
        reader = new FileReader(fileName);
        
        strBuild = new StringBuilder();
        
        prefixBuild = new StringBuilder();
    }
    
    /**
     * Performs the necessary operations
     * to convert infix to postfix.
     * 
     * If token is operand, appends string to output string
     * if token is operator and not a semicolon, calls the tokens handle method and 
     * appends whatever that returns to output string
     * if token is semicolon, prints postfix string to console 
     */
    public void convert() {
        
        Plus plus;
        Minus minus;
        Times times;
        Divide divide;
        Exponent exponent;
        LeftParen leftparen;
        RightParen rightparen;
        Semicolon semicolon;
        
        
        String token = reader.nextToken();
        while (!token.equals("EOF"))
        {
            if (!token.equals(";")) {
                prefixBuild.append(token); 
            }
            
            if (token.matches("[A-Z]")) {
                strBuild.append(token);
                token = reader.nextToken();
            }
            else {
                switch (token) {
                    case "+":   plus = new Plus();
                                manageHandle(plus.handle(stack));
                                break;
                    case "-":   minus = new Minus();
                                manageHandle(minus.handle(stack));
                                break;
                    case "*":   times = new Times();
                                manageHandle(times.handle(stack));
                                break;
                    case "/":   divide = new Divide();
                                manageHandle(divide.handle(stack));
                                break;
                    case "^":   exponent = new Exponent();
                                manageHandle(exponent.handle(stack));
                                break;
                    case "(":   leftparen = new LeftParen();
                                manageHandle(leftparen.handle(stack));
                                break;
                    case ")":   rightparen = new RightParen();
                                strBuild.append(rightparen.handle(stack));
                                break;
                    case ";":   semicolon = new Semicolon();
                                strBuild.append(semicolon.handle(stack));
                                System.out.println(prefixBuild.toString() + " --> " + strBuild.toString());
                                strBuild = new StringBuilder();
                                prefixBuild = new StringBuilder();
                                break;
                }
                token = reader.nextToken();
            }   
        }  
    }
    
    /**
     * Used to clean up switch case in convert method
     * Appends the string value to the postfix string
     * if it isnt null
     * @param s string to append
     */
    private void manageHandle(String s) {
        if (s != null)
        {
            strBuild.append(s);
        }
    }
}
