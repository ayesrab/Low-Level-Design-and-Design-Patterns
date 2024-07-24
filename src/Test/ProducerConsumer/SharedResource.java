package Test.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    SharedResource(int size){
        sharedBuffer = new LinkedList<>();
        bufferSize = size;
    }

    public synchronized void produce(int a) throws Exception{
        while(sharedBuffer.size() == bufferSize){
            System.out.println("Buffer is already full. Waiting for consumer");
            wait();
        }
        sharedBuffer.add(a);
        System.out.println("Item added = " + a);
        notify();
    }

    public synchronized int consume() throws Exception{
        while(sharedBuffer.isEmpty()){
            System.out.println("Buffer already empty. Waiting for Produces");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("Item consumed = " + item);
        notify();
        return item;
    }
}
