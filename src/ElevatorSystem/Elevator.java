package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    List<Request> requests;
    int id;
    int capacity;
    int currentFloor;
    Direction curentDirection;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.curentDirection = Direction.UP;
        this.currentFloor = 1;
        this.requests = new ArrayList<>();
    }

    public synchronized void addRequest(Request request) {
        if(requests.size()< capacity){
            requests.add(request);
            System.out.println("Elevator " + id + " added request: " + request);
            notifyAll();
        }
    }
    public synchronized Request getNextRequest() {
        while(requests.isEmpty()){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return requests.remove(0);
    }
    public synchronized void processRequests() {
        while(true){
            while(!requests.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void processRequest(Request request) {
        int destinationFloor = request.getDestinationFloor();
        int startFloor = this.currentFloor;
        if(startFloor < destinationFloor){
            curentDirection = Direction.UP;
            for(int i=startFloor; i<=destinationFloor; i++){
                this.currentFloor = i;
                System.out.println("Elevator " + id + " reached floor " + currentFloor);
                try {
                    Thread.sleep(1000); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(startFloor > destinationFloor){
            curentDirection = Direction.DOWN;
            for(int i=startFloor; i>=destinationFloor; i--){
                this.currentFloor = i;
                System.out.println("Elevator " + id + " reached floor " + currentFloor);
                try {
                    Thread.sleep(1000); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        setCurrentFloor(destinationFloor);
    }
    public void run(){
        processRequests();
    }
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
