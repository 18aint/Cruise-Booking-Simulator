# Cruise Booking Simulator

A Java-based cruise booking management system that simulates cruise ship operations, passenger management, and excursion bookings.

## Features

- **Cruise Management**
  - Multiple cruise ships and itineraries
  - Cabin allocation and management
  - Passenger tracking
  - Excursion scheduling

- **Booking System**
  - Real-time cabin availability
  - Excursion booking with capacity management
  - Passenger cabin reassignment
  - Booking validation

- **Cabin Types**
  - Suite cabins
  - Standard cabins
  - Ocean view options

- **Excursion Management**
  - Port-specific excursions
  - Capacity tracking
  - Schedule management
  - Passenger participation tracking

## System Requirements

- Java 11 or higher
- Console-based interface

## Getting Started

1. Clone the repository:

bash
git clone https://github.com/18aint/cruise-booking.git
cd cruise-booking


2. Compile the project:

bash
javac CruiseManager.java


3. Run the application:

bash
java CruiseManager


## Usage

### Main Menu Options

1. **Display Cruise Information**
   - View ship details
   - Check passenger counts
   - See excursion availability

2. **Display Excursion Information**
   - List available excursions
   - View excursion schedules
   - Check participant lists

3. **Display Passenger Information**
   - View passenger details
   - Check cabin assignments
   - See booked excursions

4. **Book Excursion**
   - Select cruise and passenger
   - Choose available excursions
   - Confirm booking

5. **Change Passenger Cabin**
   - View vacant cabins
   - Select passenger
   - Reassign cabin

## Project Structure

cruise-booking/
├── src/
│ ├── CruiseManager.java
│ ├── models/
│ │ ├── Cruise.java
│ │ ├── Ship.java
│ │ ├── Cabin.java
│ │ ├── Passenger.java
│ │ ├── Excursion.java
│ │ └── Port.java
│ └── utils/
│ └── ValidationUtils.java
├── README.md
└── LICENSE


## Features in Detail

### Cabin Management
- Cabin type differentiation
- Occupancy tracking
- View/balcony options
- Capacity management

### Excursion System
- Port-specific activities
- Schedule coordination
- Capacity limits
- Booking validation

### Passenger Management
- Personal information tracking
- Cabin assignments
- Excursion bookings
- Booking history

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Built as part of university coursework
- Inspired by real cruise booking systems
- Designed for educational purposes
