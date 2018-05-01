public class HashTable<AnyType> {

	private Node<AnyType>[] listArray;
	private int tableSize = 1000;

	public HashTable(){
		listArray = new Node[tableSize];
	}

	private int hashFunc(String f){
		int hashVal = 0;
		int id = Integer.parseInt(f.replaceAll("[^0-9]", ""));
		hashVal = hashVal + id;
		hashVal %= tableSize;
		if(hashVal < 0)
			hashVal += tableSize;

		return hashVal;
	}

	public boolean add(AnyType x){
		int list = hashFunc(x.toString());
		for(Node<AnyType> n = listArray[list]; n != null; n = n.next){
			if(n.data.equals(x))
				return false;
		}

		listArray[list] = new Node<AnyType>(x, listArray[list]);
		return true;
	}

	public boolean remove(AnyType x){
		int index = hashFunc(x.toString());
		if (listArray[index].data == x){
			listArray[index] = null;
			return true;
		}
		return false;
	}

	public boolean contains(AnyType x, Node<AnyType> n){
		for(n = listArray[hashFunc(x.toString())]; n != null; n = n.next){
			if(n.data.equals(x))
				return true;
		}
		return false;
	}
	
	public String display(){
		String hashList = "";
		for(int i = 0; i < listArray.length; i++){
			if(listArray[i] != null)
				hashList += listArray[i].data.toString();
		}
		return hashList;
	}

	private static class Node<AnyType>{
		AnyType data;
		Node<AnyType> next;

		Node(AnyType d, Node<AnyType> n){
			data = d;
			next = n;
		}
	}

}
