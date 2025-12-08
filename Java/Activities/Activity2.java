
package activities;

public class Activity2 {

	public static void main(String[] args) {
		int[] numbers = {10, 77, 10, 54, -11, 10};
		int totalOfTens = 0;
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i]==10) {
				totalOfTens = totalOfTens+numbers[i];
			}
		}
		
		if(totalOfTens==30) {
			System.out.println("Test pass! Total of Tens is 30");
		}
		else
			System.out.println("Test failed!");
	}

}
