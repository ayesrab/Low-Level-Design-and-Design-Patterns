package StrategyDesignPattern;

public class NormalDriveStratergy implements DriveStratergy {
    @Override
    public void drive() {
        System.out.println("NormalDriveStratergy");
    }
}
