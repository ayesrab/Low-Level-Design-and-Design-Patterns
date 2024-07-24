package ParkingLot;

import java.time.LocalDateTime;

public class CostComputation {
    Ticket ticket;
    ParkingSpot parkingSpot;

    public CostComputation(Ticket ticket, ParkingSpot parkingSpot) {
        this.ticket = ticket;
        this.parkingSpot = parkingSpot;
    }

    int getCost() {
        int duration = LocalDateTime.now().getSecond() - this.ticket.entryTime.getSecond();
        return (int)(duration * this.parkingSpot.getPrice());
    }
}
