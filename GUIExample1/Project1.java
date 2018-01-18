/** Given an input text containing a list of words, Project1.java displays a GUI window frame 
 * showing the portion of the list that do not contain digits on its left side, and the same
 * list sorted in alphabetical order on its right. If a word in the list is not valid (has digits), 
 * it's displayed in the console system.
 *
 * @author Kalina Majewska
 */


public class Project1{
	//declaring variables.
	static String word;
	static String[] wordList;
	static int wordSize = 0; //initializing word count to 0 for array list.
	static TextFileInput inFile = new TextFileInput("wordlist.txt"); //creating instance of the text file that's used, using the class TextFileInput 
	
	
	public static void main(String[] args){
		int leftSize = 0; 
		int rightSize = 0;
		
		//After creating an array of validated words from the text, we print the proper outputs on each side of the frame.
		makeArray();
		//file has been read once, therefore it needs to be closed and reopened
		inFile.close();
		inFile = new TextFileInput("wordlist.txt");
		readWordList();
		Project1GUI myGui = new Project1GUI("Name of GUi"); //create an instance of GUI class - new window will show on execution
		myGui.printLeft(wordList, leftSize); //print left side method called from Project1GUI class
		selectionSort(wordList);  //sort the list for the right side of the frame
		myGui.printRight(wordList, rightSize); //print right side method called from Project1GUI class
	} //end of main 
	
	
	/**makeArray method reads each word from the text file, and checks its validity through
	 * isValidWord method. If the word in the line is not null nor does it contains any digits, word 
	 * count gets incremented, and is set as the size of wordList.
	 */
	public static void makeArray(){
		TextFileInput myFile = inFile; //required text file that we imported.
		int count = 0;
		String line = myFile.readLine(); //read line in the text file.
		while (line != null){
			if(isValidWord(line)){ //check validity.
				count++; //increment the line if valid.
			}
			line = myFile.readLine(); //read next line
		}
		wordList = new String[count]; //set wordList size to count.
	}


	/** readWordList method, similarly to makeArray method, reads a word from the text file lines and checks 
	 * its validity. However, it prints out an output of the word to the console if the word is
	 * invalid. Otherwise, it stores the validated words into wordList array using storeWordList method.
	 */
	public static void readWordList(){
		String word = inFile.readLine();
		while (word != null){
			boolean valid = isValidWord(word);
			if (!valid){ //checks if word is valid.
				System.out.println(word); //prints out the word to the console if invalid.
			}
			else{
				storeWordList(word, wordList); //stores the valid word into array using storeWordList method.
			}
			word = inFile.readLine(); //read next line
		}
	}
	
	
	/** storeWordList method stores word w into array 'list'.
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


	/**selectionSort method sorts listed words in an array into an alphabetical order, and returns the sorted
	 * list as a String[] type. This sorted list will be printed on the right side of the GUI frame. 
	 * @param array
	 * @return
	 */
	public static String[] selectionSort(String[] array){
		for (int i = 1; i < array.length; i++) {
			int s = i-1;
			for (int j = i; j < array.length; j++){ 
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
}



