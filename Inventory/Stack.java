/**Data structure class Stacks with array implementation.
 * Stack is used here to push and pop Widgets on and off to keep track of
 * inventory, like how many widgets were received and sold along with their worth. 
 */
public class Stack {

	private Widgets[] data;
	private int top;
	private static int maxSize = 10;
	
	public Stack(){
		data = new Widgets[maxSize];
		top = -1;
	}
	
	public boolean isEmpty(){ 
		return top == -1;                    
	}
	
	public void push(Widgets x){
		Widgets[] newStack = new Widgets[maxSize];
		
		if(top == maxSize-1){
			maxSize *= 2;        
			for(int i=0; i<=top; i++)                                           
				newStack[i] = data[i]; 
		}
		data[++top] = x;
	}
	
	public Widgets pop(){
		if(isEmpty()) 
			throw new NullPointerException("ArrayStack pop");
		return data[top--];
	}
	
	public Widgets peek(){
		if(isEmpty()) 
			throw new NullPointerException("ArrayStack peek");                
		return data[top];
	}
	
}
