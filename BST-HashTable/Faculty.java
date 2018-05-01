/**Same as Student class: Faculty class defines the Object faculty, that is characterized by
 * facultie's first and last name and an 8-digit ID number. The class
 * holds get and set methods for each characteristic, equals method
 * that compared faculty ID's, compareTo method implementation used to
 * compare by their last name, and a toString method outputting 
 * the full name and ID.
 */

public class Faculty implements Comparable<Faculty>{
	
	//hidden variables of the class
	private String firstName;
	private String lastName;
	private String iD;
	
	public Faculty(String a, String b, String c){ //Constructor
		setFirst(a);
		setLast(b);
		setID(c);
	}
	
	//get and set methods
	public void setFirst(String n) {firstName = n;}
	public void setLast(String l) {lastName = l;}
	public void setID(String x){iD = x;} 

	public String getFirst() {return firstName;}
	public String getLast() {return lastName;}
	public String getID(){return iD;}
	
	//output of a string that displays first name, last name and ID number.
	public String toString(){
		return firstName + " " + lastName + ", " + iD + System.lineSeparator();
	}
	
	//compares the object's id to faculty id.
	public boolean equals(Object t){
		if(!(t instanceof Faculty)) //tests if object is faculty type
			return false;
		Faculty fID = (Faculty) t;
		if(fID.iD.length() > 8) //tests ID length
			return false;
		return fID.iD == t;
	} //Theta(1)
	
	//compares two faculty by last name
	public int compareTo(Faculty f){
		if(f.lastName == null)
			throw new NullPointerException();
		if(f.lastName.equals(lastName)){ //if both last names are the same, compare first names
			return this.firstName.compareTo(f.firstName); 
		}
		else{
			return this.lastName.compareTo(f.lastName); //compareTo ensured the last names of both Objects are compared lexicographically
		}
	}//Theta(1)

}
