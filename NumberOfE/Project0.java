/** The program below asks the user to input a sentence upon its initial
 * run. The sentence then gets checked, and the total count of the letter 
 * e (in both lower and upper case) that exists in it gets displayed in a 
 * new window. The program repeats this process until the user inputs
 * "stop", regardless of how it is written, which causes the program
 * to exit completely. 
 * 
 * @author Kalina Majewska
 */ 


import javax.swing.JOptionPane;

public class Project0{
	
	public static void main(String[] args){
		String inputSentence;
		
		while(true){
			
			/*Creating a new window using JOptionPane class, allowing the user to input what 
			*the string message asks them to input. 
			*/
			inputSentence = JOptionPane.showInputDialog(null, "Type in a sentence:");
			
			if(inputSentence.equalsIgnoreCase("Stop"))
				System.exit(0);	//restriction to the loop, where if user inputs 'stop', the program exits.
			
			//Calling JOptionPane class method showMessageDialog, which displays a string in a window.
			//The string message displays how many lower case and upper case letter 'e' was found 
			//inside the input that the user entered in the first window display.
			//The method findE() is called here.
			JOptionPane.showMessageDialog(null, "Number of lower case e's: " + findE('e', inputSentence) + "\n" + "Number of upper case e's: " + findE('E', inputSentence));
		} 
	} //end of main
	
	/** The method findE takes a character and a String type as parameters, and returns an integer. 
	* The method begins to check every letter in the entire string, counting out how many times it 
	* encountered the character (here being 'e' and 'E'). The character count is returned.
	* 
	* @param e
	* @param sentence
	*/
	public static int findE(char e, String sentence){
		int checkletter = 0; 	
		
		//for loop iterates through the string until its full length is reached.
		for(int i=0; i<sentence.length(); i++){
			if (sentence.charAt(i) == e)
			checkletter++; 		//increment the character count every time its encountered
		}
		
		return checkletter;	//return the total count of the character encountered in the string
	}
}

