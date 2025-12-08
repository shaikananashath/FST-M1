package activities;

public class MountainBike extends Bicycle{
	int seatHeight;
	public MountainBike(int gears, int currentSpeed, int seatHt) {
		super(gears,currentSpeed);
		seatHeight = seatHt;
	
	}
	
	public void setHeight(int newValue) {
	    seatHeight = newValue;	    
	}
	
	public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nSeat height: " + seatHeight);
    }
}