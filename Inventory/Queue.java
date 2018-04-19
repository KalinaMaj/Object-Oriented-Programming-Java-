/**Data structure class Queue with array implementation.
 * Queue is used here to add and delete Widgets on and off of it to manage
 * back order, any customer order that exceeds what is in the stack.
 */

public class Queue {

	private Widgets[] data;
	int front = 0;
	int rear = -1;
	int count = 0;
	int maxSize = 10;
	
	public Queue(){
		data = new Widgets[maxSize];
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	public void enQ(Widgets x){
		if(count == maxSize){
			maxSize *= 2;
			Widgets[] newData = new Widgets[maxSize];
			int i = front;
			for(int j=0; j<count; j++){
				newData[j] = data[i];
				i = (i+1)%count;
			}
			data = newData;
			front = 0;
			rear = count-1;
		}
		rear = (rear+1)%maxSize;
		count++;
		data[rear] = x;
	}
	
	public Widgets deQ(){
		if(isEmpty()) throw new NullPointerException("ArrayQueue Empty");
		Widgets oldFront = data[front];
		front = (front+1) % maxSize;
		count--;
		if(count==0){
			front=0;
			rear = -1;
		}
		return oldFront;
	}

}
