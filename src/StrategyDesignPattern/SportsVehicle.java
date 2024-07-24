package StrategyDesignPattern;

public class SportsVehicle extends Vehicle {

    SportsVehicle(){
        super(new SpecialDriveStratergy());
    }
}
