package ParkingLot;

public class ExitGate {
    Ticket ticket;
    ParkingSpotManager parkingSpotManager;
    ParkingManagerFactory parkingManagerFactory;
    Vehicle vehicle;
    CostComputation costComputation;

    ExitGate(ParkingManagerFactory parkingManagerFactory,Vehicle vehicle,Ticket ticket,CostComputation costComputation){
        this.parkingManagerFactory = parkingManagerFactory;
        this.parkingSpotManager = this.parkingManagerFactory.getParkingSpotManager(vehicle.vehicleType);
        this.ticket = ticket;
        this.costComputation = costComputation;
    }

    public int priceCalculator(){
        ParkingSpot parkingSpot = parkingSpotManager.getParkingSpot(vehicle);
        parkingSpotManager.unparkVehicle(vehicle);
        return this.costComputation.getCost();
    }

}
