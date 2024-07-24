package NullObjectDesignPattern;

public class Car implements Vehicle {
    @Override
    public int tankCapacity() {
        return 40;
    }

    @Override
    public int seatCapacity() {
        return 5;
    }
}
