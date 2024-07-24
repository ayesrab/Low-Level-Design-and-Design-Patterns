package ParkingLot;

import java.util.ArrayList;

public class ParkingManagerFactory {
    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType) {
        if(vehicleType == VehicleType.TWOWHEELER)
            return new TwoWheelerSpotManager(new ArrayList<>());
        if(vehicleType == VehicleType.FOURWHEELER)
            return new FourWheelerSpotManager(new ArrayList<>());
        return null;
    }
}
