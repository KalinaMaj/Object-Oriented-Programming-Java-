public class LinkedList {

	//First node in linked list is set as a dummy node.
	private ListNode first = new ListNode(null);
	/*Last node in linked list is set to the first (dummy node). This way, when data is added, 
	 * the last will point to the next node that is added.
	 */
	private ListNode last = first;
	private int length = 0; // Number of data items in the list, initialized to 0.
	
	//Returns the number of elements in the list.
	public int getLength() { 
		return length;
	}

	// Method append adds a String data element to the current LinkedList.
	public void append(String d) {
		ListNode newNode = new ListNode(d); //new node set to contain string d as its data.
		last.next = newNode; 
		last = newNode; //last node is now pointing to the new node
		++length;
	} // method append

	/*Recursive delete method that searches for a string word starting from the first node in the LinkedList, 
	*and deletes the node at the first instance its found.
	*/
	public void delete(String w){
		first = delete(first, w);
	}//method delete
	   
	private ListNode delete(ListNode node, String x){
	     if(node.data.equals(x))
	         return node.next;
	      else
	         node.next = delete(node.next, x);
	      return node;
	}//method delete
	
	// Returns String representation of elements in linked list delimited by a space character.
	public String toString() {
		ListNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + " ";
			p = p.next;
		}
		return returnString;
	}

	/* Determines whether this ShortSequenceLinkedList is equal in value to the
	 * parameter object. They are equal if the parameter is of class
	 * ShortSequenceLinkedList and the two objects contain the same short
	 * integer values at each index.Return if the parameter object is a
	 * ShortSequenceLinkedList containing the same numbers at each index
	 * as this ShortSequenceLinkedList, false otherwise.
	 */
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()
				|| length != ((LinkedList) other).length)
			return false;

		ListNode nodeThis = first;
		ListNode nodeOther = ((LinkedList) other).first;
		while (nodeThis != null) {
			// Since the two linked lists are the same length,
			// they should reach null on the same iteration.

			if (nodeThis.data != nodeOther.data)
				return false;

			nodeThis = nodeThis.next;
			nodeOther = nodeOther.next;
		} // while

		return true;
	} // method equals

	public void clear(){
		last = first;
	}
} // class LinkedList
