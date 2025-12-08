package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		Set<String> hs = new HashSet<String>();
		hs.add("Poornima");
		hs.add("Priya");
		hs.add("Joe");
		hs.add("John");
		hs.add("Jack");
		hs.add("Ram");
		
		System.out.println("Size of the set: "+ hs.size());
		
		hs.remove("Jack");
		System.out.println("After removing: "+ hs);
		if(hs.remove("Julie")) {
			System.out.println("Julie removed from the set");
		}
		else {
			System.out.println("Julie not present in the set");
		}
		if(hs.contains("Joe")) {
			System.out.println("Name found");
		}
		else
			System.out.println("Name not found");
		
		System.out.println("Updated set: "+ hs);
		
	}

}