 //Basic node stored in a binary search tree.

class BinaryNode<AnyType>{
	
	AnyType data;              //The data contained in the node
	BinaryNode<AnyType> left;  //Left child
	BinaryNode<AnyType> right; //Right child
	
	//Constructor
	BinaryNode(AnyType element){
		data = element;
		left = right = null;
	} 
}
