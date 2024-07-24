package Test;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class _Queue<K> {
    ArrayDeque<K> arrayDeque = new ArrayDeque<>();

    public void offer(K a){
        arrayDeque.addLast(a);
    }
    public K poll()throws Exception{
        if(!arrayDeque.isEmpty()){
            return arrayDeque.removeFirst();
        }
        throw new Exception("No Such element");
    }
    public K peek()throws Exception{
        if(!arrayDeque.isEmpty()){
            return arrayDeque.peek();
        }
        throw new Exception("No Such Element");
    }
}
