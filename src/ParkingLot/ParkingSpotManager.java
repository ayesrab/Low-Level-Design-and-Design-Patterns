package ParkingLot;

import java.util.List;

public class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;
    ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findSpace(){
        for (ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isEmpty)
                return parkingSpot;
        }
        return null;
    }
    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.remove(parkingSpot);
    }
    public void parkVehicle(Vehicle vehicle,ParkingSpot parkingSpot) {
        parkingSpot.parkVehicle(vehicle);
    }
    public void unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.vehicle == vehicle){
                parkingSpot.removeVehicle();
            }
        }
    }
    public ParkingSpot getParkingSpot(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.vehicle == vehicle) {
                return parkingSpot;
            }
        }
        return null;
    }
}
