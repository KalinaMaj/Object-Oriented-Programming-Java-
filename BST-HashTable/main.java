import java.io.*;
import java.util.*;

/**Project 3 manages two lists of students and faculty using a binary search tree 
 * and a hashtable. Classes student and faculty hold 3 objects: first name, last 
 * name and an 8-digit ID number. The insertion into both data structures is 
 * done in alphabetical order by last name, or if they are equal, then by their first names. 
 * Hash function calculates index based off of the id of the student/faculty.
 * 
 * @author Kalina Majewska
 */
public class main{
	public static void main(String[] args) throws FileNotFoundException{
		//set up two text files to output the lists for both objects from.
		PrintWriter out1 = new PrintWriter("Student.txt");
		PrintWriter out2 = new PrintWriter("Faculty.txt");
		//students and faculty examples.
		Student s11 = new Student("Mary", "Paulino", "S7583944");
		Student s22 = new Student("Kalina", "Majewska", "S1234567");
		Student s33 = new Student("Nick", "Paulino", "S2974356");
		Faculty f11 = new Faculty("Mike", "Lee", "F5755473");
		Faculty f22 = new Faculty("John", "Doe", "F0078443");
		Faculty f33 = new Faculty("Carrie", "Richards", "F5662985");
		Faculty f44 = new Faculty("ToBe", "Removed", "F0000000");
		
		//initializing two BST's and one hashtable, managing students/faculty.
		BinarySearchTree<Student> Student = new BinarySearchTree<Student>();
		BinarySearchTree<Faculty> Faculty = new BinarySearchTree<Faculty>();
		HashTable<Faculty> hash = new HashTable<Faculty>();
		
		//Insertion and removal into the tree (see BST class)
		Student.insert(s11);
		Student.insert(s22);
		Student.insert(s33);
		Faculty.insert(f11);
		Faculty.insert(f44);
		Faculty.insert(f22);
		Faculty.insert(f33);
		Faculty.remove(f44);
		//Insertion and removal into hash (see HashTable class)
		hash.add(f11);
		hash.add(f44);
		hash.add(f22);
		hash.remove(f44);
		
		//Creating 2 lists 
		String studentList = Student.toString(); 
		String facultyList = Faculty.toString();
		String hashTable = hash.display();
		out1.print(studentList);
		out2.print(facultyList + System.lineSeparator());
		out2.print(System.lineSeparator() + "Hash Table: " + System.lineSeparator() + hashTable);
		
		//close files
		out1.close();
		out2.close();
	}//End main 	
}