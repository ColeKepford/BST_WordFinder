package applicationdomain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import problemdomain.Word;
import utilities.BSTInOrderIterator;
import utilities.BSTReferencedBased;

public class WordFinder 
{
	/**
	 * This class reads a text document and deletes all non-letter characters.
	 * It then inserts every word into a Binary Search Tree
	 * It then outputs the tree's contents to console or another text file.
	 * @param args arguments
	 * @throws IOException If input or output error throw IOException
	 */
	public static void main(String[] args) throws IOException
	{
		System.out.println("App Launched");
		
		//check if tree already exists
		File repository = new File("res/repository.ser");
		BSTReferencedBased<Word> bst = new BSTReferencedBased();
		if(repository.exists())
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(repository));
			try 
			{
				bst = (BSTReferencedBased<Word>) in.readObject();
			} 
			catch (ClassNotFoundException | IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		String fileName = "";
		String printType = "";
		String printFile = "";
		
		 //reads input from the command line
        for (int x = 0; x < args.length; x++) 
        {
            if (args[x].toLowerCase().contains("-n")) 
            {
                fileName = args[x].substring(2);
            }
            else if (args[x].toLowerCase().contains("-p")) 
            {
                printType = args[x].substring(2);
            } 
            else if (args[x].toLowerCase().contains("-f")) 
            {
                printFile = args[x].substring(2);
            }
        }
		
		File file = new File(fileName);
		Scanner inFile = new Scanner(file);
		
		
		int lineNumber = 1;
		while(inFile.hasNext())//read file into array
		{
			String line = inFile.nextLine();
			String[] splitLine = line.split(" ");
			for(int i = 0; i < splitLine.length; i++)
			{
				splitLine[i] = splitLine[i].replaceAll("\\W", "").toLowerCase();
				if(splitLine[i].equals(""))
				{
					continue;
				}
				Word word = new Word(splitLine[i], fileName, lineNumber);
				bst.add(word);//add words to tree
			}
			lineNumber++;
		}
		
		BSTInOrderIterator<Word> iter = (BSTInOrderIterator<Word>) bst.inorderIterator();
		ArrayList<String> report = new ArrayList<String>();
		
		
		if(printType.equals("f"))
		{
			while(iter.hasNext())
			{
				ArrayList<Word> words = iter.nextArray();
				ArrayList<String> files = new ArrayList<String>();
				Word firstWord = words.get(0);
				String wordList = "Word: " + firstWord.getWord() + "\nFiles: " + firstWord.getFileName();
				files.add(firstWord.getFileName());
				
				for(int i = 1; i < words.size(); i++)
				{
					Word current = words.get(i);
					if(!files.contains(current.getFileName()))
					{
						wordList += "," + current.getFileName();
					}
				}
				wordList += "\n";
				report.add(wordList);
			}
		}
		
		else if(printType.equals("l"))
		{
			while(iter.hasNext())
			{
				ArrayList<Word> words = iter.nextArray();
				ArrayList<String> files = new ArrayList<String>();
				Word firstWord = words.get(0);
				String wordList = "Word: " + firstWord.getWord() + "\nFile: " + firstWord.getFileName() + " Lines: " + firstWord.getLineNumber();
				files.add(firstWord.getFileName());
				
				for(int i = 1; i < words.size(); i++)
				{
					Word current = words.get(i);
					if(files.contains(current.getFileName()))
					{
						wordList += "," + current.getLineNumber();
					}
					else
					{
						files.add(current.getFileName());
						wordList += "\nFile: " + current.getFileName() + " Lines: " + current.getLineNumber();
					}
				}
				wordList += "\n";
				report.add(wordList);
			}
		}
		
		else if(printType.equals("o"))
		{
			
			while(iter.hasNext())
			{
				ArrayList<Word> words = iter.nextArray();
				ArrayList<String> files = new ArrayList<String>();
				Word firstWord = words.get(0);
				String wordList = "Word: " + firstWord.getWord() + "\nFile: " + firstWord.getFileName() + " Lines: " + firstWord.getLineNumber();
				files.add(firstWord.getFileName());
				
				for(int i = 1; i < words.size(); i++)
				{
					Word current = words.get(i);
					if(files.contains(current.getFileName()))
					{
						wordList += "," + current.getLineNumber();
					}
					else
					{
						files.add(current.getFileName());
						wordList += "\nFile: " + current.getFileName() + " Lines: " + current.getLineNumber();
					}
				}
				wordList += "\nOccurences: " + words.size() + "\n";
				report.add(wordList);
			}
		}
		for(int i = 0; i < report.size(); i++)
		{
			System.out.println(report.get(i));
		}
		
		//If there's a printfile print to it
		if(!printFile.equals(""))
		{
			PrintWriter out = new PrintWriter(new FileOutputStream(printFile, false));
			for(int i = 0; i < report.size(); i++)
			{
				out.println(report.get(i));
			}
			out.close();
			System.out.println("Report saved to file: " + printFile);
		}
		serializeTree(bst);
	}
	
	/**
	 * This method serializes the tree
	 * @param bst the tree
	 */
	public static void serializeTree(BSTReferencedBased bst)
	{
		try 
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res/repository.ser", false));
			oos.writeObject(bst);
			
			oos.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}



