import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void isEmpty() {
        MyQueue myQueue = new MyQueue();
        assertTrue(myQueue.isEmpty());

        myQueue.enQueue(1);
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void size() {
        MyQueue myQueue = new MyQueue();

        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        assertEquals(3, myQueue.size());
    }

    @Test
    public void test_enQueue_and_deQueue() {
        MyQueue myQueue = new MyQueue();

        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);

        assertEquals(1, myQueue.deQueue());
        assertEquals(2, myQueue.deQueue());
        assertEquals(3, myQueue.deQueue());
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void first() {
        MyQueue myQueue = new MyQueue();

        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);

        assertEquals(1, myQueue.first());
    }
}