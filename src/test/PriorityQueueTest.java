/*
 * Swarn
 */

package test;
import org.junit.Test;

import model.Leaf;
import model.PriorityQueue;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    //testing priority queue enqueue
    public void testEnqueueAndPeek() {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.enqueue(new Leaf('A', 2));
        priorityQueue.enqueue(new Leaf('B', 4));
        priorityQueue.enqueue(new Leaf('C', 4));
        Leaf l = (Leaf) priorityQueue.peek();
        assertEquals('B', l.getLetter()); 
    }

    @Test
    //testing dequeue
    public void testDequeue() {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.enqueue(new Leaf('A', 2));
        priorityQueue.enqueue(new Leaf('B', 4));
        priorityQueue.enqueue(new Leaf('C', 4));
        priorityQueue.dequeue();
        Leaf l= (Leaf) priorityQueue.peek();
        assertEquals('C', l.getLetter());  
    }

    @Test
    //testing an empty queue
    public void testEmptyQueue() {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        assertTrue(priorityQueue.isEmpty()); 
        priorityQueue.enqueue(new Leaf('A', 2));
        priorityQueue.dequeue();
        assertTrue(priorityQueue.isEmpty()); 
    }

}

