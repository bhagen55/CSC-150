/**
 * Represents a Binary Search Tree that stores elements.
 * 
 * @author Aaron G. Cass and Chris Fernandes and Blair Hagen
 * @version 5/26/16
 * 
 * As a student at Union College, I am part of a community that values intellectual effort, curiosity and discovery. I understand that in order to truly claim my educational and academic achievements, I am obligated to act with academic integrity. Therefore, I affirm that I will carry out my academic endeavors with full academic honesty, and I rely on my fellow students to do the same.
 *
 * @param <Element> The kind of element that is stored. Must be comparable
 * to Elements.
 */
public class BST<Element extends Comparable<Element>> 
{
    private BSTNode<Element> root;

    /**
     * Constructs an empty Binary Search Tree.
     */
    public BST()
    {
        root = null;
    }

    /**
     * Searches for an element in the tree.
     * 
     * @param toFind
     *            the element to search for
     * @return true iff the element is in the tree
     */
    public boolean search(Element toFind)
    {
        return search(root, toFind);
    }

    /**
     * Searches for an element in a subtree of the tree.
     * 
     * @param subtreeRoot
     *            the root of the subtree in which to search
     * @param toFind
     *            the element to search for
     * @return true iff the element is in the give subtree
     */
    private boolean search(BSTNode<Element> subtreeRoot, Element toFind)
    {
    	if (subtreeRoot == null) {
            return false;
        } else if (subtreeRoot.key.compareTo(toFind) == 0) {
            return true;
        } else if (subtreeRoot.key.compareTo(toFind) > 0) {
            return search(subtreeRoot.llink, toFind);
        } else {
            return search(subtreeRoot.rlink, toFind);
        }
    }
    
    /**
     * Adds an element to the tree.
     * 
     * 
     * @param toAdd
     *            the element to add.
     */
    public void add(Element toAdd) 
    {
    	BSTNode<Element> newNode = new BSTNode<Element>(toAdd);
    	root = add(root, newNode);
    }

    /** 
     * Adds newNode to the subtree that subtreeRoot points at. 
     * After the new node is added to the tree, the method
     * returns the root of the subtree.
     * 
     * Recursive defn of a binary search tree: A binary tree is either an empty tree or a single
     * node that points to one or two nodes.
     * 
     * BASE CASE: GET TO AN EMPTY TREE
	 * PSEUDOCODE:
     * to return a pointer to a tree with newNode at the end, you either:
     * return newNode if the subtreeRoot points to an empty tree OR
     * return subtreeRoot, whose next pointer points to a Tree where newNode is inserted
     * at the end.
     * 
     * 
     * @param subtreeRoot 
     * 					the root of the subtree to which to add.  If
     *            		null, the subtree is empty
     * @param newNode 
     * 					the node to add to the subtree.
     * @return the root of the subtree after newNode has been added.
     */
    private BSTNode<Element> add(BSTNode<Element> subtreeRoot, BSTNode<Element> newNode) 
    {
    	if (subtreeRoot == null) {
    		return newNode;
    	} 
    	else if (newNode.key.compareTo(subtreeRoot.key) <= 0){
    		subtreeRoot.llink = add(subtreeRoot.llink, newNode) ;
    		return subtreeRoot;
    	}
    	else {
    		subtreeRoot.rlink = add(subtreeRoot.rlink, newNode);
    		return subtreeRoot;
    	}
    }

}