import java.util.ArrayList;
import java.util.List;

public class Cruise {
    private Ship ship;
    private List<Passenger> passengers;
    private List<Excursion> excursions;
    private List<Cabin> cabins;
    
    public Cruise(Ship ship) {
        this.ship = ship;
        this.passengers = new ArrayList<>();
        this.excursions = new ArrayList<>();
        this.cabins = new ArrayList<>();
    }
    
    public Ship getShip() {
        return ship;
    }
    
    public List<Passenger> getPassengers() {
        return passengers;
    }
    
    public List<Excursion> getExcursions() {
        return excursions;
    }
    
    public List<Cabin> getCabins() {
        return cabins;
    }
    
    public void addCabin(Cabin cabin) {
        cabins.add(cabin);
    }
    
    public void addExcursion(Excursion excursion) {
        if (excursions.size() < 3) { // Each cruise has 3 excursions
            excursions.add(excursion);
        }
    }
    
    public boolean addPassenger(Passenger passenger) {
        if (!passengers.contains(passenger)) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }
    
    public List<Cabin> getVacantCabins() {
        List<Cabin> vacant = new ArrayList<>();
        for (Cabin cabin : cabins) {
            if (cabin.isEmpty()) {
                vacant.add(cabin);
            }
        }
        return vacant;
    }
    
    public List<Excursion> getAvailableExcursions(Passenger passenger) {
        List<Excursion> available = new ArrayList<>();
        for (Excursion excursion : excursions) {
            if (!excursion.isFull() && !passenger.isOnExcursion(excursion)) {
                available.add(excursion);
            }
        }
        return available;
    }
    
    @Override
    public String toString() {
        return ship.getName() + " Cruise";
    }
}