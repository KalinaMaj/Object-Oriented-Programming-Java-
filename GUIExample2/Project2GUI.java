/* Project2GUI is an inherited part of the Project2 program, where it creates a JFrame window and
 * separates it into three columns. The main function in Project2 will then call methods from this class 
 * to print and display its content onto the frame window created here.
 */

import javax.swing.*;
import java.awt.*;

public class Project2GUI extends JFrame{ //extending JFrame to inherit it onto Project2 class.

	//initializing container of the JFrame and three text areas used in later methods.
	private Container p2; 
	private TextArea area1;
	private TextArea area2;
	private TextArea area3;

	/*Creating Project2GUI method that is called in the Project2 class. It creates a window frame,
	 * setting its size, title and location of a text area that we input in later.
	 */
	public Project2GUI(String title){
		setTitle("Words Added"); //title displayed on the frame.
		setSize(700,500); //size of the frame in pixels.
		setLocation(150,150); //location of the displayed text area on the whole frame.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits window when click x on top right of window
	
		p2 = getContentPane(); 
		p2.setLayout(new GridLayout(1,1)); //setting the layout of p2, into three columns
		
		area1 = new TextArea();
		area2 = new TextArea();
		area3 = new TextArea();
		p2.add(area1); 
		p2.add(area2);
		p2.add(area3);	//Adding all three text areas onto the 3 columnds in the GUI frame.
		setVisible(true); //setting the frame visible for user to see when the program is ran.
	}	
	
	
	/*The next three methods print out an array of Strings onto a desired area of the frame. The first two methods
	 *increments a word count and stores it into an array that is then added onto its designated area.
	 *The third method takes a LinkedList as a parameter, and displays it in the third area of the GUI frame.
	 */
	public void printAreaOne(String[] wordArray, int i){
		for(i=0;i<Project2.wordSize;i++){
			area1.append(wordArray[i] + "\n");//appends the list of words in wordArray onto the 1st column of the frame
		}
	}

	public void printAreaTwo(String[] wordArray, int j){
		for(j=0;j<Project2.wordSize;j++){
			area2.append(wordArray[j] + "\n"); //appends the list of words in wordArray onto the 2nd column of the frame
		}
	}
	
	public void printAreaThree(LinkedList wordArray){
			area3.append(wordArray + "\n"); //appends the LinkedList onto the third column of the frame.
	}
}//end of GUI class