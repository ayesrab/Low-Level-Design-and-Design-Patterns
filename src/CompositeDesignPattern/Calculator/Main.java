package CompositeDesignPattern.Calculator;

public class Main {
    public static void main(String[] args) {
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);
        ArithmeticExpression two = new Number(2);

        ArithmeticExpression addExpression = new Expression(one,seven,Operator.ADD);
        ArithmeticExpression multiplyExpression = new Expression(two,addExpression,Operator.MULTIPLY);
        System.out.println(multiplyExpression.evaulate());

    }
}
