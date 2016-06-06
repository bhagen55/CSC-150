
/**
 * A sequence of strings, which is a collection of strings arranged in a
 * particular order.
 * 
 * @author Blair Hagen
 * @version 5-5-2016
 */


public class Sequence {

	
	/**
	 * Invariants of Sequence class:
	 * 	1. The instance variable usedCapacity stores the number of elements in the sequence
	 *  2. For a sequence with elements the elements are stored in a linked list
	 *  3. The instance variable currentIndex will store the index value of the current
	 *  	node in the linked list. If there is no current item, currentIndex will be set
	 *  	to -1.
	 *  4. The linked list will not have empty list nodes so data will be stored
	 *  	between index values 0 and usedCapacity - 1 in the linked list. 
	 */
	private LinkedList seqList;
	private int capacity;
	private String current;
	private int currentIndex;
	private int usedCapacity;
	
	private final int DEFAULT_CAPACITY = 10;
	
	/**
	 * Creates a new sequence with initial capacity 10.
	 */
	public Sequence() {
		seqList = new LinkedList();
		capacity = DEFAULT_CAPACITY;
		usedCapacity = seqList.size();
		currentIndex = -1;
	}

	/**
	 * Creates a new sequence.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the bag.
	 */
	public Sequence(int initialCapacity) {
		seqList = new LinkedList();
		capacity = initialCapacity;
		usedCapacity = seqList.size();
		currentIndex = -1;
	}


	/**
	 * Adds a string to the sequence in the location before the current element.
	 * If the sequence has no current element, the string is added to the
	 * beginning of the sequence.
	 * 
	 * The added element becomes the current element.
	 * 
	 * If the sequences's capacity has been reached, the sequence will expand to
	 * twice its current capacity plus 1.
	 * 
	 * @param value
	 *            the string to add.
	 */
	public void addBefore(String value) {
		if (usedCapacity == capacity)
		{
			capacity = capacity * 2 + 1;
		}
		
		if (current == null)
		{
			seqList.add(value, 0);
			currentIndex = 0;
		} 
		else
		{
			seqList.add(value, currentIndex);
		}
		current = value;
		usedCapacity++;

	}

	/**
	 * Adds a string to the sequence in the location after the current element.
	 * If the sequence has no current element, the string is added to the end of
	 * the sequence.
	 * 
	 * The added element becomes the current element.
	 * 
	 * If the sequences's capacity has been reached, the sequence will expand to
	 * twice its current capacity plus 1.
	 * 
	 * @param value
	 *            the string to add.
	 */
	public void addAfter(String value) {
		if (usedCapacity == capacity)
		{
			capacity = capacity * 2 + 1;
		}
		
		if (current == null)
		{
			seqList.add(value, 0);
			currentIndex = 0;
		}
		else
		{
			seqList.add(value, currentIndex + 1);
			currentIndex++;
		}
		current = value;
		usedCapacity++;
	}

	/**
	 * Places the contents of another sequence at the end of this sequence.
	 * 
	 * If adding all elements of the other sequence would exceed the capacity of
	 * this sequence, the capacity is changed to make room for all of the
	 * elements to be added. The current element should not change.
	 * 
	 * @param addend
	 *            the sequence whose contents should be added.
	 */
	public void addAll(Sequence addend) {
		if (usedCapacity + addend.size() > capacity)
		{
			capacity = capacity + addend.size();
		}
		
		
		Sequence addendClone = addend.clone();
		addendClone.start();
		
		for (int i = 0; i < addendClone.size(); i++)
		{
			seqList.add(addendClone.getCurrent(), usedCapacity + i);
			addendClone.advance();
		}
		usedCapacity = usedCapacity + addendClone.size();
	}

	/**
	 * Move forward in the sequence so that the current element is now the next
	 * element in the sequence.
	 * 
	 * If the current element was already the end of the sequence, then
	 * advancing causes there to be no current element.
	 * 
	 * Precondition: should only be called when there is a current element.
	 */
	public void advance() {
		currentIndex++;
		if (currentIndex == usedCapacity)
		{
			current = null;
			currentIndex = -1;
		}
		else
		{
			current = seqList.get(currentIndex);
		}
	}

	/**
	 * Make a copy of this sequence. Subsequence changes to the copy do not
	 * affect the current sequence, and vice versa.
	 * 
	 * The copy should look exactly the same as the original, including the
	 * capacity and the current element.
	 * 
	 * @return the copy of this sequence.
	 */
	public Sequence clone() {
		Sequence newSeq = new Sequence();
		for (int i = 0; i < usedCapacity; i++)
		{
			newSeq.addAfter(seqList.get(i));
		}
		newSeq.start();
		for (int i = 0; i < currentIndex; i++)
		{
			newSeq.advance();
		}
		return(newSeq);
		
	}

	/**
	 * Create a new sequence that contains all of the elements of one sequence
	 * followed by all of the elements of another sequence.
	 * 
	 * The new sequence does not have a current element. The new sequence has
	 * capacity equal to the sum of the capacities of the sequences being
	 * concatenated.
	 * 
	 * @param s1
	 *            the sequence whose elements should come first in the
	 *            concatenation
	 * @param s2
	 *            the sequence whose elements should come second
	 */
	public static Sequence concatenation(Sequence s1, Sequence s2) {
		Sequence newSeq = new Sequence();
		newSeq.ensureCapacity(s1.getCapacity() + s2.getCapacity());
		newSeq.start();
		Sequence s1Clone = s1.clone();
		Sequence s2Clone = s2.clone();
		s1Clone.start();
		s2Clone.start();
		
		for (int i = 0; i < s1Clone.size(); i++)
		{
			newSeq.addAfter(s1Clone.getCurrent());
			s1Clone.advance();
		}
		for (int i = 0; i < s2Clone.size(); i++)
		{
			newSeq.addAfter(s2Clone.getCurrent());
			s2Clone.advance();
		}
		newSeq.advance();
		return(newSeq);
	}

	/**
	 * Change the current capacity of this sequence. The sequence's capacity
	 * will be changed to be at least a minimum capacity.
	 * 
	 * @param minCapacity
	 *            the minimum capacity that the sequence should now have.
	 */
	public void ensureCapacity(int minCapacity) {
		if (minCapacity > capacity)
		{
			capacity = minCapacity;
		}	
	}

	/**
	 * @return the capacity of the sequence.
	 */
	public int getCapacity() {
		return(capacity);
	}

	/**
	 * @return the element at the current location in the sequence, or null if
	 *         there is no current element.
	 */
	public String getCurrent() {
		return current;
	}

	/**
	 * @return true if and only if the sequence has a current element.
	 */
	public boolean isCurrent() {
		return(current != null);
	}
	
	/**
	 * Remove the current element from this sequence. The following element, if
	 * there was one, becomes the current element. If there was no following
	 * element (current was at the end of the sequence), the sequence now has no
	 * current element.
	 * 
	 * If there is no current element, does nothing.
	 */
	public void removeCurrent() {
		if (current != null)
		{
			seqList.remove(currentIndex);
		}
		if (currentIndex == usedCapacity)
		{
			current = null;
			currentIndex = -1;
		}
		usedCapacity--;
	}

	/**
	 * @return the number of elements stored in the sequence.
	 */
	public int size() {
		return(usedCapacity);
	}

	/**
	 * Sets the current element to the start of the sequence. If the sequence is
	 * empty, the sequence has no current element.
	 */
	public void start() {
		if (usedCapacity == 0)
		{
			current = null;
		}
		else
		{
			currentIndex = 0;
			current = seqList.get(currentIndex);
		}

	}

	/**
	 * Reduce the current capacity to its actual size, so that it has capacity
	 * to store only the elements currently stored.
	 */
	public void trimToSize() {
		capacity = usedCapacity;
	}

	/**
	 * Produce a string representation of this sequence. The current location is
	 * indicated by a >. For example, a sequence with "A" followed by "B", where
	 * "B" is the current element, and the capacity is 5, would print as:
	 * 
	 * {A, >B} (capacity = 5)
	 * 
	 * An empty sequence with a capacity of 10 would print as:
	 * 
	 * {} (capacity = 10)
	 * 
	 * @return a string representation of this sequence.
	 */
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("{");
		for (int i = 0; i < usedCapacity; i++)
		{
			if (i == currentIndex)
			{
				strBuild.append(">");
			}
			strBuild.append(seqList.get(i));
			if (i != usedCapacity - 1)
			{
				strBuild.append(", ");
			}
		}
		strBuild.append("} " + "(capacity = " + capacity + ")");
		String returnStr = strBuild.toString();
		return(returnStr);
	}

	/**
	 * Checks whether another sequence is equal to this one. To be considered
	 * equal, the other sequence must have the same elements, in the same order,
	 * and with the same element marked as current. The capacity can differ.
	 * 
	 * @param other
	 *            the other Sequence with which to compare
	 * @return true iff the other sequence is equal to this one.
	 */
	public boolean equals(Sequence other) {
		Sequence otherClone = other.clone();
		otherClone.start();

		if (seqList.size() == 0)
		{
			return (seqList.size() == 0 && otherClone.size() == 0);
		}
		else if (usedCapacity == otherClone.size())
		{
			int index = 0;
			while (index < usedCapacity && seqList.get(index) == otherClone.getCurrent())
			{
				otherClone.advance();
				index++;
			}
			Boolean returnVal = (index < usedCapacity);
			return(!returnVal);
		}
		else
		{
			return (false);
		}
	}

}