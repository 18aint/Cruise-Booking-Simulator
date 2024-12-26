import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CruiseManager {
    private List<Cruise> cruises;
    private Scanner scanner;
    
    public CruiseManager() {
        cruises = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void initializeTestData() {
        // Create ships
        Ship ship1 = new Ship("Mediterranean Dream");
        Ship ship2 = new Ship("Sunset Voyager");
        
        // Create ports
        Port rome = new Port("Rome");
        Port athens = new Port("Athens");
        Port barcelona = new Port("Barcelona");
        Port malta = new Port("Malta");
        
        // Create cruises
        Cruise cruise1 = new Cruise(ship1);
        Cruise cruise2 = new Cruise(ship2);
        
        // Create cabins for cruise1
        cruise1.addCabin(new Suite("S101", true));
        cruise1.addCabin(new Suite("S102", false));
        cruise1.addCabin(new StandardCabin("C201", true));
        cruise1.addCabin(new StandardCabin("C202", false));
        
        // Create cabins for cruise2
        cruise2.addCabin(new Suite("S201", true));
        cruise2.addCabin(new Suite("S202", true));
        cruise2.addCabin(new StandardCabin("C301", true));
        cruise2.addCabin(new StandardCabin("C302", false));
        
        // Create excursions for cruise1
        Excursion rome1 = new Excursion("Monday", rome, 30);
        Excursion athens1 = new Excursion("Wednesday", athens, 25);
        Excursion barcelona1 = new Excursion("Friday", barcelona, 35);
        
        cruise1.addExcursion(rome1);
        cruise1.addExcursion(athens1);
        cruise1.addExcursion(barcelona1);
        
        // Create excursions for cruise2
        Excursion malta2 = new Excursion("Tuesday", malta, 20);
        Excursion athens2 = new Excursion("Thursday", athens, 25);
        Excursion rome2 = new Excursion("Saturday", rome, 30);
        
        cruise2.addExcursion(malta2);
        cruise2.addExcursion(athens2);
        cruise2.addExcursion(rome2);
        
        // Create some passengers and assign them to cabins and excursions
        Passenger p1 = new Passenger("John Smith");
        Passenger p2 = new Passenger("Mary Johnson");
        Passenger p3 = new Passenger("Peter Brown");
        
        cruise1.addPassenger(p1);
        cruise1.addPassenger(p2);
        cruise1.getCabins().get(0).addPassenger(p1);
        cruise1.getCabins().get(0).addPassenger(p2);
        rome1.addPassenger(p1);
        athens1.addPassenger(p2);
        
        cruise2.addPassenger(p3);
        cruise2.getCabins().get(1).addPassenger(p3);
        malta2.addPassenger(p3);
        
        cruises.add(cruise1);
        cruises.add(cruise2);
    }
    
    public void displayMenu() {
        while (true) {
            System.out.println("\n----- Cruise Management System -----");
            System.out.println("1. Display Cruise Information");
            System.out.println("2. Display Excursion Information");
            System.out.println("3. Display Passenger Information");
            System.out.println("4. Book Excursion");
            System.out.println("5. Change Passenger Cabin");
            System.out.println("0. Exit");
            System.out.print("Enter choice:> ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    return;
                case 1:
                    displayCruiseInformation();
                    break;
                case 2:
                    displayExcursionInformation();
                    break;
                case 3:
                    displayPassengerInformation();
                    break;
                case 4:
                    bookExcursion();
                    break;
                case 5:
                    changePassengerCabin();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private Cruise selectCruise() {
        System.out.println("\nAvailable Cruises:");
        for (int i = 0; i < cruises.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, cruises.get(i).getShip().getName());
        }
        
        System.out.print("Select cruise (1-" + cruises.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (choice >= 1 && choice <= cruises.size()) {
            return cruises.get(choice - 1);
        }
        return null;
    }
    
    private void displayCruiseInformation() {
        Cruise cruise = selectCruise();
        if (cruise == null) {
            System.out.println("Invalid cruise selection.");
            return;
        }
        
        System.out.println("\nCruise Information:");
        System.out.println("Ship: " + cruise.getShip().getName());
        System.out.println("Number of passengers: " + cruise.getPassengers().size());
        System.out.println("\nExcursions:");
        
        for (Excursion excursion : cruise.getExcursions()) {
            System.out.printf("- %s (%s): ", excursion.getDestination().getName(), excursion.getDayOfWeek());
            if (excursion.isFull()) {
                System.out.println("FULLY BOOKED");
            } else {
                System.out.println(excursion.getAvailableSpaces() + " spaces available");
            }
        }
    }
    
    private void displayExcursionInformation() {
        Cruise cruise = selectCruise();
        if (cruise == null) {
            System.out.println("Invalid cruise selection.");
            return;
        }
        
        System.out.println("\nAvailable Excursions:");
        List<Excursion> excursions = cruise.getExcursions();
        for (int i = 0; i < excursions.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, excursions.get(i).getDestination().getName());
        }
        
        System.out.print("Select excursion (1-" + excursions.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (choice >= 1 && choice <= excursions.size()) {
            Excursion excursion = excursions.get(choice - 1);
            List<Passenger> passengers = excursion.getPassengers();
            
            System.out.println("\nExcursion to " + excursion.getDestination().getName());
            System.out.println("Day: " + excursion.getDayOfWeek());
            System.out.println("Passengers:");
            
            if (passengers.isEmpty()) {
                System.out.println("No passengers booked for this excursion.");
            } else {
                Collections.sort(passengers, Comparator.comparing(Passenger::getName));
                for (Passenger p : passengers) {
                    System.out.println("- " + p.getName());
                }
            }
        }
    }
    
    private void displayPassengerInformation() {
        Cruise cruise = selectCruise();
        if (cruise == null) {
            System.out.println("Invalid cruise selection.");
            return;
        }
        
        List<Passenger> passengers = cruise.getPassengers();
        if (passengers.isEmpty()) {
            System.out.println("No passengers on this cruise.");
            return;
        }
        
        Collections.sort(passengers, Comparator.comparing(Passenger::getName));
        System.out.println("\nPassengers:");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, passengers.get(i).getName());
        }
        
        System.out.print("Select passenger (1-" + passengers.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (choice >= 1 && choice <= passengers.size()) {
            Passenger passenger = passengers.get(choice - 1);
            displayPassengerDetails(passenger);
        }
    }
    
    private void displayPassengerDetails(Passenger passenger) {
        System.out.println("\nPassenger Details:");
        System.out.println("Name: " + passenger.getName());
        
        Cabin cabin = passenger.getCabin();
        System.out.println("Cabin: " + cabin.toString());
        
        // Display cabin mates
        System.out.println("Sharing cabin with:");
        boolean hasRoommates = false;
        for (Passenger p : cabin.getPassengers()) {
            if (p != null && p != passenger) {
                System.out.println("- " + p.getName());
                hasRoommates = true;
            }
        }
        if (!hasRoommates) {
            System.out.println("No other passengers in this cabin");
        }
        
        // Display excursions
        System.out.println("\nBooked Excursions:");
        List<Excursion> excursions = passenger.getExcursions();
        if (excursions.isEmpty()) {
            System.out.println("No excursions booked");
        } else {
            for (Excursion e : excursions) {
                System.out.printf("- %s (%s)%n", e.getDestination().getName(), e.getDayOfWeek());
            }
        }
    }
    
    private void bookExcursion() {
        Cruise cruise = selectCruise();
        if (cruise == null) {
            System.out.println("Invalid cruise selection.");
            return;
        }
        
        // Select passenger
        List<Passenger> passengers = cruise.getPassengers();
        Collections.sort(passengers, Comparator.comparing(Passenger::getName));
        System.out.println("\nPassengers:");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, passengers.get(i).getName());
        }
        
        System.out.print("Select passenger (1-" + passengers.size() + "): ");
        int passengerChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (passengerChoice < 1 || passengerChoice > passengers.size()) {
            System.out.println("Invalid passenger selection.");
            return;
        }
        
        Passenger passenger = passengers.get(passengerChoice - 1);
        List<Excursion> availableExcursions = cruise.getAvailableExcursions(passenger);
        
        if (availableExcursions.isEmpty()) {
            System.out.println("No available excursions for this passenger.");
            return;
        }
        
        System.out.println("\nAvailable Excursions:");
        for (int i = 0; i < availableExcursions.size(); i++) {
            Excursion e = availableExcursions.get(i);
            System.out.printf("%d. %s (%s) - %d spaces available%n", 
                i + 1, 
                e.getDestination().getName(), 
                e.getDayOfWeek(),
                e.getAvailableSpaces());
        }
        
        System.out.print("Select excursion (1-" + availableExcursions.size() + ", 0 to cancel): ");
        int excursionChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (excursionChoice == 0) {
            System.out.println("Booking cancelled.");
            return;
        }
        
        if (excursionChoice >= 1 && excursionChoice <= availableExcursions.size()) {
            Excursion excursion = availableExcursions.get(excursionChoice - 1);
            if (excursion.addPassenger(passenger)) {
                System.out.println("Excursion booked successfully!");
            } else {
                System.out.println("Error booking excursion.");
            }
        }
    }
    
    private void changePassengerCabin() {
        Cruise cruise = selectCruise();
        if (cruise == null) {
            System.out.println("Invalid cruise selection.");
            return;
        }
        
        List<Cabin> vacantCabins = cruise.getVacantCabins();
        if (vacantCabins.isEmpty()) {
            System.out.println("No vacant cabins available on this cruise.");
            return;
        }
        
        System.out.println("\nVacant Cabins:");
        for (int i = 0; i < vacantCabins.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, vacantCabins.get(i).toString());
        }
        
        System.out.print("Continue with cabin change? (1 for yes, 0 for no): ");
        int continue_choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (continue_choice != 1) {
            System.out.println("Cabin change cancelled.");
            return;
        }
        
        // Select passenger
        List<Passenger> passengers = cruise.getPassengers();
        Collections.sort(passengers, Comparator.comparing(Passenger::getName));
        System.out.println("\nSelect passenger to move:");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.printf("%d. %s (Current cabin: %s)%n", 
                i + 1, 
                passengers.get(i).getName(),
                passengers.get(i).getCabin().getNumber());
        }
        
        System.out.print("Select passenger (1-" + passengers.size() + "): ");
        int passengerChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (passengerChoice < 1 || passengerChoice > passengers.size()) {
            System.out.println("Invalid passenger selection.");
            return;
        }
        
        Passenger passengerToMove = passengers.get(passengerChoice - 1);
        System.out.print("Select new cabin (1-" + vacantCabins.size() + "): ");
        int cabinChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (cabinChoice >= 1 && cabinChoice <= vacantCabins.size()) {
            Cabin oldCabin = passengerToMove.getCabin();
            Cabin newCabin = vacantCabins.get(cabinChoice - 1);
            
            // Move all passengers from old cabin to new cabin
           // Move all passengers from old cabin to new cabin
            for (Passenger p : oldCabin.getPassengers()) {
                if (p != null) {
                    oldCabin.removePassenger(p);
                    newCabin.addPassenger(p);
                    p.setCabin(newCabin);
                }
            }
            System.out.println("Cabin change completed successfully!");
        } else {
            System.out.println("Invalid cabin selection.");
        }
    }
}