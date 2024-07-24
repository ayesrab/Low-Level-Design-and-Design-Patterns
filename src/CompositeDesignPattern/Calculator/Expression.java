package CompositeDesignPattern.Calculator;

public class Expression implements ArithmeticExpression{
    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    Operator operator;

    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, Operator operator) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int evaulate() {
        int value = 0;
        if(operator == Operator.ADD){
            value =  leftExpression.evaulate() + rightExpression.evaulate();
        }
        else if(operator == Operator.SUBTRACT){
            value =  leftExpression.evaulate() - rightExpression.evaulate();
        }
        else if(operator == Operator.MULTIPLY){
            value =  leftExpression.evaulate() * rightExpression.evaulate();
        }else if(operator == Operator.DIVIDE){
            value =  leftExpression.evaulate() / rightExpression.evaulate();
        }
        System.out.println("Expression value is : " + value);
        return value;
    }
}
