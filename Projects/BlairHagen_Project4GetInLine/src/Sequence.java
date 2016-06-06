
/**
 * A sequence of strings, which is a collection of strings arranged in a
 * particular order.
 * 
 * @author Blair Hagen
 * @version 4-28-2016
 */


public class Sequence {
	
	/**
	 * Invariants of Sequence class:
	 * 		1. The instance variable usedCapacity stores the number of elements in the sequence
	 * 		2. For a sequence with elements, the elements are stored from seqArray[0] to seqArray[usedCapacity-1]
	 * 			anything after that doesn't matter. For an empty sequence, data stored in the array doesn't matter
	 *      3. The instance variable currentIndex will store the index value of the current item in the array.
	 *      	If there is no current item, currentIndex will be set to -1 as this is not a valid index for the array.
	 */
	private String seqArray[];
	private int capacity;
	private String current;
	private int currentIndex;
	private int usedCapacity;
	
	private final int DEFAULT_CAPACITY = 10;
	
	/**
	 * Creates a new sequence with initial capacity 10.
	 */
	public Sequence() {
		seqArray = new String[DEFAULT_CAPACITY];
		capacity = seqArray.length;
		usedCapacity = 0;
		currentIndex = -1;
	}

	/**
	 * Creates a new sequence.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the bag.
	 */
	public Sequence(int initialCapacity) {
		seqArray = new String[initialCapacity];
		capacity = seqArray.length;
		usedCapacity = 0;
		currentIndex = -1;
	}
	
	/**
	 * Creates a new sequence with a given
	 * array for the sequence values and a given
	 * current value and array index value. Capacity is set to
	 * the length of the given array.
	 * 
	 * @param seqData
	 * 		array containing the values for the sequence
	 * 		length of this array determines capacity of sequence
	 * 		>Array must be larger than 0
	 * @param currentIndex
	 * 		index value in the seqData array that represents
	 * 		the current element
	 */
	public Sequence(String[] seqData, int currentIndex) {
		seqArray = seqData.clone();
		capacity = seqArray.length;
		this.currentIndex = currentIndex;
		if (currentIndex == -1)
		{
			current = null;
		}
		else
		{
			current = seqArray[currentIndex];
		}
		for (String item:seqArray)
		{
			if(item != null)
			{
				usedCapacity++;
			}
		}
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
			seqArray = expandCapacity(capacity * 2 + 1, seqArray);
		}
		String targetArray[] = seqArray.clone();
		// If sequence has no current element
		if (current == null)
		{
			for (int i = 0; i < usedCapacity; i++)
			{
				targetArray[i + 1] = seqArray[i];
			}
			targetArray[0] = value;
			currentIndex = 0;
		}
		// If sequence has a current element
		else
		{
			
			// Copy the first part of the array before the index to the new array
			for (int i = 0; i <= currentIndex; i++)
			{
				targetArray[i + 1] = seqArray[i];
			}
			// Copy the second part of the array one after the index to the new array
			for (int i = currentIndex + 1; i < usedCapacity + 1; i++)
			{
				targetArray[i] = seqArray[i-1];
			}
			targetArray[currentIndex] = value;
		}
		seqArray = targetArray.clone();
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
			seqArray = expandCapacity(capacity * 2 + 1, seqArray);
		}
		
		String targetArray[] = seqArray.clone();
		// If sequence has no current element
		if (current == null)
		{
			targetArray[usedCapacity] = value;
			currentIndex = usedCapacity;
		}
		// If sequence has a current element
		else
		{
			// Copy the first part of the array and the index to the new array
			for (int i = 0; i <= currentIndex; i++)
			{
				targetArray[i] = seqArray[i];
			}
			// Copy the second part of the array after the index to the new array
			for (int i = currentIndex + 1; i <= usedCapacity; i++)
			{
				targetArray[i] = seqArray[i - 1];
			}
			targetArray[currentIndex + 1] = value;
			currentIndex++;
		}
		seqArray = targetArray.clone();
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
		//System.out.println(addend.toString());
		if (addend.size() + usedCapacity > capacity)
		{
			seqArray = expandCapacity(usedCapacity + addend.size(), seqArray);
		}
		
		Sequence addendClone = addend.clone();
		addendClone.start();
		seqArray[usedCapacity] = addendClone.getCurrent();
		for (int i = 1; i < addendClone.size(); i++)
		{
			addendClone.advance();
			seqArray[i + usedCapacity] = addendClone.getCurrent();
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
		if(currentIndex > usedCapacity)
		{
			current = null;
			currentIndex = -1;
		}
		else
		{
			current = seqArray[currentIndex];
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
		Sequence copySeq = new Sequence(seqArray, currentIndex);
		return(copySeq);
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
		Sequence newSeq = new Sequence(s1.getCapacity() + s2.getCapacity());
		
		Sequence s1Clone = s1.clone();
		s1Clone.start();
		for (int i = 0; i < s1.size(); i++)
		{
			newSeq.addAfter(s1Clone.getCurrent());
			s1Clone.advance();
		}
		Sequence s2Clone = s2.clone();
		s2Clone.start();
		for (int i = 0; i < s2.size(); i++)
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
			seqArray = expandCapacity(minCapacity, seqArray);
		}
	}

	/**
	 * @return the capacity of the sequence.
	 */
	public int getCapacity() {
		return capacity;
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
		if (current != null)
		{
			return(true);
		}
		else
		{
			return(false);
		}
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
			// Copy the first part of the array before the index to the new array
			String[] targetArray = new String[capacity];
			for (int i = 0; i < currentIndex; i++)
			{
				targetArray[i] = seqArray[i];
			}
			// Copy the second part of the array one after the index to the new array
			for (int i = currentIndex; i < usedCapacity + 1; i++)
			{
				targetArray[i] = seqArray[i + 1];
			}
			seqArray = targetArray.clone();
			if (seqArray[currentIndex] == null)
			{
				current = null;
				currentIndex = -1;
			}
			else
			{
				current = seqArray[currentIndex];
			}
			usedCapacity--;
		}
	}

	/**
	 * @return the number of elements stored in the sequence.
	 */
	public int size() {
		return usedCapacity;
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
			current = seqArray[currentIndex];
		}
	}

	/**
	 * Reduce the current capacity to its actual size, so that it has capacity
	 * to store only the elements currently stored.
	 */
	public void trimToSize() {
		String fitArray[] = new String[usedCapacity];
		for (int i = 0; i < usedCapacity; i++)
		{
			fitArray[i] = seqArray[i];
		}
		seqArray = fitArray.clone();
		capacity = seqArray.length;
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
			strBuild.append(seqArray[i]);
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
		boolean isSame;
		if (usedCapacity == otherClone.size())
		{
			int  index = 0;
			while (seqArray[index] == otherClone.getCurrent() && index < usedCapacity)
			{
				otherClone.advance();
				index++;
			}
			
			if (index < usedCapacity)
			{
				return(false);
			}
			else
			{
				return(true);
			}
		}
		else
		{
			isSame = false;
		}
		return(isSame);	
	}
	
	/**
	 * Changes capacity of sequence to desired number without
	 * changing contained values
	 * @param capacity
	 * 		Desired capacity of array
	 */
	public String[] expandCapacity(int capacity, String[] array) {
		String biggerArray[] = new String[capacity];
		
		int index = 0;
		for (String item:array)
		{
			biggerArray[index] = item;
			index++;
		}
		array = biggerArray.clone();
		this.capacity = array.length;
		
		return(array);
	}
}