/**Binary search tree class - all methods of insertion, removal, searching 
 * for a node and toString/print are here. Null pointer exceptions are thrown
 * remove methods.
 */

public class BinarySearchTree<AnyType extends Comparable<AnyType>>{
	
	protected BinaryNode<AnyType> root;
	protected int counter = 0;
	
	public BinarySearchTree(){ //Constructor
		root = null;
	}
	//Public operations, calling to hidden methods.
	public void insert(AnyType x)
		{root = insert(x, root);}
	public void remove(AnyType x)
		{root = remove(x, root);}
	public void removeMin()
		{root = removeMin(root);}
	public AnyType findMin()
		{return elementAt(findMin(root));}
	public String toString()
		{return inOrder(root);}
	public boolean isEmpty()
		{return root == null;}
	
	//Insert method, places nodes less then the root as its left child, and nodes greater then or equal to the root as its right child.
	protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
		if(t == null)
			t = new BinaryNode<AnyType>(x); //inserting data x into a new node t
		else if(x.compareTo(t.data) < 0)
			t.left = insert(x, t.left); //insert to left child/smaller then root     
		else t.right = insert(x, t.right);  //insert to right child/larger then or equal to the root
			return t;
	}//Theta(log n)
	
	protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> r){
		if(r == null)
			throw new NullPointerException();
		if(x.compareTo(r.data) < 0)
			r.left = remove(x, r.left); //if desired data to be removed is less then the data in the first checked node, go to the left child.
		else if(x.compareTo(r.data) > 0)
			r.right = remove(x, r.right); //if desired data to be removed is greater then the data in the first checked node, go to the right child.
		else if(r.left != null && r.right != null){ //node with two children case
			r.data = findMin(r.right).data; //find and remove the minimum node in the right sub tree, and swap it with the removable node and then remove node.
			r.right = removeMin(r.right);
		}
		else r = (r.left != null) ? r.left : r.right;
		return r;	
	} //Theta(log n)
	
	//removes the smallest data node in the tree.
	protected BinaryNode<AnyType> removeMin(BinaryNode<AnyType> t){        
		if(t == null)
			throw new NullPointerException();
		if(t.left != null){ 
			t.left = removeMin(t.left); //recursive call using left child
			return t;
		}
		else
			return t.right; //if t.left is null, the minimum will be the right child
	}//Theta(log n)
	
	//finds the smallest node in the tree.
	protected BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if(t != null) 
			while(t.left != null) //Smallest data will always be on the left subtree
				t = t.left;

		return t; 
	}//Theta(log n)
	
	/* Internal method to get element field.
	 * Return the data in the given field or null if t is null.
	 */
	private AnyType elementAt(BinaryNode<AnyType> t){
		return t == null ? null : t.data;
	}
	
	//inOrder method outputs a String list that recursively displays the data in the nodes of the tree. The order here sorts the list.
	protected String inOrder(BinaryNode<AnyType> t){
		String list = "";
		if(t != null){
			list += inOrder(t.left); //recursive call using left child
			list += t.data.toString(); //calls toString method in the object classes
			list += inOrder(t.right); //recursive call using right child
		}
		return list;
	} //Theta(1)
}