package activities;

public class Bicycle implements BicycleParts, BicycleOperations{
	public int gears;
	public int currentSpeed;

	@Override
	public void applyBrake(int decrement) {
		currentSpeed = currentSpeed - decrement;
		System.out.println("Current speed after brake: "+currentSpeed);		
	}

	@Override
	public void speedUp(int increment) {
		currentSpeed = currentSpeed + increment;
		System.out.println("Current speed after speeding up: "+currentSpeed);				
	}
	
	public Bicycle(int gears, int currentSpeed) {
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}
	
	public String bicycleDesc() {
		return("Number of gears: "+ gears+ "\nMax speed: "+ maxSpeed);
	}
}