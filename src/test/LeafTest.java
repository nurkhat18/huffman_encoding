package test;

import model.Leaf;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeafTest {

    @Test
    //testing a leaf creation
    void testLeafCreation() {
        Leaf leaf = new Leaf('a', 5);
        assertNotNull(leaf);
        assertEquals('a', leaf.getLetter());
        assertEquals(5, leaf.getFrequency());
    }

    @Test
    //testing get letter method
    void testGetLetter() {
        Leaf leaf = new Leaf('b', 3);
        assertEquals('b', leaf.getLetter());
    }
}
