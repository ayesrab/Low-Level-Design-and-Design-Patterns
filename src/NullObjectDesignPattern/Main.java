package NullObjectDesignPattern;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle = factory.getVehicle("truck");

        System.out.println(vehicle.seatCapacity());
        System.out.println(vehicle.tankCapacity());
    }
}
