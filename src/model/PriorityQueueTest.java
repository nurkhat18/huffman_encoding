// this file is to test the priorityQueueTest.java
import org.junit.Test;
import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void testEnqueueAndPeek() {
        PriorityQueue priorityQueue = new PriorityQueue(5);

        priorityQueue.enqueue('A', 2);
        priorityQueue.enqueue('B', 4);
        priorityQueue.enqueue('C', 4);

        assertEquals('B', priorityQueue.peek()); 
    }

    @Test
    public void testDequeue() {
        PriorityQueue priorityQueue = new PriorityQueue(5);

        priorityQueue.enqueue('A', 2);
        priorityQueue.enqueue('B', 4);
        priorityQueue.enqueue('C', 4);

        priorityQueue.dequeue();
        assertEquals('C', priorityQueue.peek());  
    }

    @Test
    public void testEmptyQueue() {
        PriorityQueue priorityQueue = new PriorityQueue(5);

        assertTrue(priorityQueue.isEmpty()); 

        priorityQueue.enqueue('A', 2);
        priorityQueue.dequeue();

        assertTrue(priorityQueue.isEmpty()); 
    }

}
