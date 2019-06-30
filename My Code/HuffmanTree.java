import java.util.Iterator;


/**
 * HuffmanTree extends LinkedBinaryTree and implements Comparable interface
 * This program constructs a Huffman tree 
 * @author Wafiq Syed 
 * @author student no. 250868594
 */
public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree>{


	
	/**
	 * First constructor
	 * Creates an empty Huffman tree by using constructor of superclass
	 */
	public HuffmanTree() {
		super();
	}

	/**
	 * Second Constructor
	 * Creates a Huffman tree with one Huffman pair at the root
	 * @param eleemnt is the pair to be the root of the tree
	 */
	public HuffmanTree(HuffmanPair element) {
		super(element);							//Uses constrcutor of superclass
		
	}
	
	/**
	 * Third constructor
	 * Creates a Huffman tree roots at a node containing element, where the left subtree is the left child and the right subtree is the right child
	 * @param element is the pair to be the root of the tree
	 * @param leftSubtree is the pair to be the left subtree 
	 * @param rightSubtree is the pair to be the right subtree
	 */
	
	public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree) {

		super(element);									//Uses constructor of superclass
		getRoot().setLeft(leftSubtree.getRoot()); 		//Sets the leftSubtree as left child
		getRoot().setRight(rightSubtree.getRoot());		//Sets thr right subtree as right child
		
	}
	
	/**
	 * Fourth constructor
	 * Builds a HuffmanTree using an algorithm 
	 * @param pairsList is an ordered list of Huffman pairs in ascending order by frequency 
	 */
	public HuffmanTree(ArrayOrderedList <HuffmanPair> pairsList) {
		HuffmanTree leftSubtree; 									
		HuffmanTree rightSubtree;
		ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<HuffmanTree>();
		
		for(int pair = 0; pair < pairsList.size(); pair++) {								//Loops through all the Huffman pairs in pairsList parameter
			HuffmanTree pairTree = new HuffmanTree(pairsList.getElement(pair));			//Makes a huffmanTree consisting only of a root node containing the HuffmanPair
			buildList.add(pairTree);														//Adds each tree to a temporary ordered list buildList
		}
		
		if(buildList.size() == 1) {
			System.out.println("The text file contains one or more instances of the same character only.");
			
		}
		
		while(buildList.size() > 1) {													//While there's more than one item in buildList
			leftSubtree = buildList.removeFirst();										//Removes the 2 trees with lowest frequencies. Left Subtree is first.
			rightSubtree = buildList.removeFirst();										//Right subtree is second lowest frequency and hence the second in buildList
			int frequencySum = leftSubtree.getRoot().getElement().getFrequency() + rightSubtree.getRoot().getElement().getFrequency();		//
			HuffmanPair element = new HuffmanPair(frequencySum);
			HuffmanTree newTree = new HuffmanTree(element, leftSubtree, rightSubtree);
			buildList.add(newTree);
			this.setRoot(buildList.first().getRoot());
		}
		
		
		
	}
	
	/**
	 * Compares the frequencies in the root node of the trees
	 */
	public int compareTo(HuffmanTree otherTree) {
		return this.getRoot().getElement().getFrequency()-otherTree.getRoot().getElement().getFrequency();	
	}
	
	/**
	 * Returns a string representation of a HuffmanTree by doing a preorder traversal of the tree.
	 * Overrides the toString method of the LinkedBinaryTree class
	 */
	public String toString() {

	    	String s = "";
		
		Iterator<HuffmanPair> list = this.iteratorPreOrder();
		while (list.hasNext()) {
			HuffmanPair temp = list.next();
			s += temp.toString() + "\n";
		}
		return s;
	}
}
