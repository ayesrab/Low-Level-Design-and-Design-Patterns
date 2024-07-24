package ParkingLot;

import java.time.LocalDateTime;

public class Ticket {
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }
}
