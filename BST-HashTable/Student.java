/**Student class defines the Object student, that is characterized by a
 * student's first and last name and an 8-digit ID number. The class
 * holds get and set methods for each characteristic, equals method
 * that compared student's ID's, compareTo method implementation used to
 * compare Students by their last name, and a toString method outputting 
 * the full name and ID.
 */

public class Student implements Comparable<Student> {

	//hidden variables of the class
	private String firstName;
	private String lastName;
	private String studentID;
	
	public Student(String a, String b, String c){ //Constructor
		setFirst(a);
		setLast(b);
		setID(c);
	}
	
	//get and set methods
	public void setFirst(String n) {firstName = n;}
	public void setLast(String l) {lastName = l;}
	public void setID(String x){studentID = x;} 

	public String getFirst() {return firstName;}
	public String getLast() {return lastName;}
	public String getID(){return studentID;}
	
	//output of a string that displays first name, last name and ID number.
	public String toString(){
		return firstName + " " + lastName + ", " + studentID + System.lineSeparator();
	}
	
	//compares the object's id to faculty id.
	public boolean equals(Object t){
		if(!(t instanceof Student)) //tests if object is student type
			return false;
		Student sID = (Student) t;
		if(sID.studentID.length() > 8) //tests ID length
			return false;
		return sID.studentID == t;
	}//Theta(1)
	
	//compares two students by last name
	public int compareTo(Student s){
		if(s.lastName == null)
			throw new NullPointerException();
		if(s.lastName.equals(lastName)){ //if both last names are the same, compare first names
			return this.firstName.compareTo(s.firstName);
		}
		else{
			return this.lastName.compareTo(s.lastName); //compareTo ensured the last names of both Objects are compared lexicographically
		}
	}//Theta(1)
			
}

	