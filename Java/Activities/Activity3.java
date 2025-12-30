package activities;

public class Activity3 {

	public static void main(String[] args) {
		
		double sec= 1000000000;
		
		double earthSec = 31557600;
		double mercurySec = 0.2408467;
		double venusSec = 0.61519726;
		double marsSec = 1.8808158;
		double jupiterSec = 11.862615;
		double saturnSec = 29.447498;
		double uranusSec = 84.016846;
		double neptuneSec = 164.79132;
		
		System.out.println("Age on Mercury: "+sec/earthSec/mercurySec);
		System.out.println("Age on Venus: "+sec/earthSec/venusSec);
		System.out.println("Age on Mars: "+sec/earthSec/marsSec);
		System.out.println("Age on Jupiter: "+sec/earthSec/jupiterSec);
		System.out.println("Age on saturn: "+sec/earthSec/saturnSec);
		System.out.println("Age on Uranus: "+sec/earthSec/uranusSec);
		System.out.println("Age on Neptune: "+sec/earthSec/neptuneSec);
		

	}

}