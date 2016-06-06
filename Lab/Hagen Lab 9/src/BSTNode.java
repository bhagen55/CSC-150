/**
 * Generic node for the BST.
 * 
 * @author Aaron Cass and Chris Fernandes
 * @version 5/25/16
 *
 * @param <Element> The kind of element that is stored. Must be comparable
 * to Elements.
 */
public class BSTNode<Element extends Comparable<Element>>
{
    public Element key;
    public BSTNode<Element> llink;
    public BSTNode<Element> rlink;

    /**
     * Constructs a BSTNode for the given key.  The new node will be a 
     * leaf node.
     */
    public BSTNode(Element key)
    {
        this.key = key;
        llink = null;
        rlink = null;
    }
}