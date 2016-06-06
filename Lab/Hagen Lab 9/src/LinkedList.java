/**
 * The linked list class gives you access to the beginning of a linked
 * list through a private instance variable called firstNode.  This class
 * should contain all of the methods for general manipulation of linked lists:
 * traversal, insertion, deletion, searching, etc.
 * 
 * @author Chris Fernandes and Blair Hagen
 * @version 5/26/16
 */
public class LinkedList
{
	private int length;          // number of nodes
	private ListNode firstNode;  // pointer to first node

	public LinkedList()
	{
		length=0;
		firstNode=null;
	}

	/** insert newNode at end of the LL that begins at startOfSublist
	 * 
	 * BASE CASE: FIND THE LAST NODE
	 * PSEUDOCODE:
	 * To insert newNode at the tail of the LL, you either:
	 * assign newNode to startOfSublist.next if startOfSublist points to last node OR
	 * insert newNode at the tail of the LL that starts at startOfSublist.next
	 * 
	 * @param startOfSublist 
	 * 					pointer to start of list that newNode should be inserted into
	 * @param newNode 
	 * 					node to insert
	 */
	private void insertAtTailPast(ListNode startOfSublist, ListNode newNode) 
	{
		if (startOfSublist.next == null) {
			startOfSublist.next = newNode;
		}
		else {
			insertAtTailPast(startOfSublist.next,newNode);
		}    	
	}

	/** insert new data at end of list
	 * 
	 * @param newData int to insert
	 */
	public void insertAtTailPast(int newData) {
		ListNode newNode = new ListNode(newData);
		if (getLength() == 0) {
			firstNode=newNode;
		}
		else {
			insertAtTailPast(firstNode,newNode);
		}
		length++;
	}

	/**
	 * insert newNode at end of the LL that begins at startOfSublist
	 * When done, return a pointer to the head of this linked list
	 * 
	 * Recursive defn of a linked list: an LL is either an empty list OR
	 * a single node that points to an LL
	 * 
	 * BASE CASE: GET TO AN EMPTY LIST
	 * PSEUDOCODE:
	 * To return a pointer to an LL where newNode is inserted at the end, you either:
	 * return newNode, if startOfSublist points to an empty list OR
	 * return startOfSublist, whose next pointer now points at an LL where newNode
	 * is inserted at the end
	 * 
	 * @param startOfSublist pointer to LL in which to insert
	 * @param newNode the new node to insert
	 * @return a pointer to a linked list where newNode has been inserted at the end
	 */
	private ListNode insertAtTail(ListNode startOfSublist, ListNode newNode) 
	{
		if (startOfSublist == null) {
			return newNode;
		}
		else {
			startOfSublist.next = insertAtTail(startOfSublist.next, newNode);
			return startOfSublist;
		}
	}
	
	/** insert new data at end of list (DO NOT ALTER THIS METHOD)
	 * 
	 * @param newData int to insert
	 */
	public void insertAtTail(int newData) {
		ListNode newNode = new ListNode(newData);
		firstNode = insertAtTail(firstNode,newNode);
		length++;
	}
	
	/** return linked list as printable string
	 * 
	 */
	public String toString() 
	{
		String toReturn="(";
		ListNode runner;
		runner=firstNode;
		while (runner!=null)
		{
			toReturn = toReturn + runner;  //call node's toString automatically
			runner=runner.next;
			if (runner!=null)
			{
				toReturn = toReturn + ", ";
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}

	/**
	 * getter
	 * 
	 * @return number of nodes in LL
	 */
	public int getLength() { return length; }
}