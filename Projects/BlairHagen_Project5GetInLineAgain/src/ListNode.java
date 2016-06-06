/**
 * Nodes used in linked list.
 * Stores data and a pointer to the next node.
 * 
 * @author Blair Hagen
 * @version 5-5-2016
 *
 */
public class ListNode {
	
	public String data;
	public ListNode next;
	
	/**
	 * Creates a node with given data
	 * (next node pointer is null)
	 * @param data
	 * 	data to store in node
	 */
	public ListNode(String data) {
		this.data = data;
	}
	
	/**
	 * Creates a node with given data and sets the
	 * next node with given node
	 * @param data
	 * 	data to store in node
	 * @next
	 *  node to point to
	 */
	public ListNode(String data, ListNode next) {
		this.data = data;
		this.next = next;
	}
}
