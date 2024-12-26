public abstract class Cabin {
    private String number;
    private Passenger[] passengers;
    
    public Cabin(String number, int maxPassengers) {
        this.number = number;
        this.passengers = new Passenger[maxPassengers];
    }
    
    public String getNumber() {
        return number;
    }
    
    public boolean addPassenger(Passenger passenger) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                return true;
            }
        }
        return false;  // Cabin is full
    }
    
    public boolean removePassenger(Passenger passenger) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == passenger) {
                passengers[i] = null;
                return true;
            }
        }
        return false;  // Passenger not found
    }
    
    public Passenger[] getPassengers() {
        return passengers;
    }
    
    public boolean isFull() {
        for (Passenger p : passengers) {
            if (p == null) return false;
        }
        return true;
    }
    
    public boolean isEmpty() {
        for (Passenger p : passengers) {
            if (p != null) return false;
        }
        return true;
    }
}