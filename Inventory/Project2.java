import java.io.*;
import java.util.*;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**Project 2 is designed to keep track of inventory of widgets and their costs post shipment 
 * and sale, as well as displaying a receipt of what the customer paid on each sale encountered.
 * Each received shipment is pushed onto a stack data structure. On each sale transaction, 
 * the the amount of widgets sold get popped from the stack, and the customer gets charged 40% over the 
 * highest cost of the widget (it is assumed each shipment increases the cost of widgets over time, so 
 * the customer is charged the cost of the most recent widget on the stack. 
 * Orders that demand more widgets then there is in the inventory get put on back order controlled by a queue.
 *
 *@author Kalina M
 */

public class Project2{
	public static void main (String[] args) throws FileNotFoundException{
		//initializing the file of shipment/sales instructions.
		File text = new File("Transactions.txt");
		Scanner in = new Scanner(text);
		double invenTotal = 0.0;
		
		//calling data structure classes
		Stack stack = new Stack();
		Queue backOrder = new Queue();
		
		while(in.hasNextLine()){
			String line = in.nextLine();
			StringTokenizer str = new StringTokenizer(line, " "); //Each line in the text gets split to distinguish between instruction "R" and "S".
			
			char instr = line.charAt(0);
			str.nextToken(); //Return next token, since we only need to work with the numbers.
			if(instr == 'R'){ //shipment received
				Widgets storage = new Widgets();
				int amount = Integer.parseInt(str.nextToken()); //amount of widgets received.
				double cost = Double.parseDouble(str.nextToken()); //cost per widget, for bookkeeping.
				storage.Widgets(amount, cost); //create new widget and initialize with current shipment data
				stack.push(storage); //push new widget onto the top of the stack.
				double inventory = storage.inventoryCost();
				invenTotal += amount; //add up total amount of widgets in the inventory
				//Display inventory update per shipment
				System.out.println("Shipment Received: " + stack.peek().display() + " Bookkeeper's actual cost: " + inventory + " Total widgets: " + invenTotal);
			}//if instr=R
			
			if(instr == 'S'){ //sale transaction
				Widgets newStorage = new Widgets();
				double order = Integer.parseInt(str.nextToken()); //amount of widgets customer wants
				double copy = order; //for receipt purposess
				Widgets c = new Widgets();
				c = stack.peek(); //the cost of the last widget on the stack is used first
				double quant = c.getQuant(); 
				double charge = c.getCost();  //cost per widget of the last widget on the stack
				charge = (charge*.4)+charge; //calculating 40% over the highest cost, which is what they need to pay.
				double ccost = order*charge; //ccost will get displayed in the cutomer's receipt to show how much the customer paid in total. 
				invenTotal = invenTotal - order; //subtracting widgets sold from total widgets in the inventory
				
				if(invenTotal <= 0){ //check if there is initially enough widgets for the sale
					newStorage.Widgets(order, ccost);				
					backOrder.enQ(newStorage); //enQ back ordered widget onto the queue
					System.out.println("Wdiget order " + newStorage.display() + " was placed on backorder - not enough Widgets!");
				}
				
				else{
					/*next while loop accounts for whether the order quantity exceeds the storage quantity in 
					 *the last widget of the stack. If order is larger, we subtract the  last widget's quantity 
					 *from the order, pop from the stack, and continue on until order was fully bought.
					 */
					while(order > quant){
						order = order - quant; 
						stack.pop();
						c = stack.peek();
						quant = c.getQuant();
					} //end of While loop
				
					
					if(stack.isEmpty()){	//second check if there is enough widgets to continue the sale	
						newStorage.Widgets(copy, ccost);
						backOrder.enQ(newStorage); //we enQ back ordered widget onto the queue
						System.out.println("Wdiget order " + newStorage.display() + " was placed on backorder - not enough Widgets!");
					}
					else{
						quant = quant-order; //process order fully - quantity of the last widget decreases because of sale.
						newStorage.Widgets(quant, c.getCost()); //fill remaining number of widgets and the cost onto a new widget
						stack.pop(); //contents of original widget are null and no longer there, so we pop the widget off.
						stack.push(newStorage); //pushing new widget with current storage on the stack.
						//print customer's receipt
						System.out.println("Customer Ordered: " + copy + " - Customer Paid: " +  String.format( "%.2f", ccost) + " - Storage After Sale: " + invenTotal);
					}
				}
			}//if instr=S
		} //end while loop
		
		in.close(); //closing text file
	} //end main

}
