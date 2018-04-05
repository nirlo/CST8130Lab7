package dataLab7;

import java.util.Scanner;

public class Lab7Main {
	
	public static void main(String[] args) {
		Words words = new Words();
		
		Scanner keyboard = new Scanner(System.in);
		boolean run = true;
		
		do {
			System.out.print("\nEnter 1 to clear dictionary,\n"
					+ "2 to add text from keyboard, \n"
					+ "3 to add text from a file,\n"
					+ "4 to search for a word counter\n"
					+ "5 to display number of nodes\n"
					+ "6 to quit/n");
			
			String choice = keyboard.next();
			
			switch (choice){
			case "1":
				words.clearWords();
				System.out.println("Dictionary has been cleared");
				break;
			case "2":
				words.addFromKeyboard(keyboard);
				break;
			case "3":
				words.addFromFile(keyboard);
				break;
			case "4":
				System.out.println("What word do you want to know the count of?");
				String counted = keyboard.next();
				int count = words.getValue(counted);
				if(count <= 0)
					System.out.println("That word was not in the text given");
				else
					System.out.println("The word "+ counted+ " occured " +count);
				break;
			case "5":
				System.out.println("There are "+words.getWordCount()+ " nodes");
				break;
			case "6":
				run = false;
				break;
			}
		}while(run);
	}
}
