package DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza1 = new ExtraCheese(new Margarita());
        System.out.println(pizza1.cost());
        BasePizza pizza2 = new Mushroom(new ExtraCheese(new VegDelight()));
        System.out.println(pizza2.cost());
    }
}
