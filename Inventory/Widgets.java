/**Class Widgets created an object widget that holds the quantity of widgets and the value for
 * each widget. Widget is an array of size 2. The methods in the class is a toString implementation
 * "display()" that displays the contents of the array. getQuant and getCost each returns the
 * content of the array in its first position, and second respectively. InventoryCost takes care 
 * of the total cost of the Widget received in shipment.
 */

import java.util.Arrays;

public class Widgets {
	
	private double[] Widget;
	
	public Widgets(){
		Widget = new double[2];
	}
	
	public void Widgets(double amount, double cost){ //the inputs are of type double to account for the cost of the widget, which shows as a decimal point.
		Widget[0] = amount; //holds the amount of Widgets received/sold
		Widget[1] = cost; //cost of widget received.
	}
	
	public String display(){
		return Arrays.toString(Widget); //displays content of the array in the form of a string
	}
	
	public double getQuant(){ //get count of widgets
		return Widget[0];
	}
	
	public double getCost(){ //get the cost-per-widget
		return Widget[1];
	}
	
	public double inventoryCost(){
		double sum = 0;
		double amount = Widget[0];
		double cost = Widget[1];
		sum = amount * cost; //quantity times cost produce a sum, which shows the total cost of all widgets received in the shipped.
		return sum;
	}

	
}//end class Widgets
