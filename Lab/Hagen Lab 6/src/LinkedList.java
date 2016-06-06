/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 * 
 * As a student at Union College, I am part of a community that values intellectual effort, curiosity and discovery. I understand that in order to truly claim my educational and academic achievements, I am obligated to act with academic integrity. Therefore, I affirm that I will carry out my academic endeavors with full academic honesty, and I rely on my fellow students to do the same.
 * 
 * @author Blair Hagen
 * @version 5-5-2016
 */
public class LinkedList
{
    private int length;         // number of nodes
    private ListNode firstNode; // pointer to first node
    
    public LinkedList()
    {
        length=0;
        firstNode=null;
    }
    
    /** getter
     * 
     * @return number of nodes in the list
     */
    public int getLength() {return length;}
    
    
    /** insert new Event at linked list's head
     * 
     * @param newData the Event to be inserted
     */
    public void insertAtHead(AgendaItem newData)
    {
    	ListNode newnode = new ListNode(newData);
        if (getLength() == 0)
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
  
    /**
     * @return a string representation of the list and its contents.
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode runner;
    	runner = firstNode;
    	while (runner != null) {
            toReturn = toReturn + runner;
            runner = runner.next;
            if (runner != null) {
                toReturn = toReturn + ",\n";
            }
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /**
     * insert new Event into sorted position in LL
     *
     * @param newData the Event to insert
     */
    public void insertSorted(AgendaItem newData)
    {
        ListNode nodeBefore = this.findNodeBefore(newData);
        if (nodeBefore == null) {
            insertAtHead(newData);
        }
        else {
            insertAfter(nodeBefore, newData);
        }
    }

    /**
     * Given a new event to be inserted in the list, finds the correct position for it.
     *
     * @param newData an event to be inserted in the list
     *
     * @return a pointer to the node in the linked list that will
     * immediately precede newData once newData gets inserted.
     * Returns null if no such node exists (which means newData goes first).
     */
    private ListNode findNodeBefore(AgendaItem newData)
    {
    	if (getLength() == 0)
    	{
    		return(null);
    	}
    	else
    	{
    		ListNode runner = firstNode;
    		if (runner.data.compareTo(newData) == 1)
    		{
    			return(null);
    		}
    		else
    		{
    			while (runner.next != null && runner.next.data.compareTo(newData) == -1)
    			{
    				runner = runner.next;
    			}
    			while (runner.next != null && runner.next.data.compareTo(newData) == 0)
    			{
    				runner = runner.next;
    			}	
    			return(runner);
    		}
    	}
    }
    

    /**
     * Given an event to insert and a pointer to the node
     * that should come before it, insert the new event after nodeBefore.
     * Precondition: length >= 1
     *
     * @param nodeBefore the node (already in the list) that should
     * immediately precede the node with newData in it
     * @param newData the event to be inserted after nodeBefore
     */
    private void insertAfter (ListNode nodeBefore, AgendaItem newData)
    {
    	ListNode newNode = new ListNode(newData);
    	
    	ListNode runner = firstNode;
    	while (!runner.equals(nodeBefore))
    	{
    		runner = runner.next;
    	}
    	newNode.next = runner.next;
    	runner.next = newNode;
    	
    	length++;
    }
 }
