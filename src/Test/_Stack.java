package Test;

import java.util.ArrayDeque;

public class _Stack<K> {
    ArrayDeque<K> arrayDeque = new ArrayDeque<>();
    public void push(K a){
        arrayDeque.addFirst(a);
    }
    public K pop(){
        return arrayDeque.removeFirst();
    }
    public K peek(){
        return arrayDeque.peek();
    }
}
