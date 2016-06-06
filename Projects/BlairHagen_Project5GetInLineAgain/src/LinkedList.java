/**
 * A collection of linked data nodes forming a linked list.
 * 
 * @author Blair Hagen
 * @version 5-5-2016
 *
 */
public class LinkedList {
	
	private int length;
	private ListNode firstNode;
	
	/**
	 * Default constructor, creates an empty list
	 */
	public void linkedList() {
		length = 0;
		firstNode = null;
	}
	
	/**
	 * Returns number of elements in list
	 * @return size
	 * 		Number of elements in list
	 */
	public int size() {
		return(length);
	}
	
	/**
	 * Returns string contained in node with given index
	 * @return string
	 * 		String contained in node
	 */
	public String get(int index) {
		ListNode desNode = search(index);
		return(desNode.data);
	}
	
	/**
	 * Sets the data within the node at index to given string
	 * @param value
	 * 	Desired string for the node to contain
	 * @param index
	 * 	Index of node to change
	 */
	public void set(String value, int index) {
		ListNode desNode = search(index);
		desNode.data = value;
	}
	
	/**
	 * Inserts node with given data into list at given index
	 * @param value
	 *  Desired string for the node to contain
	 * @param index
	 *  Index of where to put node
	 */
	public void add(String value, int index) {
		ListNode newNode = new ListNode(value);
		ListNode nodeBefore;
		ListNode nodeAfter;
		if (index != 0)
		{
			nodeBefore = search(index - 1);
			nodeAfter = search(index);
	
			nodeBefore.next = newNode;
			newNode.next = nodeAfter;
		}
		else
		{
			if (length == 0)
			{
				firstNode = newNode;
			}
			else
			{
				nodeAfter = firstNode;
				firstNode = newNode;
				firstNode.next = nodeAfter;
			}
		}
		length++;
	}
	
	/**
	 * Removes node at given index and returns its data
	 * @param index
	 * 		Node index to remove
	 * @return returnString
	 * 		Data of removed node
	 * 
	 * Prerequisite:
	 * 		There must be at least one item in the list
	 */
	public String remove(int index) {
		ListNode nodeBefore;
		ListNode nodeAfter;
		ListNode removeNode;
		
		if (index == 0)
		{
			nodeAfter = search(index + 1);
			removeNode = firstNode;
			firstNode = nodeAfter;
		}
		else
		{
			nodeBefore = search(index - 1);
			nodeAfter = search(index + 1);
			removeNode = search(index);
			nodeBefore.next = nodeAfter;
		}
		String returnString = removeNode.data;

		length--;
		
		return(returnString);
	}
	
	/**
	 * Returns string representation of linked list
	 * @return string
	 * 		String representation of linked list
	 */
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("{");
		
		ListNode runner = firstNode;
		for (int i = 0; i < length; i++)
		{
			strBuild.append(runner.data);
			if (i < length - 1)
			{
				strBuild.append(", ");
			}
			runner = runner.next;
		}
		strBuild.append("}");
		String returnStr = strBuild.toString();
		return(returnStr);
	}
	
	/**
	 * Returns list node at desired index
	 * @param index
	 * 	index of desired list node
	 * @return searchNode
	 * 	desired list node
	 * 	
	 * Prerequisites:
	 * 	Linked List must have at least one node
	 */
	private ListNode search(int searchIndex) {
		ListNode runner = firstNode;
		
		for (int i = 0; i < searchIndex; i++)
		{
			runner = runner.next;
		}
		return(runner);
	}
}
