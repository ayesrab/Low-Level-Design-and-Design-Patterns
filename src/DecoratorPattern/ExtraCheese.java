package DecoratorPattern;

public class ExtraCheese extends TopperDecorator{
    BasePizza pizza;

    public ExtraCheese(BasePizza pizza){
        this.pizza = pizza;
    }
    @Override
    public int cost() {
        return this.pizza.cost() + 10;
    }
}
