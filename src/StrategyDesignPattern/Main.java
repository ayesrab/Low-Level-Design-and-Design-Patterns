package StrategyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new SportsVehicle();
        vehicle1.drive();
        Vehicle vehicle2 = new PassengerVehicle();
        vehicle2.drive();
    }
}
