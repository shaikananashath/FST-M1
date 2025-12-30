package activities;

public class Activity2 {

	public static void main(String[] args) {
		
		int[] arr= {10, 77, 10, 54, -11, 10};
		int Snum=10;
		int fixedSum=30;
		
		int sum=0;
		for(int num:arr) {
			if(num==Snum) {
				sum=sum+num;
			}
		}
		System.out.println("Sum of all the 10's: "+sum);
		
		if(fixedSum==sum) {
			System.out.println("The value of fixed sum and actucal sum is True.");
		}else {
			System.out.println("The value of fixed sum and actucal sum is False.");
		}
	}

}