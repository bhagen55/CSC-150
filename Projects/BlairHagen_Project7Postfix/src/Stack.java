/**
 * Stores items in a stack format with
 * last in/first out format. Items can only be added
 * and removed from the top of the stack.
 * 
 * @author Blair Hagen
 * @version 5-19-2016
 *
 * @param <T> type of item to store in stack
 */
public class Stack<T> {

    /**
     * Invariants of Stack class:
     *  1. The instance variable length will
     *   store the number of elements in the stack
     *  2. The stack is stored using a linkedList
     */
    
    private int length;
    
    private GenericLinkedList<T> storeList; //Main linked list to store stack data
    
    /**
     * Default constructor
     * 
     * Creates an empty linked list
     */
    public Stack() {
        storeList = new GenericLinkedList<T>();
        
        length = 0;
    }

    /**
     * Adds item to top of stack
     * 
     * @param toPush item to add to top of stack
     */
    public void push(T toPush) {
        storeList.add(toPush, 0);
        length++;
    }

    /**
     * Removes item from top of stack
     * 
     * @return removed item
     */
    public T pop() {
        T returnData = null;
        if (storeList.getLength() != 0)
        {
            returnData = storeList.remove(0);
            length--;
        }
        return(returnData);
    }

    /**
     * Shows next item in stack, does not modify stack
     * 
     * @return next item data in stack
     */
    public T peek() {
        T returnData = null;
        int length = storeList.getLength();
        
        if (length > 0)
        {
            returnData = storeList.get(0);
        }
        return(returnData);
    }
    
    /**
     * Creates string representation of stack
     * 
     * @return string representation of stack
     */
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("{>");

        for (int i = 0; i < length; i++)
        {
            strBuild.append(storeList.get(i).toString());
            if (i != length - 1)
            {
                strBuild.append(",");
            }
        }
        strBuild.append("}");
        return(strBuild.toString());
    }
    
    /**
     * Getter for stack length
     * 
     * @return length
     */
    public int getLength() {
        return(length);
    }
}
