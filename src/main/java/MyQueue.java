import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public boolean isEmpty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }

    public int size() {
        return this.stack1.size() + this.stack2.size();
    }

    public void enQueue(int num) {
        stack1.push(num);
    }

    public int deQueue() {
        if (isEmpty()) throw new IllegalArgumentException("queue is empty");

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int first() {
        if (isEmpty()) throw new IllegalArgumentException("queue is empty");

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }
}
