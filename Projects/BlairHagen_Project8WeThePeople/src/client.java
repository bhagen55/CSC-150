
public class client {

	public static void main(String[] args) {
		
		
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		tree.add("K");
        tree.add("D");
        tree.add("R");
        tree.add("B");
        tree.add("Z");
        System.out.println("TreeString: " + tree.toString());
        System.out.println("Should be \nB\nD\nK\nR\nZ");
		
        System.out.println("\nShow String: " + tree.showTree());
        System.out.println("Should be (K (D (B - -) -) (R - (Z - -)))");
        
        
	}

}
