public class StandardCabin extends Cabin {
    private boolean hasSeaView;
    private static final int MAX_PASSENGERS = 6;
    
    public StandardCabin(String number, boolean hasSeaView) {
        super(number, MAX_PASSENGERS);  // StandardCabin can accommodate up to 6 passengers
        this.hasSeaView = hasSeaView;
    }
    
    public boolean hasSeaView() {
        return hasSeaView;
    }
    
    public void setHasSeaView(boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }
    
    @Override
    public String toString() {
        return "Standard Cabin " + getNumber() + (hasSeaView ? " (with sea view)" : " (no sea view)");
    }
}