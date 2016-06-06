/**
 * Generic linked list for storing objects
 * 
 * @author Blair Hagen
 * @version 5-12-2016
 */
public class GenericLinkedList<T>{
	
	private int length;
	private GenericListNode<T> firstNode;
	
	/**
	 * Default constructor
	 * Creates empty list
	 */
	public GenericLinkedList() {
		length = 0;
		firstNode = null;
	}
	
	/**
	 * Getter for length
	 * @return length length of linkedlist
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Inserts new node at given index
	 * if list is empty, node is inserted at the head
	 * 
	 * @param toAdd
	 * @param index
	 */
	public void add(T toAdd, int index) {
		GenericListNode<T> newNode = new GenericListNode<T>(toAdd);
		if (length == 0)
		{
			firstNode = newNode;
		}
		else if (index == 0)
		{
			newNode.next = firstNode;
			firstNode = newNode;
		}
		else
		{
			GenericListNode<T> nodeBefore = search(index - 1);
			GenericListNode<T> nodeAfter = search(index);
			
			nodeBefore.next = newNode;
			newNode.next = nodeAfter;
		}
		length++;
	}
	
	/**
	 * removes node with given index and returns it
	 * 
	 * @param index node's index to be removed
	 * @return removed node data
	 */
	public T remove(int index) {
		GenericListNode<T> nodeBefore;
		GenericListNode<T> nodeAfter;
		GenericListNode<T> removeNode;
		
		if (index == 0)
		{
			nodeAfter = firstNode.next;
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
		length--;
		return(removeNode.data);
	}
	
	/**
	 * returns data in node with given index
	 * 
	 * @param index
	 * @return data of desired node
	 * 
	 * Prerequisite: list must not be empty!
	 */
	public T get(int index) {
		return(search(index).data);
	}
	
	/**
	 * Sets node with given index to given data
	 *  
	 * @param value
	 * @param index
	 */
	public void set(T value, int index) {
		GenericListNode<T> setNode = search(index);
		setNode.data = value;
	}

	/**
	 * Returns string representation of linked list
	 * 
	 * @return
	 */
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("{");
		
		GenericListNode<T> runner = firstNode;
		while (runner != null) 
		{
			strBuild.append(runner.toString());
			runner = runner.next;
			if (runner != null)
			{
				strBuild.append(", ");
			}
		}
		strBuild.append("}");
		return(strBuild.toString());
	}
	
	/**
	 * Private method that returns desired list node
	 * based on index
	 * 
	 * @param index
	 * @return listnode desired list node
	 * 
	 * prerequisite: LinkedList cannot be empty!
	 */
	private GenericListNode<T> search(int index) {
		GenericListNode<T> runner = firstNode;
		
		for (int i = 0; i < index; i++)
		{
			runner = runner.next;
		}
		return runner;
	}
	
	
   
}
