package activities;
import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		
		ArrayList<String> myList= new ArrayList<String>();
		myList.add("apple");
		myList.add("mango");
		myList.add("banana");
		myList.add("orange");
		myList.add("pineapple");
		
		System.out.println("Printing all the fruits using enhanced for loop");
		for(String c:myList) {
			System.out.println(c);
		}
		
		System.out.println("3rd element in myList: "+myList.get(2));
		System.out.println("Is mango present in myList: "+myList.contains("mango"));
		System.out.println("Size of myList: "+myList.size());
		
		myList.remove(3);
		System.out.println("Size of myList after removing an element: "+myList.size());
	}

}