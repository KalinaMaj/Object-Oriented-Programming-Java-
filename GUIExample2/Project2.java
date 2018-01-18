/** 
 * Upon execution, a JOptionPane input dialog window appears asking the user to input one of three commands:
 * "stop" in case insensitive way that will terminate the program, "add" or "delete". The program will then display 
 * a three column GUI JFrame. The first column contains an array of list of words read from a text file, and the second
 * column contains the same list, but sorted in alphabetical order. The third column contains the sorted LinkListed 
 * containing each from the list of strings. When the user inputs the command "add" + word in the input dialog, the new 
 * word will be added into the linked list and displayed in the GUI. Similarly, input command "delete" + word makes sure 
 * that if the word is part of the array list, it gets removed the word from the list and displays the result 
 * in the GUI. Methods that add/delete words from the linked lists are inherited from the class LinkedList + ListNode. 
 * 
 * @author Kalina Majewska
 */

import javax.swing.JOptionPane;
import java.util.StringTokenizer;

public class Project2 {
//declaring variables.
static String[] wordArray = new String[100]; //initialize wordArray
static int wordSize = 0; //initializing word count to 0 for array list.
static TextFileInput inFile = new TextFileInput("wordlist.txt"); //creating instance of the text file that's used, using the class TextFileInput 


public static void main(String[] args){
	LinkedList wordList = new LinkedList(); //Instance of LinkedList which will contain words from inFile.
	//initializing sizes of the word count of the first two columns at 0, which will be later called in print methods from the GUI class.
	int areaOneSize = 0; 
	int areaTwoSize = 0;
		
	//fill wordArray with words from input file
	readWordList();
	inFile.close();
	
	//get user input command
	while(true){
		String inputCommand = JOptionPane.showInputDialog("Enter Command: "); //initializing the command that the user will input.
		StringTokenizer myTokens = new StringTokenizer(inputCommand, " "); //input from user is converted to string tokens that can be worked with when adding and deleting from list
		String command = myTokens.nextToken(); //set first word of the input as the command (should be add or delete)
		
		if (inputCommand.equalsIgnoreCase("STOP"))
			System.exit(0); //program terminates when inputCommand = stop
		else if (command.equalsIgnoreCase("ADD")){
			add(myTokens, wordList);
		}
		else if (command.equalsIgnoreCase("DELETE")){
			delete(myTokens.nextToken(), wordList); 
		}
	
		//Display GUI frame
		Project2GUI myGui = new Project2GUI("Word List"); //instance of our GUI frame is created
		myGui.printAreaOne(wordArray, areaOneSize); //print wordArray in the first column of the frame
		selectionSort(wordArray); //sort wordArray
		myGui.printAreaTwo(wordArray, areaTwoSize); //print wordArray in the second column of the frame
		myGui.printAreaThree(wordList); //print the final linked list in the third column of the frame
		wordList.clear();
	}
} //main method


	/** readWordList method, similarly to makeArray method, reads a word from the text file lines and checks 
	 * its validity. It then stores the validated words into wordList array using storeWordList method.
	 */
	public static void readWordList(){
		String word;
		word = inFile.readLine();
		while (word != null){
			boolean valid = isValidWord(word); //checks if word is valid.
			if (valid){
				storeWordList(word, wordArray); //stores the valid word into the storeWordList method.
			}
			word = inFile.readLine();
		}
	}


	/**storeWordList method stores word w into array 'list'.
	 * 
	 * @param w
	 * @param list
	 */
	public static void storeWordList(String w, String[] list){
			list[wordSize]= w; 
			wordSize++; 
	}
	
	
	/**isValidWord checks the validity of a String by outputting true if the String doesn't contain any digits.
	 * @param w
	 * @return
	 */
	public static boolean isValidWord(String w){
		for(int i=0; i<w.length();i++){ 
			if(!Character.isLetter(w.charAt(i))){ //charAt() method checks the character at location "i" in a given string. If at position "i" there is a digit, 
				return (false);						   //return false.
			}
		}//end of for loop.
		return(true);
	}


	/** selectionSort method sorts listed words in an array into an alphabetical order, and returns the sorted
	 * list as a String[] type. This sorted list will be printed on the right side of the GUI frame. 
	 * 
	 * @param array
	 */
	public static String[] selectionSort(String[] array){
		for (int i = 1; i < wordSize; i++) {
			int s = i-1;
			for (int j = i; j < wordSize; j++){ 
				if (array[j].compareTo(array[s]) < 0) { //compare word at positions j to word at position s using compareTo
					s = j; //move the word at position s onto position j.
				}
	        }
			//sort by switching strings
			String temp = array[i-1];
			array[i-1] = array[s];
			array[s] = temp;
		}
		return array;
	}//selectionSort
	
	/**add word that the user input after command "add" into the wordArray using string tokenizer, and apply it to the linked list
	 * @param myTokens
	 * @param list
	 */
	public static void add(StringTokenizer myTokens, LinkedList list){
		StringTokenizer newTokens = new StringTokenizer(myTokens.nextToken(), ",");
		
		while(newTokens.hasMoreTokens()){
	         String next = newTokens.nextToken();
	         wordArray[wordSize] = next; // adds the new word to the wordList array
	         wordSize++;
	    }
		
		for (int i = 0; i < wordSize; i++)
			list.append(wordArray[i] + System.lineSeparator()); //add all words in the array wordList into the linked list
	}//add
	
	/**Deletes the new word from the existing array and linked list
	 * @param input
	 * @param list
	 */
	public static void delete(String input, LinkedList list){
		boolean wordExists = false;
	    int index = 0;
	    
	    //Search through the array for the input word, and set the index of where the word is. If the word is fouund, set wordExists = true
	    for (int i = 0; i < wordSize; i++) {
	         if(input.equals(wordArray[i])) {
	            index = i; //sets the index of the word to delete
	            wordExists = true;
	            break;
	         }
	     }
	    
	    //if word was found, delete it from wordArray
	    if(wordExists == true){ 
	         for (int i = index; i < wordSize; i++)
	            wordArray[i] = wordArray[i+1]; // deletes the word and shifts everything over
	  
	         wordSize = wordSize - 1;
	    }
	    
	    for (int i = 0; i < wordSize; i++)
			list.append(wordArray[i] + System.lineSeparator()); //add all words in the array wordList into the linked list
	}//delete
}
