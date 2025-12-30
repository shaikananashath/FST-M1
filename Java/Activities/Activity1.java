package activities;

public class Activity1 {

	public static void main(String[] args) {
		
		Car Tata = new Car();
		Tata.make=2020;
		Tata.color="Black";
		Tata.transmission="Manual";
		
		Tata.displayCharacterstics();
		Tata.move();
		Tata.stop();

	}

	public Activity1() {
		super();
	}

}