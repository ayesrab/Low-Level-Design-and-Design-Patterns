package ParkingLot;

public class EntranceGate {
    ParkingSpotManager parkingSpotManager;
    ParkingManagerFactory parkingManagerFactory;
    Ticket ticket;


    public EntranceGate(ParkingManagerFactory parkingManagerFactory, ParkingSpotManager parkingSpotManager) {
        this.parkingManagerFactory = parkingManagerFactory;
        this.parkingSpotManager = parkingSpotManager;

    }
    public ParkingSpot findSpace(){
        return this.parkingSpotManager.findSpace();
    }
    public void bookSpot(Vehicle vehicle,ParkingSpot parkingSpot){
        parkingSpot.parkVehicle(vehicle);
        generateTicket(vehicle,parkingSpot);
    }
    public void generateTicket(Vehicle vehicle,ParkingSpot parkingSpot){
        this.ticket = new Ticket(vehicle,parkingSpot);
    }
    public Ticket getTicket(){
        return ticket;
    }
}
