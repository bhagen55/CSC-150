/**
 * Building block for GenericLinkedList to store data
 * @author Blair Hagen
 * @version 5-12-2016
 *
 */
public class GenericListNode<T> {
	public T data;
	public GenericListNode<T> next;
	
	/**
	 * Non-default constructor
	 * 
	 * @param newData person/business to store in node
	 */
	public GenericListNode(T data) {
		this.data = data;
		this.next = null;
	}
	
	/** 
	 * Simple method to print contents of node
	 * @return string representation of node data
	 */
	public String toString() {
		return data.toString();
	}
}
