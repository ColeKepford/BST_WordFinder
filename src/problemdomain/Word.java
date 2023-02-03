package problemdomain;

import java.io.Serializable;
/**
 * This class stores a word, the file, and the line it came from
 * @author cocog
 *
 */
public class Word implements Serializable, Comparable<Word>
{
	private String word;
	private String fileName;
	private int lineNumber;
	
	/**
	 * Constructor for Word class
	 * @param word the word being stored
	 * @param fileName the file the word came from
	 * @param lineNumber the line of the file the word came from
	 */
	public Word(String word, String fileName, int lineNumber) 
	{
		this.word = word;
		this.fileName = fileName;
		this.lineNumber = lineNumber;
	}
	
	/**
	 * This method returns the word
	 * @return the word
	 */
	public String getWord() 
	{
		return word;
	}
	
	/**
	 * This method sets the word
	 * @param word the word to be set
	 */
	public void setWord(String word) 
	{
		this.word = word;
	}
	
	/**
	 * This method gets the name of the file
	 * @return the file name
	 */
	public String getFileName() 
	{
		return fileName;
	}

	/**
	 * This method sets the filename
	 * @param fileName the filename to be set
	 */
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	/**
	 * This method gets the linenumber the word came from
	 * @return the original line number
	 */
	public int getLineNumber() 
	{
		return lineNumber;
	}

	/**
	 * This method sets the linenumber
	 * @param lineNumber the line number to be set
	 */
	public void setLineNumber(int lineNumber) 
	{
		this.lineNumber = lineNumber;
	}

	@Override
	public int compareTo(Word word) 
	{
		return this.getWord().compareToIgnoreCase(word.getWord());
	}
	
	/**
	 * This method compares the String in the word field to another string
	 * @param word the string to compare to
	 * @return Returns a 1 if this word comes alphabetically after the compared word,
	 * returns a 0 if they're alphabetically the same, and a -1 if this word comes before
	 * the compared word.
	 */
	public int compareTo(String word)
	{
		return this.getWord().compareToIgnoreCase(word);
	}
	
	@Override
	public String toString()
	{
		return this.word + "," + this.fileName + "," + this.lineNumber;
	}
	
	
	
}
