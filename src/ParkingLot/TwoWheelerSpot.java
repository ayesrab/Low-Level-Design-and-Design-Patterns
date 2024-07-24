package ParkingLot;

public class TwoWheelerSpot extends ParkingSpot{
    public TwoWheelerSpot(String id, Vehicle vehicle) {
        super(id, vehicle);
    }
    public int getPrice(){
        return 10;
    }

}
