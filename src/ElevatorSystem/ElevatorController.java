package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    public List<Elevator> elevators;

    public ElevatorController(int noOfElevators, int capacity) {
        elevators = new ArrayList<>();
        for (int i = 0; i < noOfElevators; i++) {
            Elevator elevator = new Elevator(i + 1, capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }
    public void requestElevator(int sourceFloor,int destinationFloor) {
        Elevator optimalElevator = findOptimalElevator(sourceFloor);
        optimalElevator.addRequest(new Request(sourceFloor, destinationFloor));
    }
    private synchronized Elevator findOptimalElevator(int sourceFloor) {
        int minGap = Integer.MAX_VALUE;
        Elevator optimalElevator = null;
        for(Elevator elevator : elevators) {
            System.out.println("id : " + elevator.id + " CurrentFlor : " + elevator.getCurrentFloor());
            int gap = Math.abs(sourceFloor - elevator.getCurrentFloor());
            //System.out.println("gap : " + gap);
            if(gap < minGap) {
                minGap = gap;
                optimalElevator = elevator;
            }
        }
        return optimalElevator;
    }
}
