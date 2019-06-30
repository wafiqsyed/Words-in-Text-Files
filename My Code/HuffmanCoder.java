/**
 * HuffmanCoder 
 * This program uses a Huffman tree for encoding a character and decoding a code string.
 * @author Wafiq Syed
 * @author 250868594
 */
public class HuffmanCoder {

	private HuffmanTree huffTree;			 					//the Huffman tree
	private ArrayUnorderedList<EncodingData> encodingList;		//an unordered list of encoding data that will be used for encoding a text file into a Huffman-coded compressed file
	
	/**
	 * Constrcutor will create the huffTree using the forth HuffmanTree constructor
	 * @param pairsList
	 */
	public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairsList) {
		huffTree = new HuffmanTree(pairsList);						//Creates the huffTree using the 4th Huffman tree constructor
		String s = "";												//Initiates empty string
		encodingList = new ArrayUnorderedList<EncodingData>(pairsList.size());	//Creates the encodingList as an unordered arraylist of size equivalent to pairs List size
		buildEncodingList(huffTree.getRoot(), s);					//Calls upon build Encoding list to build the list using the huffTree
	}

	/**
	 * Takes the specified string of binary digits that is a Huffman encoding and will return the original coded character
	 * @param code is the string of digits
	 * @return String of the original coded character in code
	 */
	public char decode(String code) {
		BinaryTreeNode<HuffmanPair> currentNode = huffTree.getRoot();				//Begin traversal the root of the huffTree
		for(int position = 0; position< code.length();position++) {				//Iterate through each character from parameter code
			if(currentNode == null) {											//If the current node is null then return the standard character
				return (char)0;
			}
			if(code.charAt(position) == '0') {									//If the code is 0, then traverse to the left child
				currentNode = currentNode.getLeft();
			}else {
				currentNode = currentNode.getRight();							//If the code is 1, then traverse to the right child
			}
		}		
		if(currentNode != null) {												//If the current node is NOT null, then return the character decoded
			return currentNode.getElement().getCharacter();
		}
		return (char)0;												//Returns the standard character 
		
	}
	
	/**
	 * Takes the specified character and returns the string representation of the Huffman encoding of that character
	 * @param c is the specified character
	 * @return String representation of the Huffman encoding of param c
	 * @throws ElementNotFoundException if the specified character is not found and has no Huffman encoding
	 */
	public String encode(char c) throws ElementNotFoundException{
		EncodingData charContained = new EncodingData(c, "");						//Initiates variable charContained as an EncodingData object
		if(encodingList.contains(charContained)){								//Checks to see if the encodingList even contains the character passed in parameter
			int position = encodingList.find(charContained);
			EncodingData getData = encodingList.getElement(position);
			return getData.getEncoding();
		}else {throw new ElementNotFoundException("Character isn't found");}		//If the character isn't in the encoding list then throw an element not found exception
	}
	
	/**
	 * Returns a string representation of the encoding list 
	 */
	public String toString() {
		String s = "";
		for(int i = 0; i < encodingList.size(); i++) {							//Loops through the encoding list
			s += encodingList.getElement(i).toString();							//Adds each element to the string in string format
		}
		return s;																//Returns string
	}
	
	
	/**
	 * Builds an unordered list from the Huffman tree.
	 * @param node 
	 * @param encoding
	 */
	private void buildEncodingList(BinaryTreeNode<HuffmanPair> node, String encoding) {
		if(node.isLeaf()) {																					//Check to see if the node is a leaf, base case for recursion
			EncodingData newEncodingData = new EncodingData(node.getElement().getCharacter(),encoding);		//Initiates newEncodingData as a variable 
			encodingList.addToRear(newEncodingData);
		}else {
			buildEncodingList(node.getLeft(), encoding + "0");
			buildEncodingList(node.getRight(), encoding + "1");
		}
	}
}
