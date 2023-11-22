/*
 * Swarn
 * It is for testing huffman
 */
package test;

import model.Huffman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HuffmanTest {

    private Huffman huffman;

    @BeforeEach
    //setup to correctly test the huffman class
    void setup() {
        huffman = new Huffman("sample code to test huffman class");
    }

    @Test
    //testing the encoding method of huffman class
    void testEncoding() {
        String encoded = huffman.getEncodedText();
        assertNotNull(encoded);
            }

    @Test
    //testing the decoding method of huffman class
    void testDecoding() {
        String encoded = huffman.getEncodedText();
        String decoded = huffman.decode(encoded);
        assertEquals("sample code to test huffman class", decoded);
    }


}
