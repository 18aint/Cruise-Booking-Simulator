public class Suite extends Cabin {
    private boolean hasBalcony;
    private static final int MAX_PASSENGERS = 4;
    
    public Suite(String number, boolean hasBalcony) {
        super(number, MAX_PASSENGERS);  // Suite can accommodate up to 4 passengers
        this.hasBalcony = hasBalcony;
    }
    
    public boolean hasBalcony() {
        return hasBalcony;
    }
    
    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }
    
    @Override
    public String toString() {
        return "Suite " + getNumber() + (hasBalcony ? " (with balcony)" : " (no balcony)");
    }
}