package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
		List<String> myList = new ArrayList<>();
		myList.add("Poornima");
		myList.add("Priya");
		myList.add("Joe");
		myList.add("John");
		myList.add("Jack");
		
		for(String list : myList) {
			System.out.println(list);
		}
		
		System.out.println("Third name in the list: "+ myList.get(2));
		
		if(myList.contains("Joe")){
			System.out.println("Name found");
		}
		else {
			System.out.println("Name not found");
		}
		
		System.out.println("Number of names in the list: "+ myList.size());
		
		myList.remove(3);
		System.out.println("Number of names in the list after removing: "+ myList.size());

	}

}