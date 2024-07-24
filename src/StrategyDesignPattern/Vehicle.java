package StrategyDesignPattern;

public class Vehicle {
    DriveStratergy driveStratergy;

    public Vehicle(DriveStratergy driveStratergy) {
        this.driveStratergy = driveStratergy;
    }

    public void drive() {
        driveStratergy.drive();
    }
}
