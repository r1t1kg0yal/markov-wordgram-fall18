/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author YOUR-NAME
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		
		for(int i = 0; i<myWords.length; i++)
			myWords[i] = source[i];
		
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
	 * Complete this comment
	 * @return
	 */
	public int length(){
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		
		WordGram wg = (WordGram) o;
		if(wg.length()!=myWords.length)
			return false;
		for(int i = 0; i<myWords.length; i++)
			if(!myWords[i].equals(wg.wordAt(i)))
				return false;
				
		return true;
	}

	@Override
	public int hashCode(){
		
		if(myHash!=0)
			return myHash;
		else
		{
			myHash = toString().hashCode();
			return myHash;
		}
			
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		
		String [] newWords = myWords;
		
		for(int i = 1; i<newWords.length; i++)
			newWords[i-1] = myWords[i];
		
		newWords[newWords.length-1] = last;
		
		WordGram wg = new WordGram(newWords, 0, myWords.length);
		
		return wg;
	}

	@Override
	public String toString(){
		
		if(myToString!=null)
			return myToString;
		else
		{
			for(int i = 0; i<myWords.length; i++)
				myToString = myToString + myWords[i] + " ";
			return myToString;
		}
	}
}
