package StrategyDesignPattern;

public class PassengerVehicle extends Vehicle {

    PassengerVehicle(){
        super(new NormalDriveStratergy());
    }
}
