package activities;

public class Activity4 {

	public static void main(String[] args) {
		// Array sorting
		int[] numbers = {40,10,60,20,5};
		System.out.print("Before sort: ");
		for (int num: numbers) {
			System.out.print(num+" ");
		}
		for(int i=1; i<numbers.length; i++) {
			int x = numbers[i];
			int j = i-1;
			while (j >= 0 && numbers[j] > x) {
				numbers[j+1] = numbers[j];
				j--;				
			}
			numbers[j+1] = x;
		}
		System.out.print("\nAfter sort: ");
		for (int num: numbers) {
			System.out.print(num+" ");
		}
	}

}