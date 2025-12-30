package activities;
import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		
		HashSet<Integer> hs= new HashSet<>();
		as.add(100);
		as.add(200);
		as.add(300);
		as.add(400);
		as.add(500);
		as.add(600);
		
		System.out.println("Size of elements in set: "+as.size());
		
		as.remove(400);
		
		if(as.remove(700)) {
			System.out.println("700 removed from the list");
		}else {
			System.out.println("700 is not present in the set");
		}
		
		System.out.println("is 400 present in the set: "+ as.contains(400));
		System.out.println("Updated set: "+as);

	}

}