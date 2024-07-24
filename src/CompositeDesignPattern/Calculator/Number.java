package CompositeDesignPattern.Calculator;

public class Number implements ArithmeticExpression{
    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int evaulate() {
        System.out.println("Number is : " + value);
        return value;
    }
}
