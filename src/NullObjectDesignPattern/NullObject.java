package NullObjectDesignPattern;

public class NullObject implements Vehicle{
    @Override
    public int tankCapacity() {
        return 0;
    }

    @Override
    public int seatCapacity() {
        return 0;
    }
}
