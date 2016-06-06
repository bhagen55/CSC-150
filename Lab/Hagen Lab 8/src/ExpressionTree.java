/**
 * ExpressionTree is a binary expression tree supporting the operators
 * +, -, *, and /.  Only 1-digit operands are allowed.
 * 
 * As a student at Union College, I am part of a community that values intellectual effort, curiosity and discovery. I understand that in order to truly claim my educational and academic achievements, I am obligated to act with academic integrity. Therefore, I affirm that I will carry out my academic endeavors with full academic honesty, and I rely on my fellow students to do the same.
 * 
 * @author Blair Hagen
 * @version 5/19/16
 */
public class ExpressionTree
{
    private TreeNode root;

    /**
     * Creates an expression tree out of the given prefix string
     */
    public ExpressionTree(String expression)
    {
        root = buildSubtree(new CharacterIterator(expression));
    }

    /**
     * Takes a prefix string (wrapped in a CharacterIterator)
     * and creates an expression tree out of the next operand it
     * sees (base case) or the next operator and two subsequent
     * operands it sees (recursive case).  It returns a pointer
     * to the newly-built subtree.
     *
     * @param input object that easily gets the next char in a String
     * @return a pointer to the root of the subtree it builds.
     */
    private TreeNode buildSubtree(CharacterIterator input)
    {
    	TreeNode n = new TreeNode(input.getNext());
    	if (n.value == '+' || n.value == '-' || n.value == '*' || n.value == '/') {
    		n.llink = buildSubtree(input);
    		n.rlink = buildSubtree(input);
    	}	
    	return n;
    }
    
    /**
     * Performs an inorder traversal, creating an infix version of the
     * expression.
     *
     * @param N the root of some subtree of an expression tree
     * @return the mathematical expression starting at 
     * node N in infix notation (fully parenthesized)  
     */
    private String infixString(TreeNode N)
    {
    	String result = "";
        if (N != null) {   
        	if (!N.isLeaf()) {
        		result += "(";
        	}

        	result += infixString(N.llink);
        	result += N.toString();
        	result += infixString(N.rlink);

        	if (!N.isLeaf()) {
        		result += ")";
        	}
        }
        return result;
    }
    
    /**
     * Performs an inorder traversal, creating an infix version of the
     * expression.
     *
     * @return a String with the mathematical expression in infix notation
     * (fully parenthesized)
     */
    public String infixString()
    {      
        return infixString(root);
    }
      
    /**
     * Performs a preorder traversal, creating a prefix version of the
     * expression.
     *
     * @param N the root of of some subtree of an expression tree
     * @return the mathematical expression starting at node N in prefix notation
     */
    private String prefixString(TreeNode N)
    {
    	String result = "";
        if (N != null) 
        {    
        	result += N.toString();
        	result += prefixString(N.llink);
        	result += prefixString(N.rlink);
        }
        return result;
    }
       
    /**
     * Performs a preorder traversal, creating a prefix version of the
     * expression.
     *
     * @return a String with the mathematical expression in prefix notation
     */
    public String prefixString() 
    {   
        return prefixString(root);
    }
}
