package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservationList = new ArrayList<>();

    public List<Vehicle> getAllVehicles(VehicleType vehicleType) {
        return vehicleInventoryManagement.getVehicleList();
    }

    public void setVehicleInventoryManagement(List<Vehicle> vehicleList) {
        this.vehicleInventoryManagement = new VehicleInventoryManagement(vehicleList);
    }

    public Reservation createReservation(User user, Vehicle vehicle) {
        Reservation reservation = new Reservation();
        reservation.createReserve(user,vehicle);
        reservationList.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationID) {

        //take out the reservation from the list and call complete the reservation method.
        return true;
    }

}
