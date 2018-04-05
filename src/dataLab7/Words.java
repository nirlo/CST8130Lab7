package dataLab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Words {

	private TreeMap<String, Integer> words;
	
	public Words() {
		words = new TreeMap<>();
	}
	
	public int getWordCount() {
		return words.size();
	}
	
	private void addWord(String word) {
		if(words.containsKey(word)) 
			words.put(word,  words.get(word)+1);
		 else 
			 words.put(word, 1);
	}
	
	public void addFromKeyboard(Scanner kb) {
		System.out.println("Enter the words to add into this dictionary: ");
		String selection = kb.next();
		selection.replaceAll("^\\s","");
		String[] array = selection.split(" ");
		for(String s: array) {
			addWord(s);
		}
		
	}
	
	public boolean addFromFile(Scanner kb) {
		boolean success = false;
		System.out.println("Please enter the file you want to count words in:");
		String choice = kb.next();
		File file = new File(choice);
		
		try(Scanner fileInput = new Scanner(file)){
			while(fileInput.hasNext()) {
				String word = fileInput.next();
				word.replaceAll("^\\s","");
				addWord(word);
			}
			success = true;
		} catch(FileNotFoundException e) {
			System.out.println("File does not exist. returning to main menu.");	
		}
		return success;
	}
	
	public void clearWords() {
		words = new TreeMap<>();
	}
	
	public int getValue(String s) {
		if(words.containsKey(s))
			return words.get(s);
		else
			return 0;
	}
	
}
