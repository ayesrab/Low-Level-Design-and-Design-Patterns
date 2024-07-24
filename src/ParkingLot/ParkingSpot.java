package ParkingLot;

public class ParkingSpot {
    String id;
    Boolean isEmpty;
    Vehicle vehicle;
    int price;
    public ParkingSpot(String id, Vehicle vehicle) {
        this.id = id;
        this.isEmpty = true;
    }
    public int getPrice() {
        return price;
    }
    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isEmpty = false;
    }
    public void removeVehicle() {
        isEmpty = true;
        this.vehicle = null;
    }
}
