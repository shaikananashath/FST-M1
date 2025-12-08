package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		Map<Integer,String> colours = new HashMap<Integer,String>();
		colours.put(1, "Red");
		colours.put(2, "Blue");
		colours.put(3, "Black");
		colours.put(4, "White");
		colours.put(5, "Green");
		
		System.out.println("Available colours: "+ colours);
		
		colours.remove(3, "Black");
		System.out.println("Available colours after removal: "+ colours);
		
		if(colours.containsValue("White")) {
			System.out.println("White is available");
		}
		else
			System.out.println("White is not present");
		
		System.out.println("Size of the map: "+ colours.size());
	}

}