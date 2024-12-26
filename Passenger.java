import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private Cabin cabin;
    private List<Excursion> excursions;
    
    public Passenger(String name) {
        this.name = name;
        this.excursions = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public Cabin getCabin() {
        return cabin;
    }
    
    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }
    
    public List<Excursion> getExcursions() {
        return excursions;
    }
    
    public boolean addExcursion(Excursion excursion) {
        if (!excursions.contains(excursion)) {
            excursions.add(excursion);
            return true;
        }
        return false;
    }
    
    public boolean removeExcursion(Excursion excursion) {
        return excursions.remove(excursion);
    }
    
    public boolean isOnExcursion(Excursion excursion) {
        return excursions.contains(excursion);
    }
    
    @Override
    public String toString() {
        return name;
    }
}