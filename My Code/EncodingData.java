/**
 * 
 */

/**
 * @author Wafiq Syed Rahmathulla 
 * @author Student No. 250868594
 * This program represents a single pair of the data used to encode a text message into its binary Huffman code (symbol and corresponding code)
 * It will be used for encoding a text file
 *
 */
public class EncodingData {

	/**
	 * 
	 */
	
	private char symbol;					//a symbol that is to be encoded
	private String encoding; 			//binary Huffman code of the symbol 
	
	public EncodingData(char symbol, String encoding) {
		this.symbol = symbol;			//Initiates the symbol equal to the paramater symbol
		this.encoding = encoding;		//Initiates the encoding equal to the paramater encoding
	}

	/**
	 * Returns symbol
	 */
	
	public char getSymbol() {
		return this.symbol;
	}
	
	/*
	 * returns the  Huffman code
	 */
	
	public String getEncoding() {
		return this.encoding;
	}
	
	/**
	 * Sets Huffman code for a symbol
	 * @param code is the string for the code that needs to be set for the symbol
	 */
	
	public void setEncoding(String code) {
		this.encoding = code;
	}
	
	/**
	 * determines if two EncodingData objects are equal based on the symbol attribute 
	 * returns true if the the two objects have same symbol, returns false if not
	 * @param obj is the object we want to compare to
	 */
	public boolean equals(Object obj) {
		EncodingData other = (EncodingData) obj;
		if(this.symbol != other.symbol) {return false;}
		return true;
	}
	
	/*
	 * Returns a string representation of the symbol and its Huffman Code
	 */
	public String toString() {
		String s = "";
		s = "(" + symbol + ", " + encoding + ")\n" ;
		return s;
	}
}
