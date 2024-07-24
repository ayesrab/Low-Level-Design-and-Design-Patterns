package ParkingLot;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("BMW", VehicleType.FOURWHEELER);
        ParkingManagerFactory parkingManagerFactory = new ParkingManagerFactory();
        ParkingSpotManager parkingSpotManager= parkingManagerFactory.getParkingSpotManager(vehicle1.vehicleType);
        for(int i =1;i<=5;i++)
            parkingSpotManager.addParkingSpot(new FourWheelerSpot(String.valueOf(i),null));
        EntranceGate entranceGate = new EntranceGate(parkingManagerFactory,parkingSpotManager);
        ParkingSpot parkingSpot = entranceGate.findSpace();
        entranceGate.bookSpot(vehicle1,parkingSpot);
        Ticket ticket = entranceGate.getTicket();
        try{
            Thread.currentThread().sleep(3000);
        }catch (InterruptedException e){}
        ExitGate exitGate = new ExitGate(parkingManagerFactory,vehicle1,ticket, new CostComputation(ticket,parkingSpot));
        System.out.println(exitGate.priceCalculator());
    }
}
