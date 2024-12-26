import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String dayOfWeek;
    private Port destination;
    private int maxPassengers;
    private List<Passenger> passengers;
    
    public Excursion(String dayOfWeek, Port destination, int maxPassengers) {
        this.dayOfWeek = dayOfWeek;
        this.destination = destination;
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }
    
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    
    public Port getDestination() {
        return destination;
    }
    
    public int getMaxPassengers() {
        return maxPassengers;
    }
    
    public List<Passenger> getPassengers() {
        return passengers;
    }
    
    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < maxPassengers && !passengers.contains(passenger)) {
            passengers.add(passenger);
            passenger.addExcursion(this);
            return true;
        }
        return false;
    }
    
    public boolean removePassenger(Passenger passenger) {
        if (passengers.remove(passenger)) {
            passenger.removeExcursion(this);
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        return passengers.size() >= maxPassengers;
    }
    
    public int getAvailableSpaces() {
        return maxPassengers - passengers.size();
    }
    
    @Override
    public String toString() {
        return destination.getName() + " (" + dayOfWeek + ")";
    }
}