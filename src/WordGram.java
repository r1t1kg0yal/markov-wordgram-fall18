/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Ritik Goyal
 *
 */

public class WordGram {
	
	private String[] myWords;   // array of Strings in WordGram
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	
	/**
	 * Creates a new WordGram object that initializes myToString and myHash
	 * and creates an array of Strings, of size, pulled from source from start
	 * 
	 * @param source
	 * @param start
	 * @param size
	 */
	
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
		
		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Return length/order of WordGram
	 * @return length of myWords
	 */
	
	public int length(){
		return myWords.length;
	}


	@Override
	
	/**
	 * Determine whether specified Object 
	 * contains the same strings in the same order
	 * as this WordGram
	 * 
	 * @param an Object that may or may not be a WordGram
	 * @return Boolean true if this WordGram equals Object
	 */
	
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		
		WordGram wg = (WordGram) o;
		
		String a = toString();
		String b = wg.toString();
		
		if(a.equals(b))
			return true;
		
		return false;
	}

	@Override
	
	/**
	 * Find the hash value of the String
	 * representation of the words in myWords
	 * And set myHash to it
	 * 
	 * @return myHash instance variable
	 */
	
	public int hashCode(){
		
			myHash = toString().hashCode();
			return myHash;
	}
			
	

	/**
	 * Create a new array of Strings with each String
	 * shifted one space up and the last index position 
	 * of the array set as "last"
	 * 
	 * @param last is last String of returned WordGram
	 * @return WordGram of Strings shifted from previous
	 */
	public WordGram shiftAdd(String last) {
		
		String [] newWords = new String [myWords.length];

		for(int i = 0; i < newWords.length; i++)
			newWords[i] = myWords[i];
		
		
		for(int i = 1; i<newWords.length; i++)
			newWords[i-1] = myWords[i];
		
		newWords[newWords.length-1] = last;
		
		return new WordGram(newWords, 0, myWords.length);
	}

	/**
	 * Depict the words in myWords as 
	 * a single String and return it
	 * 
	 * @return String representation of myWords
	 */
	
	@Override
	
	public String toString(){
		
		if(myToString!=null)
			return myToString;
		else
			myToString = String.join(" ", myWords);
		
		return myToString;
	}
}
