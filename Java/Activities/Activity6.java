package activities;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

	public void onboard(String passengerName) {
        if(passengers.size() <= maxPassengers) {
            this.passengers.add(passengerName);
        } else {
            System.out.println("Plane is full");
        }
    }

    public Date takeOff() {
        this.lastTimeTookOf = new Date(maxPassengers);
        return lastTimeTookOf;
    }

    public void land() {
        this.lastTimeLanded = new Date(maxPassengers);
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }
}

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        //plane with max 10 passengers
        Plane plane = new Plane(10);
        //Adding passengers on the list
        plane.onboard("John");
        plane.onboard("Steve");
        plane.onboard("Anna");
        //plane takes off
        System.out.println("Plane took off at: " + plane.takeOff());
        //printing list of people on board
        System.out.println("People on the plane: " + plane.getPassengers());
        //Flying.....
        Thread.sleep(5000);
        //Plane has landed
        plane.land();
        //Plane lands
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }
}