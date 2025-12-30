package activities;
import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> hm= new HashMap<>();
		am.put(1, "Red");
		am.put(2, "Pink");
		am.put(3, "Blue");
		am.put(4, "White");
		am.put(5, "Black");
		
		System.out.println("All colors present in the map: "+am);
		
		am.remove(2);
		
		System.out.println("After removing pair ar index 2: "+am);
		
		if(hm.containsValue("Green")) {
			System.out.println("Green exist in the map");
		}else {
			System.out.println("Green is not present in the map");
		}
		
		System.out.println("Number of pairs in the map: "+am.size());

	}

}