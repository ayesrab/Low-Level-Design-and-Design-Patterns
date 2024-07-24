package FactoryPattern;

public class ShapeFactory {

    public Shape getShape(String shapeType){
        if (shapeType.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        else if (shapeType.equalsIgnoreCase("circle")){
            return new Circle();
        }
        return null;
    }
}
