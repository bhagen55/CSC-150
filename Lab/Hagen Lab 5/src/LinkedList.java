/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 * 
 * @author Blair Hagen
 * @version 4-28-2016
 * 
 * As a student at Union College, I am part of a community that values intellectual effort, curiosity and discovery. I understand that in order to truly claim my educational and academic achievements, I am obligated to act with academic integrity. Therefore, I affirm that I will carry out my academic endeavors with full academic honesty, and I rely on my fellow students to do the same.
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

    /** insert new Event at linked list's head
     * 
     * @param newData the Event to be inserted
     */
    public void insertAtHead(Event newData)
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
     * Removes the link node at the head of the list and returns it
     * If list is empty, returns null
     * 
     * @return headOfList object at head of the list
     * 		null if doesn't exist
     */
    public Event removeHead() {
    		if (firstNode == null)
    		{
    			return(null);
    		}
    		else
    		{
    			ListNode headOfList = firstNode;
    			if (firstNode.next != null)
    			{
    				firstNode = firstNode.next;
    			}
    			else
    			{
    				firstNode = null;
    			}
    			length--;
    			return(headOfList.data);
    		}	
    }
    
    /**
     * Insert link node at end of linked list
     * 
     * @param newEvent
     * 		The event for the added linked node to contain
     */
    public void insertAtTail(Event newEvent) {
    	ListNode runner = firstNode;
    	ListNode newNode = new ListNode(newEvent);
    	while(runner != null && runner.next != null)
    	{
    		runner = runner.next;
    	}
    	if (runner == null)
    	{
    		firstNode = newNode;
    		length++;
    	}
    	else
    	{
    		runner.next = newNode;
    		length++;
    	}
    }
    
    /**
     * Searches for an event based on its event name and returns the start time.
     * 
     * @param eventName
     * 		Name of event to be searched for
     * @return eventTime
     * 		Start time of found event, -1 if event does not exist
     */
    public int search(String eventName) {
    	ListNode runner = firstNode;

        while(runner != null && !runner.data.getName().equals(eventName))
        {
        	runner = runner.next;
        }
        if (runner == null)
        {
        	return(-1);
        }
        else
        {
        	return (runner.data.getStart());
        }
        
    	

    }
    
    /** Turn entire chain into a string
     *  
     *  @return return linked list as printable string
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
    			toReturn = toReturn + ",\n";
    		}
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /** getter for number of nodes in the linked list
     * 
     * @return length of LL
     */
    public int getLength() {return length;}
}