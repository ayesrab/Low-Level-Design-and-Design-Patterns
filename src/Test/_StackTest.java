package Test;

public class _StackTest {
    public static void main(String[] args) {
        _Stack<Integer> stack = new _Stack<Integer>();
        stack.push(2);
        stack.push(1);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        _Stack<String> stack1 = new _Stack<String>();
        stack1.push("asd");
        stack1.push("cvb");
        _Queue<Double> queue = new _Queue<Double>();
        queue.offer(3.2);
        try {
            queue.poll();
            System.out.println(queue.poll());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
