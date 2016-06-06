/**
 * Nodes to be used in a binary search tree
 * Stores data as well as a link to the right and left node
 * @author Blair Hagen
 * @version 5-22-16
 *
 */
public class BSTNode<T> {
	
	public T data;
	
	public BSTNode<T> right;
	public BSTNode<T> left;
	
	/**
	 * Non-default constructor
	 * 
	 * @param data data to store in node
	 */
	public BSTNode(T data) {
		this.data = data;
	}
	
	/**
	 * Simple method to return data in node
	 * as a string using data's toString method
	 * @return string representation of node data
	 */
	public String toString() {
		return data.toString();
	}

}
