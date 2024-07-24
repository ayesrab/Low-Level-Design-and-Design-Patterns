package CarRentalSystem;

import java.util.List;

public class VehicleInventoryManagement {
    List<Vehicle> vehicleList;

    public VehicleInventoryManagement(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void add(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    public List<Vehicle> getVehicleList() {
        //filtering
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
