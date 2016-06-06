/**
 * 
 * @author Blair Hagen
 * @version 5-22-16
 *
 *
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BSTNode<T> head;
	
	/**
	 * Default constructor
	 * Creates empty search tree
	 */
	public BinarySearchTree() {
		head = null;
	}
	/**
	 * Finds first node in search tree with matching data
	 * and returns the data
	 * @param toFind data to match
	 * @return 
	 */
	public T find(T toFind) {
		return find(toFind, head).data;
	}
	/**
	 * Recursive method for searching binary tree
	 * @param toFind data to match
	 * @param head tree node to start at
	 * @return data if found, null if not
	 */
	private BSTNode<T> find(T toFind, BSTNode<T> head) {
		if (head == null) {
			return null;
		} else if (head.data.compareTo(toFind) == 0) {
			return head;
		} else if (head.data.compareTo(toFind) > 0) {
			return find(toFind, head.left);
		} else {
			return find(toFind, head.right);
		}
	}
	
	/**
	 * Adds an element to the binary search tree
	 * 
	 * @param toAdd
	 */
	public void add(T toAdd) {
		BSTNode<T> newNode = new BSTNode<T>(toAdd);
		head = add(head, newNode);
	}
	
	/**
	 * Adds a newNode to subtree that subtreeRoot points to.
	 * Returns the root of the subtree that has the newNode attached
	 * in the proper place to it.
	 * 
	 * @param subtreeRoot root of subtree to add into
	 * @param newNode the node to add to the subtree
	 * @return the root of the subtree after nenode has been added
	 */
	private BSTNode<T> add(BSTNode<T> subtreeRoot, BSTNode<T> newNode) {
		if (subtreeRoot == null) {
			return newNode;
		}
		else if (newNode.data.compareTo(subtreeRoot.data) <= 0) {
			subtreeRoot.left = add(subtreeRoot.left, newNode);
			return subtreeRoot;
		}
		else {
			subtreeRoot.right = add(subtreeRoot.right, newNode);
			return subtreeRoot;
		}
	}
	
	/**
	 * Removes desired element from tree.
	 * If element does not exist, does nothing.
	 * 
	 * @param toRemove element to remove
	 */
	public void remove(T toRemove) {
		remove(toRemove, head);
	}
	
	/**
	 * Recursive method for removing element from tree
	 * 
	 * @param toRemove element to remove
	 * @param head start of tree to start removal at
	 */
	private void remove(T toRemove, BSTNode<T> head) {
		BSTNode<T> remove = find(toRemove, head);
		if (remove != null) {
			if (remove.data.compareTo(toRemove) == 0) {
				System.out.println("removing head");
				remove = null;
			}
			else if (remove.left == null) {
				remove = remove.left;
			}
			else {
				remove = traverseRight(remove.left);
			}
		}
	}
	
	private BSTNode<T> findBefore(T toFind, BSTNode<T> head) {
		if (head.data.compareTo(toFind) == 0) {
			return null;
		} else if (head.right.data.compareTo(toFind) == 0 || head.left.data.compareTo(toFind) == 0) {
			return head;
		} else if (head.){
			return findBefore(toFind, head.right);
		}
	}
	
	private BSTNode<T> traverseRight(BSTNode<T> startNode) {
		if (startNode.right != null)
		{
			return startNode.right;
		}
		else {
			return startNode;
		}
	}
	
	/**
	 * Returns the tree as a string of in order elements
	 * 
	 * @return in order string representation
	 */
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(infixString(head));
		if(strBuild.length() > 0) {
			strBuild.setLength(strBuild.length() - 1);
		}
        return(strBuild.toString());
	}
	
	/**
	 * Recursive method for producing the in order tree string
	 * @param head head of tree to recurse through
	 * @return in order string representation
	 */
	private String infixString(BSTNode<T> head) {
		StringBuilder strBuild = new StringBuilder();
        if (head != null) {
        	strBuild.append(infixString(head.left));
        	strBuild.append(head.toString());
        	strBuild.append("\n");
        	strBuild.append(infixString(head.right));
        }
        
        return strBuild.toString();
	}
	
	/**
	 * Returns the tree as a prefix representation
	 * 
	 * @return prefix representation of tree
	 */
	public String showTree() {
		return prefixTreeString(head);
	}
	
	/**
	 * Recursive method for producing the prefix representation
	 * @param head head of tree to recurse through
	 * @return in order string representation
	 */
    private String prefixTreeString(BSTNode<T> head)
    {
    	StringBuilder strBuild = new StringBuilder();
        if (head != null) {
        	strBuild.append("(");
        	strBuild.append(head.toString() + " ");
        	strBuild.append(prefixTreeString(head.left) + " ");
        	strBuild.append(prefixTreeString(head.right) + ")");
        }
        else {
        	strBuild.append("-");
        }
        return strBuild.toString();
    }
}
