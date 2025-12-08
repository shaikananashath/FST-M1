package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
	public List<String> passengers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;
    
    Plane(int maxPassengers){
    	this.maxPassengers = maxPassengers;
    	this.passengers = new ArrayList<>();   	
    }
    
    public void onboard(String passengerName) {
    	if(passengers.size()<maxPassengers)
    	{
    	this.passengers.add(passengerName);
    	}
    	else {
    		System.out.println("No seats available..Plane is full");
    	}
    }
    
    public Date takeOff() {
    	this.lastTimeTookOf= new Date();
    	return lastTimeTookOf;
    }
    
    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }
    
    public List<String> getPassengers(){
    	return passengers;
    }
}