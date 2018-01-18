/** 
 * Project1GUI is a inherited part of the Project1 program, where it creates a JFrame window and
 * separates it into two areas of left and right. The main function in Project1 will then call
 * the methods from this class to print and display its content onto the frame window created here. 
 * @author Kalina Majewska
 */

import javax.swing.*;
import java.awt.*;

public class Project1GUI extends JFrame{ //extending JFrame to inherit it onto Project1 class.

	//initializing container and left/right areas used in later methods.
	private Container p1; 
	private TextArea leftArea;
	private TextArea rightArea;

	/*Creating Project1GUI method that is called in Project1 class. It creates a window frame,
	 * setting its size, title and location of a text area that we input in later.
	 */
	public Project1GUI(String title){
		setTitle("Word Array"); //title displayed on the frame.
		setSize(700,500); //size of the frame in pixels.
		setLocation(150,150); //location of the displayed text area on the whole frame.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits window when click x on top right of window
	
		p1 = getContentPane(); 
		p1.setLayout(new GridLayout(1,2)); //dividing layout of frame "p1" into two sections, left and right.
		
		leftArea = new TextArea(); //initializing text area onto the leftArea.
		rightArea = new TextArea(); //initializing text area onto the rightArea.
		p1.add(leftArea); 
		p1.add(rightArea); //Adding both text areas onto the GUI frame.
		setVisible(true); //setting the frame visible for user to see when the program is ran.
	}//constructor	
	
	
	/**Next two methods print out an array of Strings onto a desired area of the frame. It
	 *increments a word count and stores it into an array that is then added onto its designated area.
	 *@param wordArray
	 *@param left
	 */
	public void printLeft(String[] wordArray, int left){
		for(left=0;left<wordArray.length;left++){ 
			leftArea.append(wordArray[left] + "\n"); //appends the list of words in wordArray onto the left area of the frame
		}
	}

	/**
	 * @param wordArray
	 * @param right
	 */
	public void printRight(String[] wordArray, int right){
		for(right=0;right<wordArray.length;right++){
			rightArea.append(wordArray[right] + "\n"); //appends the list of words in wordArray onto the right area of the frame
		}
	}
}
