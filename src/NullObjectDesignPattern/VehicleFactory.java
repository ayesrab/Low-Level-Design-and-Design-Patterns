package NullObjectDesignPattern;

public class VehicleFactory {
    public Vehicle getVehicle(String type){
        if(type.equalsIgnoreCase("car")){
            return new Car();
        }
        return new NullObject();
    }
}
