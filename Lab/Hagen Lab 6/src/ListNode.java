/**
 * ListNode is a building block for a linked list of data items
 * 
 * This is the only class where I'll let you use public instance variables.
 * It's so we can reference information in the nodes using cascading dot
 * notation, like 
 *          N.next.data instead of 
 *          N.getNext().getData()
 * 
 * @author C. Fernandes and G. Marten
 * @version 5/4/2016
 */
public class ListNode
{
    public AgendaItem data;      // something to put on your calendar
    public ListNode next;   // pointer to next node
    
    /** Non-default constructor
     * 
     * @param newData a reservation you want stored in this node
     */
    public ListNode(AgendaItem newData)
    {
        this.data = newData;
        this.next = null;
    }
    
    // if you say "System.out.println(N)" where N is a ListNode, the
    // compiler will call this method automatically to print the contents
    // of the node.  It's the same as saying "System.out.println(N.toString())"
    public String toString()
    {
        return data.toString();  // call the toString() method in Event class
    }
}