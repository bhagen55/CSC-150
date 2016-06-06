/**
 * Tester for your Heap
 * 
 * @author Blair Hagen and Chris Fernandes
 * @version 6/2/16
 *
 */
public class HeapTests {
	
	public static void main(String[] args) 
    {
        Testing.startTests();
        Testing.setVerbose(true);
		
        shallowHeap();
        largeHeap();
        heapedHeap();
        
        sortUnique();
        sortedDuplicates();
		
        Testing.finishTests();
    }
	
	/**
	 * given an array-based tree of integers, returns the contents of the
	 * tree in the same sort-of-tree-like format that Heap's toString does
	 * 
	 * @param someArray array-based tree of ints
	 * @return contents of tree in level-by-level order with \n's to make it tree-like
	 */
	private static String treeify(int[] someArray) {
		String result = "\n";
		int lastNodeOnLevel = 0;

		for (int i = 0; i < someArray.length-1; i++)
		{
			result += someArray[i];
			if (i == lastNodeOnLevel) {
				result += "\n";
				lastNodeOnLevel = lastNodeOnLevel * 2 + 2;
			} else {
				result += " ";
			}
		}
		result += someArray[someArray.length-1];
		return result;
	}
	
	private static void shallowHeap()
    {
    	Testing.testSection("shallow heap test: subtree root swaps just once,\n"
    			+ "unbalanced tree, all internal nodes have two kids");
	
    	int[] anArray = {11, 12, 5, 1, 23, 33, 9, 21, 14, 10, 4};	
        Testing.printArray("before building heap:",anArray);
	
        Heap sample = new Heap(anArray);
        int[] answer = {33,23,11,21,12,5,9,1,14,10,4};
        
    	Testing.assertEquals("after building heap",
    			treeify(answer), sample.toString());
    }
	
    private static void largeHeap()
    {
    	Testing.testSection("large head test: subtree root swaps multiple times,\n"
    			+ "unbalanced tree, all internal nodes have two kids");
    	
    	int[] anArray = {12, 13, 18, 9, 70, 1, 56, 25, 45, 14, 20, 30, 6, 4};
    	Testing.printArray("before building heap:", anArray);
    	
    	Heap sample = new Heap(anArray);
    	int[] answer = {70, 45, 56, 25, 20, 30, 18, 12, 9, 14, 13, 1, 6, 4};
    	
    	Testing.assertEquals("after building heap", treeify(answer), sample.toString());
    }
    
    private static void sortUnique()
    {
    	Testing.testSection("sort test: random, no duplicates");
	
    	int[] unsorted = {11, 12, 5, 1, 23, 33, 9, 21, 14, 10};
    	Testing.printArray("before sorting",unsorted);
        int[] sorted = Sorter.priorityQueueSort(unsorted);
        int[] answer = {1, 5, 9, 10, 11, 12, 14, 21, 23, 33};

        Testing.assertEquals("after sorting", answer, sorted);
    }
    
    private static void heapedHeap()
    {
    	Testing.testSection("already heapified heap");
    	
    	int[] unsorted = {70, 60, 50, 40, 30, 20, 10};
    	Testing.printArray("before building heap:", unsorted);
    	
    	Heap sample = new Heap(unsorted);
    	int[] answer = {70, 60, 50, 40, 30, 20, 10};
    	
    	Testing.assertEquals("after building heap", treeify(answer), sample.toString());
    }
    
    private static void sortedDuplicates()
    {
    	Testing.testSection("sorting a heap with duplicates sorted heap");
    	
    	int[] unsorted = {15, 15, 16, 18, 30, 15, 16, 30};
    	Testing.printArray("before sorting", unsorted);
    	int[] sorted = Sorter.priorityQueueSort(unsorted);
    	int[] answer = {15, 15, 15, 16, 16, 18, 30, 30};
    	
    	Testing.assertEquals("after sorting", answer, sorted);
    }
    

}
