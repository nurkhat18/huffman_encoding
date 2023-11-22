/*
 * Swarn
 */
package test;

import model.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    //Testing node creation
    void testNodeCreation() {
        Node node = new Node(10);
        assertNotNull(node);
        assertEquals(10, node.getFrequency());
    }

    @Test
    //testing node creation with children
    void testNodeCreationWithChild() {
        Node leftChild = new Node(5);
        Node rightChild = new Node(7);
        Node parentNode = new Node(leftChild, rightChild);
        assertNotNull(parentNode);
        assertEquals(12, parentNode.getFrequency());
        assertEquals(leftChild, parentNode.getLeftNode());
        assertEquals(rightChild, parentNode.getRightNode());
    }

    @Test
    //testing node comparison 
    void testCompareTo() {
        Node node1 = new Node(5);
        Node node2 = new Node(10);
        assertTrue(node1.compareTo(node2) < 0);
        assertTrue(node2.compareTo(node1) > 0);
        assertEquals(0, node1.compareTo(node1));
    }
}
