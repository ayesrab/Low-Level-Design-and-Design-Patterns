package DecoratorPattern;

public class Mushroom extends TopperDecorator{
    BasePizza pizza;

    public Mushroom(BasePizza pizza){
        this.pizza = pizza;
    }
    @Override
    public int cost() {
        return this.pizza.cost() + 20;
    }
}
