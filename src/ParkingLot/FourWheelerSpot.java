package ParkingLot;

public class FourWheelerSpot extends ParkingSpot{

    public FourWheelerSpot(String id, Vehicle vehicle) {
        super(id, vehicle);
    }
    public int getPrice(){
        return 20;
    }
}
